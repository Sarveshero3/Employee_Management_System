package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewEmployeeView {
    private JPanel panel;
    private JTextField employeeIdField;
    private JTextArea employeeDetailsArea;
    private JButton viewButton;

    public ViewEmployeeView() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        // Fonts
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // ID Input
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        inputPanel.setBackground(new Color(245, 245, 245));
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setFont(labelFont);
        employeeIdField = new JTextField(10);
        employeeIdField.setFont(fieldFont);
        viewButton = new JButton("View");
        viewButton.setFont(buttonFont);
        viewButton.setBackground(new Color(100, 149, 237));
        viewButton.setForeground(Color.WHITE);
        inputPanel.add(idLabel);
        inputPanel.add(employeeIdField);
        inputPanel.add(viewButton);

        // Employee Details Display Area
        employeeDetailsArea = new JTextArea(8, 30);
        employeeDetailsArea.setFont(fieldFont);
        employeeDetailsArea.setEditable(false);
        employeeDetailsArea.setBackground(new Color(240, 248, 255)); // Alice blue
        JScrollPane scrollPane = new JScrollPane(employeeDetailsArea);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add padding
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Getters and Setters

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public JTextArea getEmployeeDetailsArea() {
        return employeeDetailsArea;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    // Getter method to retrieve the entered Employee ID
    public String getEmployeeId() {
        return employeeIdField.getText();
    }

    // Setter method to display employee details
    public void setEmployeeDetails(String details) {
        employeeDetailsArea.setText(details);
    }

    // Method to add ActionListener to the view button
    public void addViewButtonListener(ActionListener listener) {
        viewButton.addActionListener(listener);
    }
}
