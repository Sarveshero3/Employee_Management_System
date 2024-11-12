// src/controller/DeleteEmployeeController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employee;
import model.EmployeeDAO;
import view.DeleteEmployeeView;

import javax.swing.JOptionPane;

public class DeleteEmployeeController implements ActionListener {
    private DeleteEmployeeView deleteEmployeeView;
    private EmployeeDAO employeeDAO;

    public DeleteEmployeeController(DeleteEmployeeView deleteEmployeeView, String password) {
        this.deleteEmployeeView = deleteEmployeeView;
        this.employeeDAO = new EmployeeDAO(password);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Search")) {
            String employeeIdStr = deleteEmployeeView.getEmployeeId();
            int employeeId;
            try {
                employeeId = Integer.parseInt(employeeIdStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid Employee ID.");
                return;
            }

            Employee emp = employeeDAO.getEmployeeById(employeeId);
            if (emp != null) {
                // Display employee details
                String details = "Employee ID: " + emp.getEmployeeId() + "\n"
                        + "Name: " + emp.getFirstName() + " " + emp.getLastName() + "\n"
                        + "Position: " + emp.getPosition() + "\n"
                        + "Salary: " + emp.getSalary() + "\n"
                        + "Date of Joining: " + emp.getDateOfJoining() + "\n"
                        + "Email: " + emp.getEmail() + "\n"
                        + "Phone: " + emp.getPhoneNumber() + "\n"
                        + "Address: " + emp.getAddress() + "\n"
                        + "Emergency Contact: " + emp.getEmergencyContactName() + " - " + emp.getEmergencyContactPhone();
                deleteEmployeeView.setEmployeeDetails(details);
                deleteEmployeeView.enableDeleteButton(true);
            } else {
                JOptionPane.showMessageDialog(null, "Employee not found.");
            }
        } else if (actionCommand.equals("Delete Employee")) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int employeeId = Integer.parseInt(deleteEmployeeView.getEmployeeId());
                boolean success = employeeDAO.deleteEmployee(employeeId);
                if (success) {
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully.");
                    deleteEmployeeView.setEmployeeDetails("");
                    deleteEmployeeView.enableDeleteButton(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete employee.");
                }
            }
        }
    }
}
