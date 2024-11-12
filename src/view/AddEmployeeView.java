// src/view/AddEmployeeView.java

package view;

import javax.swing.*;
import java.awt.*;
import controller.AddEmployeeController;

public class AddEmployeeView {
    private JPanel panel;
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
    private JButton submitButton;
    private String password;

    public AddEmployeeView(String password) {
        this.password = password;
        panel = new JPanel();
        panel.setLayout(new GridLayout(11, 2, 10, 10));

        // Initialize components
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        positionField = new JTextField(20);
        salaryField = new JTextField(20);
        dateOfJoiningField = new JTextField(20); // Use yyyy-mm-dd format
        emailField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        addressField = new JTextField(20);
        emergencyContactNameField = new JTextField(20);
        emergencyContactPhoneField = new JTextField(20);
        submitButton = new JButton("Add Employee");

        // Add components to panel
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("Position:"));
        panel.add(positionField);
        panel.add(new JLabel("Salary:"));
        panel.add(salaryField);
        panel.add(new JLabel("Date of Joining (yyyy-mm-dd):"));
        panel.add(dateOfJoiningField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Emergency Contact Name:"));
        panel.add(emergencyContactNameField);
        panel.add(new JLabel("Emergency Contact Phone:"));
        panel.add(emergencyContactPhoneField);
        panel.add(new JLabel());
        panel.add(submitButton);

        // Add action listener
        AddEmployeeController controller = new AddEmployeeController(this, password);
        submitButton.addActionListener(controller);
    }

    public JPanel getPanel() {
        return panel;
    }

    // Getters for input fields
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
}
