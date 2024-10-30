package controller;

import model.Employee;
import model.EmployeeDAO;
import view.UpdateEmployeeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class UpdateEmployeeController {
    private UpdateEmployeeView updateEmployeeView;
    private EmployeeDAO employeeDAO;
    private Employee currentEmployee;

    public UpdateEmployeeController(UpdateEmployeeView updateEmployeeView) {
        this.updateEmployeeView = updateEmployeeView;
        this.employeeDAO = new EmployeeDAO();

        // Register listeners
        updateEmployeeView.addLoadButtonListener(new LoadButtonListener());
        updateEmployeeView.addUpdateButtonListener(new UpdateButtonListener());
    }

    // Listener for Load Button
    private class LoadButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String employeeIdStr = updateEmployeeView.getEmployeeId();
            int employeeId;
            try {
                employeeId = Integer.parseInt(employeeIdStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Invalid Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            currentEmployee = employeeDAO.getEmployeeById(employeeId);
            if (currentEmployee != null) {
                // Populate fields
                updateEmployeeView.setPosition(currentEmployee.getPosition());
                updateEmployeeView.setSalary(String.valueOf(currentEmployee.getSalary()));
                updateEmployeeView.setPhoneNumber(currentEmployee.getPhoneNumber());

                // Enable fields and update button
                updateEmployeeView.setFieldsEditable(true);
                updateEmployeeView.getUpdateButton().setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Listener for Update Button
    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentEmployee == null) {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "No employee loaded.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Collect updated data
            String position = updateEmployeeView.getPosition();
            String salaryStr = updateEmployeeView.getSalary();
            String phoneNumber = updateEmployeeView.getPhoneNumber();

            // Validate mandatory fields
            if (position.isEmpty() || salaryStr.isEmpty()) {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Please fill in all mandatory fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Convert salary to double
            double salary;
            try {
                salary = Double.parseDouble(salaryStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Invalid salary format.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update employee object
            currentEmployee.setPosition(position);
            currentEmployee.setSalary(salary);
            currentEmployee.setPhoneNumber(phoneNumber);

            // Update employee in database
            boolean success = employeeDAO.updateEmployeePartial(currentEmployee);

            if (success) {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Employee updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Clear the form
                updateEmployeeView.setFieldsEditable(false);
                updateEmployeeView.getUpdateButton().setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(updateEmployeeView.getPanel(), "Failed to update employee.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
