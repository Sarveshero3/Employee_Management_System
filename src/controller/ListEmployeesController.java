// src/controller/ListEmployeesController.java

package controller;

import model.Employee;
import model.EmployeeDAO;
import view.ListEmployeesView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListEmployeesController {
    private ListEmployeesView listEmployeesView;
    private EmployeeDAO employeeDAO;

    public ListEmployeesController(ListEmployeesView listEmployeesView, String password) {
        this.listEmployeesView = listEmployeesView;
        this.employeeDAO = new EmployeeDAO(password);
        loadEmployees();
    }

    public void loadEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        DefaultTableModel tableModel = listEmployeesView.getTableModel();
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
