// src/controller/UpdateEmployeeController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employee;
import model.EmployeeDAO;
import view.UpdateEmployeeView;

import javax.swing.JOptionPane;

public class UpdateEmployeeController implements ActionListener {
    private UpdateEmployeeView updateEmployeeView;
    private EmployeeDAO employeeDAO;

    public UpdateEmployeeController(UpdateEmployeeView updateEmployeeView, String password) {
        this.updateEmployeeView = updateEmployeeView;
        this.employeeDAO = new EmployeeDAO(password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Search")) {
            String employeeIdStr = updateEmployeeView.getEmployeeId();
            int employeeId;
            try {
                employeeId = Integer.parseInt(employeeIdStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Employee ID.");
                return;
            }

            Employee emp = employeeDAO.getEmployeeById(employeeId);
            if (emp != null) {
                // Populate fields
                updateEmployeeView.setFirstName(emp.getFirstName());
                updateEmployeeView.setLastName(emp.getLastName());
                updateEmployeeView.setPosition(emp.getPosition());
                updateEmployeeView.setSalary(String.valueOf(emp.getSalary()));
                updateEmployeeView.setDateOfJoining(emp.getDateOfJoining());
                updateEmployeeView.setEmail(emp.getEmail());
                updateEmployeeView.setPhoneNumber(emp.getPhoneNumber());
                updateEmployeeView.setAddress(emp.getAddress());
                updateEmployeeView.setEmergencyContactName(emp.getEmergencyContactName());
                updateEmployeeView.setEmergencyContactPhone(emp.getEmergencyContactPhone());

                updateEmployeeView.setFieldsEditable(true);
                updateEmployeeView.enableUpdateButton(true);
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }
        } else if (actionCommand.equals("Update Employee")) {
            // Collect data
            String firstName = updateEmployeeView.getFirstName();
            String lastName = updateEmployeeView.getLastName();
            String position = updateEmployeeView.getPosition();
            String salaryStr = updateEmployeeView.getSalary();
            String dateOfJoiningStr = updateEmployeeView.getDateOfJoining();
            String email = updateEmployeeView.getEmail();
            String phoneNumber = updateEmployeeView.getPhoneNumber();
            String address = updateEmployeeView.getAddress();
            String emergencyContactName = updateEmployeeView.getEmergencyContactName();
            String emergencyContactPhone = updateEmployeeView.getEmergencyContactPhone();

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

            // Update Employee object
            Employee emp = new Employee();
            emp.setEmployeeId(Integer.parseInt(updateEmployeeView.getEmployeeId()));
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

            // Update employee in Excel file
            boolean success = employeeDAO.updateEmployee(emp);
            if (success) {
                JOptionPane.showMessageDialog(null, "Employee updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update employee.");
            }
        }
    }
}
