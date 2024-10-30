package view;

import javax.swing.*;
import java.awt.*;

public class AddEmployeeView {
    private JPanel panel;
    private JTextField firstNameField, lastNameField, positionField, salaryField, dateOfJoiningField;
    private JTextField emailField, phoneNumberField, addressField, emergencyContactNameField, emergencyContactPhoneField;
    private JButton saveButton;

    public AddEmployeeView() {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245)); // Light Gray Background
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4); // Reduced insets for compactness

        // Define Fonts
        Font labelFont = new Font("Arial", Font.BOLD, 16); // Increased font size
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        int row = 0;

        // First Name
        addLabelAndField("First Name:", firstNameField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Last Name
        addLabelAndField("Last Name:", lastNameField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Position
        addLabelAndField("Position:", positionField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Salary
        addLabelAndField("Salary:", salaryField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Date of Joining
        addLabelAndField("Date of Joining (yyyy-mm-dd):", dateOfJoiningField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Email
        addLabelAndField("Email:", emailField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Phone Number
        addLabelAndField("Phone Number:", phoneNumberField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Address
        addLabelAndField("Address:", addressField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Emergency Contact Name
        addLabelAndField("Emergency Contact Name:", emergencyContactNameField = new JTextField(12), row++, labelFont, fieldFont, gbc);
        // Emergency Contact Phone
        addLabelAndField("Emergency Contact Phone:", emergencyContactPhoneField = new JTextField(12), row++, labelFont, fieldFont, gbc);

        // Save Button
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        saveButton.setForeground(Color.WHITE);
        panel.add(saveButton, gbc);

        // Add padding around the panel content
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void addLabelAndField(String labelText, JTextField textField, int row, Font labelFont, Font fieldFont, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = row;
        JLabel label = new JLabel(labelText);
        label.setFont(labelFont);
        panel.add(label, gbc);

        gbc.gridx = 1;
        textField.setFont(fieldFont);
        panel.add(textField, gbc);
    }

    // Getter for the main panel
    public JPanel getPanel() {
        return panel;
    }

    // Getter for the save button
    public JButton getSaveButton() {
        return saveButton;
    }

    // Getter methods for each field
    public String getFirstName() {
        return firstNameField.getText();
    }

    public String getLastName() {
        return lastNameField.getText();
    }

    public String getPosition() {
        return positionField.getText();
    }

    public String getSalary() {
        return salaryField.getText();
    }

    public String getDateOfJoining() {
        return dateOfJoiningField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText();
    }

    public String getAddress() {
        return addressField.getText();
    }

    public String getEmergencyContactName() {
        return emergencyContactNameField.getText();
    }

    public String getEmergencyContactPhone() {
        return emergencyContactPhoneField.getText();
    }

    // Method to clear the form after adding an employee
    public void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        positionField.setText("");
        salaryField.setText("");
        dateOfJoiningField.setText("");
        emailField.setText("");
        phoneNumberField.setText("");
        addressField.setText("");
        emergencyContactNameField.setText("");
        emergencyContactPhoneField.setText("");
    }
}
