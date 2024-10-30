package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpdateEmployeeView {
    private JPanel panel;
    private JTextField employeeIdField, positionField, salaryField, phoneNumberField;
    private JButton loadButton, updateButton;

    public UpdateEmployeeView() {
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4); // Reduced insets

        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);

        int row = 0;

        // Employee ID
        addLabelAndField("Employee ID:", employeeIdField = new JTextField(12), row++, labelFont, fieldFont, gbc);

        // Load Button
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loadButton = new JButton("Load Employee");
        loadButton.setFont(new Font("Arial", Font.BOLD, 16));
        loadButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        loadButton.setForeground(Color.WHITE);
        panel.add(loadButton, gbc);

        // Position
        addLabelAndField("Position:", positionField = new JTextField(12), row++, labelFont, fieldFont, gbc);

        // Salary
        addLabelAndField("Salary:", salaryField = new JTextField(12), row++, labelFont, fieldFont, gbc);

        // Phone Number
        addLabelAndField("Phone Number:", phoneNumberField = new JTextField(12), row++, labelFont, fieldFont, gbc);

        // Update Button
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        updateButton = new JButton("Update");
        updateButton.setFont(new Font("Arial", Font.BOLD, 16));
        updateButton.setBackground(new Color(255, 165, 0)); // Orange
        updateButton.setForeground(Color.WHITE);
        updateButton.setEnabled(false); // Disable until employee is loaded
        panel.add(updateButton, gbc);

        // Add padding
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Disable fields until employee is loaded
        setFieldsEditable(false);
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

    // Getters and Setters

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public JTextField getPositionField() {
        return positionField;
    }

    public JTextField getSalaryField() {
        return salaryField;
    }

    public JTextField getPhoneNumberField() {
        return phoneNumberField;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    // Enable/Disable Editing of Fields
    public void setFieldsEditable(boolean editable) {
        positionField.setEditable(editable);
        salaryField.setEditable(editable);
        phoneNumberField.setEditable(editable);
    }

    // Methods to add ActionListeners
    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }

    public void addUpdateButtonListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    // Methods to get and set field values
    public String getEmployeeId() {
        return employeeIdField.getText().trim();
    }

    public void setPosition(String position) {
        positionField.setText(position);
    }

    public String getPosition() {
        return positionField.getText().trim();
    }

    public void setSalary(String salary) {
        salaryField.setText(salary);
    }

    public String getSalary() {
        return salaryField.getText().trim();
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumberField.setText(phoneNumber);
    }

    public String getPhoneNumber() {
        return phoneNumberField.getText().trim();
    }
}
