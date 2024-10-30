package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection conn;

    public EmployeeDAO() {
        conn = DBConnection.getConnection();
    }

    // Add Employee
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (first_name, last_name, position, salary, date_of_joining, email, phone_number, address, emergency_contact_name, emergency_contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());
            stmt.setDate(5, emp.getDateOfJoining());
            stmt.setString(6, emp.getEmail());
            stmt.setString(7, emp.getPhoneNumber());
            stmt.setString(8, emp.getAddress());
            stmt.setString(9, emp.getEmergencyContactName());
            stmt.setString(10, emp.getEmergencyContactPhone());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Update Employee
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET first_name=?, last_name=?, position=?, salary=?, date_of_joining=?, email=?, phone_number=?, address=?, emergency_contact_name=?, emergency_contact_phone=? WHERE employee_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getFirstName());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getPosition());
            stmt.setDouble(4, emp.getSalary());
            stmt.setDate(5, emp.getDateOfJoining());
            stmt.setString(6, emp.getEmail());
            stmt.setString(7, emp.getPhoneNumber());
            stmt.setString(8, emp.getAddress());
            stmt.setString(9, emp.getEmergencyContactName());
            stmt.setString(10, emp.getEmergencyContactPhone());
            stmt.setInt(11, emp.getEmployeeId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Partial Update Employee (Position, Salary, Phone Number)
    public boolean updateEmployeePartial(Employee emp) {
        String sql = "UPDATE employees SET position=?, salary=?, phone_number=? WHERE employee_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, emp.getPosition());
            stmt.setDouble(2, emp.getSalary());
            stmt.setString(3, emp.getPhoneNumber());
            stmt.setInt(4, emp.getEmployeeId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete Employee
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE employee_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get Employee by ID
    public Employee getEmployeeById(int employeeId) {
        String sql = "SELECT * FROM employees WHERE employee_id=?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setPosition(rs.getString("position"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDateOfJoining(rs.getDate("date_of_joining"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNumber(rs.getString("phone_number"));
                emp.setAddress(rs.getString("address"));
                emp.setEmergencyContactName(rs.getString("emergency_contact_name"));
                emp.setEmergencyContactPhone(rs.getString("emergency_contact_phone"));

                return emp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setPosition(rs.getString("position"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDateOfJoining(rs.getDate("date_of_joining"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNumber(rs.getString("phone_number"));
                emp.setAddress(rs.getString("address"));
                emp.setEmergencyContactName(rs.getString("emergency_contact_name"));
                emp.setEmergencyContactPhone(rs.getString("emergency_contact_phone"));

                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Salary Report
    public List<Employee> getEmployeesBySalaryDesc() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY salary DESC";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setPosition(rs.getString("position"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setDateOfJoining(rs.getDate("date_of_joining"));
                emp.setEmail(rs.getString("email"));
                emp.setPhoneNumber(rs.getString("phone_number"));
                emp.setAddress(rs.getString("address"));
                emp.setEmergencyContactName(rs.getString("emergency_contact_name"));
                emp.setEmergencyContactPhone(rs.getString("emergency_contact_phone"));

                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Position-wise Employee Count
public List<PositionCount> getPositionWiseCount() {
    List<PositionCount> counts = new ArrayList<>();
    String sql = "SELECT position, COUNT(*) as count FROM employees GROUP BY position";
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            PositionCount pc = new PositionCount();
            pc.setPosition(rs.getString("position"));
            pc.setCount(rs.getInt("count"));
            counts.add(pc);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return counts;
}
}