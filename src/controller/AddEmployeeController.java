package controller;

import model.Employee;
import model.EmployeeDAO;
import view.AddEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JOptionPane;

public class AddEmployeeController implements ActionListener {
    private AddEmployeeView addEmployeeView;
    private EmployeeDAO employeeDAO;

    public AddEmployeeController(AddEmployeeView addEmployeeView) {
        this.addEmployeeView = addEmployeeView;
        this.employeeDAO = new EmployeeDAO();

        // Register this controller as the listener for the save button
        addEmployeeView.getSaveButton().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        // Collect data from the view
        String firstName = addEmployeeView.getFirstName().trim();
        String lastName = addEmployeeView.getLastName().trim();
        String position = addEmployeeView.getPosition().trim();
        String salaryStr = addEmployeeView.getSalary().trim();
        String dateOfJoiningStr = addEmployeeView.getDateOfJoining().trim();
        String email = addEmployeeView.getEmail().trim();
        String phoneNumber = addEmployeeView.getPhoneNumber().trim();
        String address = addEmployeeView.getAddress().trim();
        String emergencyContactName = addEmployeeView.getEmergencyContactName().trim();
        String emergencyContactPhone = addEmployeeView.getEmergencyContactPhone().trim();

        // Validate mandatory fields
        if (firstName.isEmpty() || lastName.isEmpty() || position.isEmpty() || salaryStr.isEmpty() || dateOfJoiningStr.isEmpty()) {
            JOptionPane.showMessageDialog(addEmployeeView.getPanel(), "Please fill in all mandatory fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert salary to double
        double salary;
        try {
            salary = Double.parseDouble(salaryStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(addEmployeeView.getPanel(), "Invalid salary format.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convert dateOfJoining to java.sql.Date
        Date dateOfJoining;
        try {
            dateOfJoining = Date.valueOf(dateOfJoiningStr); // Format: yyyy-[m]m-[d]d
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(addEmployeeView.getPanel(), "Invalid date format. Use yyyy-mm-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create Employee object
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setPosition(position);
        emp.setSalary(salary);
        emp.setDateOfJoining(dateOfJoining);
        emp.setEmail(email);
        emp.setPhoneNumber(phoneNumber);
        emp.setAddress(address);
        emp.setEmergencyContactName(emergencyContactName);
        emp.setEmergencyContactPhone(emergencyContactPhone);

        // Add employee to database
        boolean success = employeeDAO.addEmployee(emp);

        if (success) {
            JOptionPane.showMessageDialog(addEmployeeView.getPanel(), "Employee added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Clear the form
            addEmployeeView.clearForm();
        } else {
            JOptionPane.showMessageDialog(addEmployeeView.getPanel(), "Failed to add employee.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
