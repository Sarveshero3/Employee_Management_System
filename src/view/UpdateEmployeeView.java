// src/view/UpdateEmployeeView.java

package view;

import javax.swing.*;
import java.awt.*;
import controller.UpdateEmployeeController;

public class UpdateEmployeeView {
    private JPanel panel;
    private JTextField employeeIdField;
    private JButton searchButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField positionField;
    private JTextField salaryField;
    private JTextField dateOfJoiningField;
    private JTextField emailField;
    private JTextField phoneNumberField;
    private JTextField addressField;
    private JTextField emergencyContactNameField;
    private JTextField emergencyContactPhoneField;
    private JButton updateButton;
    private String password;

    public UpdateEmployeeView(String password) {
        this.password = password;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Top panel for searching
        JPanel searchPanel = new JPanel(new FlowLayout());
        employeeIdField = new JTextField(15);
        searchButton = new JButton("Search");
        searchPanel.add(new JLabel("Employee ID:"));
        searchPanel.add(employeeIdField);
        searchPanel.add(searchButton);

        // Center panel for employee details
        JPanel detailsPanel = new JPanel(new GridLayout(10, 2, 10, 10));
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        positionField = new JTextField(20);
        salaryField = new JTextField(20);
        dateOfJoiningField = new JTextField(20);
        emailField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        addressField = new JTextField(20);
        emergencyContactNameField = new JTextField(20);
        emergencyContactPhoneField = new JTextField(20);

        detailsPanel.add(new JLabel("First Name:"));
        detailsPanel.add(firstNameField);
        detailsPanel.add(new JLabel("Last Name:"));
        detailsPanel.add(lastNameField);
        detailsPanel.add(new JLabel("Position:"));
        detailsPanel.add(positionField);
        detailsPanel.add(new JLabel("Salary:"));
        detailsPanel.add(salaryField);
        detailsPanel.add(new JLabel("Date of Joining (yyyy-mm-dd):"));
        detailsPanel.add(dateOfJoiningField);
        detailsPanel.add(new JLabel("Email:"));
        detailsPanel.add(emailField);
        detailsPanel.add(new JLabel("Phone Number:"));
        detailsPanel.add(phoneNumberField);
        detailsPanel.add(new JLabel("Address:"));
        detailsPanel.add(addressField);
        detailsPanel.add(new JLabel("Emergency Contact Name:"));
        detailsPanel.add(emergencyContactNameField);
        detailsPanel.add(new JLabel("Emergency Contact Phone:"));
        detailsPanel.add(emergencyContactPhoneField);

        // Disable fields initially
        setFieldsEditable(false);

        // Bottom panel for update button
        JPanel updatePanel = new JPanel(new FlowLayout());
        updateButton = new JButton("Update Employee");
        updateButton.setEnabled(false);
        updatePanel.add(updateButton);

        // Add panels to main panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(updatePanel, BorderLayout.SOUTH);

        // Add action listeners
        UpdateEmployeeController controller = new UpdateEmployeeController(this, password);
        searchButton.addActionListener(controller);
        updateButton.addActionListener(controller);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getEmployeeId() {
        return employeeIdField.getText();
    }

    public void setEmployeeId(String employeeId) {
        this.employeeIdField.setText(employeeId);
    }

    // Getters and setters for fields
    public String getFirstName() {
        return firstNameField.getText();
    }

    public void setFirstName(String firstName) {
        this.firstNameField.setText(firstName);
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public void setLastName(String lastName) {
        this.lastNameField.setText(lastName);
    }

    public String getPosition() {
        return positionField.getText();
    }

    public void setPosition(String position) {
        this.positionField.setText(position);
    }

    public String getSalary() {
        return salaryField.getText();
    }

    public void setSalary(String salary) {
        this.salaryField.setText(salary);
    }

    public String getDateOfJoining() {
        return dateOfJoiningField.getText();
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoiningField.setText(dateOfJoining);
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void setEmail(String email) {
        this.emailField.setText(email);
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumberField.setText(phoneNumber);
    }

    public String getAddress() {
        return addressField.getText();
    }

    public void setAddress(String address) {
        this.addressField.setText(address);
    }

    public String getEmergencyContactName() {
        return emergencyContactNameField.getText();
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactNameField.setText(emergencyContactName);
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhoneField.getText();
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhoneField.setText(emergencyContactPhone);
    }

    public void setFieldsEditable(boolean editable) {
        firstNameField.setEditable(editable);
        lastNameField.setEditable(editable);
        positionField.setEditable(editable);
        salaryField.setEditable(editable);
        dateOfJoiningField.setEditable(editable);
        emailField.setEditable(editable);
        phoneNumberField.setEditable(editable);
        addressField.setEditable(editable);
        emergencyContactNameField.setEditable(editable);
        emergencyContactPhoneField.setEditable(editable);
    }

    public void enableUpdateButton(boolean enable) {
        updateButton.setEnabled(enable);
    }
}
