// src/model/EmployeeDAO.java

package model;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.poifs.crypt.*;
import org.apache.poi.poifs.filesystem.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static final String FILE_NAME = "EmployeeData.xlsx";
    private static final String SHEET_NAME = "Employees";
    private String password;

    public EmployeeDAO(String password) {
        this.password = password;
    }

    // Add Employee
    public boolean addEmployee(Employee emp) {
        List<Employee> employees = getAllEmployees();
        employees.add(emp);
        return saveEmployees(employees);
    }

    // Update Employee
    public boolean updateEmployee(Employee emp) {
        List<Employee> employees = getAllEmployees();
        boolean updated = false;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId() == emp.getEmployeeId()) {
                employees.set(i, emp);
                updated = true;
                break;
            }
        }
        if (updated) {
            return saveEmployees(employees);
        }
        return false;
    }

    // Delete Employee
    public boolean deleteEmployee(int employeeId) {
        List<Employee> employees = getAllEmployees();
        boolean deleted = employees.removeIf(emp -> emp.getEmployeeId() == employeeId);
        if (deleted) {
            return saveEmployees(employees);
        }
        return false;
    }

    // Get Employee by ID
    public Employee getEmployeeById(int employeeId) {
        List<Employee> employees = getAllEmployees();
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employeeId) {
                return emp;
            }
        }
        return null;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (InputStream inp = getDecryptedInputStream()) {
            if (inp == null) {
                return employees;
            }
            Workbook workbook = WorkbookFactory.create(inp);
            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                workbook.close();
                return employees;
            }
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row
                Employee emp = new Employee();
                emp.setEmployeeId((int) row.getCell(0).getNumericCellValue());
                emp.setFirstName(row.getCell(1).getStringCellValue());
                emp.setLastName(row.getCell(2).getStringCellValue());
                emp.setPosition(row.getCell(3).getStringCellValue());
                emp.setSalary(row.getCell(4).getNumericCellValue());
                emp.setDateOfJoining(row.getCell(5).getStringCellValue());
                emp.setEmail(row.getCell(6).getStringCellValue());
                emp.setPhoneNumber(row.getCell(7).getStringCellValue());
                emp.setAddress(row.getCell(8).getStringCellValue());
                emp.setEmergencyContactName(row.getCell(9).getStringCellValue());
                emp.setEmergencyContactPhone(row.getCell(10).getStringCellValue());
                employees.add(emp);
            }
            workbook.close();
        } catch (Exception e) {
            // File may not exist yet
        }
        return employees;
    }

    // Save Employees to Excel File
    public boolean saveEmployees(List<Employee> employees) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(SHEET_NAME);

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = { "Employee ID", "First Name", "Last Name", "Position", "Salary", "Date of Joining",
                    "Email", "Phone Number", "Address", "Emergency Contact Name", "Emergency Contact Phone" };
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            // Fill data
            int rowNum = 1;
            for (Employee emp : employees) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(emp.getEmployeeId());
                row.createCell(1).setCellValue(emp.getFirstName());
                row.createCell(2).setCellValue(emp.getLastName());
                row.createCell(3).setCellValue(emp.getPosition());
                row.createCell(4).setCellValue(emp.getSalary());
                row.createCell(5).setCellValue(emp.getDateOfJoining());
                row.createCell(6).setCellValue(emp.getEmail());
                row.createCell(7).setCellValue(emp.getPhoneNumber());
                row.createCell(8).setCellValue(emp.getAddress());
                row.createCell(9).setCellValue(emp.getEmergencyContactName());
                row.createCell(10).setCellValue(emp.getEmergencyContactPhone());
            }

            // Write to file with password protection
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            if (password != null && !password.isEmpty()) {
                POIFSFileSystem fs = new POIFSFileSystem();
                EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
                Encryptor enc = info.getEncryptor();
                enc.confirmPassword(password);

                OutputStream os = enc.getDataStream(fs);
                workbook.write(os);
                os.close();

                fs.writeFilesystem(fos);
                fs.close();
            } else {
                workbook.write(fos);
            }
            fos.close();
            workbook.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private InputStream getDecryptedInputStream() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return null;
        }
        if (password != null && !password.isEmpty()) {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(FILE_NAME));
            EncryptionInfo info = new EncryptionInfo(fs);
            Decryptor dec = Decryptor.getInstance(info);
            if (!dec.verifyPassword(password)) {
                throw new RuntimeException("Unable to process: incorrect password");
            }
            return dec.getDataStream(fs);
        } else {
            return new FileInputStream(FILE_NAME);
        }
    }

    // Salary Report
    public List<Employee> getEmployeesBySalaryDesc() {
        List<Employee> employees = getAllEmployees();
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        return employees;
    }

    // Position-wise Employee Count
    public List<PositionCount> getPositionWiseCount() {
        List<Employee> employees = getAllEmployees();
        List<PositionCount> counts = new ArrayList<>();
        employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(Employee::getPosition, java.util.stream.Collectors.counting()))
                .forEach((position, count) -> counts.add(new PositionCount(position, count.intValue())));
        return counts;
    }
}
