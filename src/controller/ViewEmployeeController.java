package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Employee;
import model.EmployeeDAO;
import view.ViewEmployeeView;

import javax.swing.JOptionPane;

public class ViewEmployeeController implements ActionListener {
    private ViewEmployeeView viewEmployeeView;
    private EmployeeDAO employeeDAO;

    public ViewEmployeeController(ViewEmployeeView viewEmployeeView) {
        this.viewEmployeeView = viewEmployeeView;
        this.employeeDAO = new EmployeeDAO();
        // Register this controller as the listener for the view button
        viewEmployeeView.addViewButtonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String employeeIdStr = viewEmployeeView.getEmployeeId().trim();
        int employeeId;
        try {
            employeeId = Integer.parseInt(employeeIdStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(viewEmployeeView.getPanel(), "Invalid Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);
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
            viewEmployeeView.setEmployeeDetails(details);
        } else {
            JOptionPane.showMessageDialog(viewEmployeeView.getPanel(), "Employee not found.", "Error", JOptionPane.ERROR_MESSAGE);
            viewEmployeeView.setEmployeeDetails("");
        }
    }
}
