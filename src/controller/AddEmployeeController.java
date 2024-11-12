// src/controller/AddEmployeeController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employee;
import model.EmployeeDAO;
import view.AddEmployeeView;

import javax.swing.JOptionPane;

public class AddEmployeeController implements ActionListener {
    private AddEmployeeView addEmployeeView;
    private EmployeeDAO employeeDAO;

    public AddEmployeeController(AddEmployeeView addEmployeeView, String password) {
        this.addEmployeeView = addEmployeeView;
        this.employeeDAO = new EmployeeDAO(password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collect data from the view
        String firstName = addEmployeeView.getFirstName();
        String lastName = addEmployeeView.getLastName();
        String position = addEmployeeView.getPosition();
        String salaryStr = addEmployeeView.getSalary();
        String dateOfJoiningStr = addEmployeeView.getDateOfJoining();
        String email = addEmployeeView.getEmail();
        String phoneNumber = addEmployeeView.getPhoneNumber();
        String address = addEmployeeView.getAddress();
        String emergencyContactName = addEmployeeView.getEmergencyContactName();
        String emergencyContactPhone = addEmployeeView.getEmergencyContactPhone();

        // Input validation
        if (firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "First Name and Last Name are required.");
            return;
        }

        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid salary format.");
            return;
        }

        int newEmployeeId = employeeDAO.getAllEmployees().size() + 1;

        // Create Employee object
        Employee emp = new Employee();
        emp.setEmployeeId(newEmployeeId);
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPosition(position);
        emp.setSalary(salary);
        emp.setDateOfJoining(dateOfJoiningStr);
        emp.setEmail(email);
        emp.setPhoneNumber(phoneNumber);
        emp.setAddress(address);
        emp.setEmergencyContactName(emergencyContactName);
        emp.setEmergencyContactPhone(emergencyContactPhone);

        // Add employee to Excel file
        boolean success = employeeDAO.addEmployee(emp);
        if (success) {
            JOptionPane.showMessageDialog(null, "Employee added successfully.");
            // Optionally clear fields
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add employee.");
        }
    }
}
