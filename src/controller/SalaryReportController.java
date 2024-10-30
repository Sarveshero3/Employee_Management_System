package controller;

import model.Employee;
import model.EmployeeDAO;
import view.SalaryReportView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SalaryReportController {
    private SalaryReportView salaryReportView;
    private EmployeeDAO employeeDAO;

    public SalaryReportController(SalaryReportView salaryReportView) {
        this.salaryReportView = salaryReportView;
        this.employeeDAO = new EmployeeDAO();
        loadSalaryReport();
    }

    public void loadSalaryReport() {
        List<Employee> employees = employeeDAO.getEmployeesBySalaryDesc();
        DefaultTableModel tableModel = salaryReportView.getTableModel();
        tableModel.setRowCount(0); // Clear existing data

        for (Employee emp : employees) {
            Object[] rowData = {
                emp.getEmployeeId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getPosition(),
                emp.getSalary()
            };
            tableModel.addRow(rowData);
        }
    }
}
