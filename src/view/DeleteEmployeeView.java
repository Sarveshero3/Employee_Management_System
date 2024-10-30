package view;

import javax.swing.*;
import java.awt.*;
import controller.DeleteEmployeeController;

public class DeleteEmployeeView {
    private JPanel panel;
    private JTextField employeeIdField;
    private JButton searchButton;
    private JTextArea employeeDetailsArea;
    private JButton deleteButton;

    public DeleteEmployeeView() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        // Fonts
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        // Top panel for searching
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        searchPanel.setBackground(new Color(245, 245, 245));
        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setFont(labelFont);
        employeeIdField = new JTextField(10);
        employeeIdField.setFont(fieldFont);
        searchButton = new JButton("Search");
        searchButton.setFont(buttonFont);
        searchButton.setBackground(new Color(100, 149, 237));
        searchButton.setForeground(Color.WHITE);
        searchPanel.add(idLabel);
        searchPanel.add(employeeIdField);
        searchPanel.add(searchButton);

        // Center panel for displaying employee details
        employeeDetailsArea = new JTextArea(8, 30);
        employeeDetailsArea.setFont(fieldFont);
        employeeDetailsArea.setEditable(false);
        employeeDetailsArea.setBackground(new Color(240, 248, 255)); // Alice blue
        JScrollPane scrollPane = new JScrollPane(employeeDetailsArea);

        // Bottom panel for delete button
        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        deletePanel.setBackground(new Color(245, 245, 245));
        deleteButton = new JButton("Delete Employee");
        deleteButton.setFont(buttonFont);
        deleteButton.setBackground(new Color(255, 69, 0)); // Red Orange
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setEnabled(false);
        deletePanel.add(deleteButton);

        // Add panels to main panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(deletePanel, BorderLayout.SOUTH);

        // Add action listeners (Assuming you have a controller)
        DeleteEmployeeController controller = new DeleteEmployeeController(this);
        searchButton.addActionListener(controller);
        deleteButton.addActionListener(controller);

        // Add padding around the panel content
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // Getters and Setters

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public JTextArea getEmployeeDetailsArea() {
        return employeeDetailsArea;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public String getEmployeeId() {
        return employeeIdField.getText();
    }

    public void setEmployeeDetails(String details) {
        employeeDetailsArea.setText(details);
    }

    public void enableDeleteButton(boolean enable) {
        deleteButton.setEnabled(enable);
    }
}
