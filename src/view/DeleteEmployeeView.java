// src/view/DeleteEmployeeView.java

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
    private String password;

    public DeleteEmployeeView(String password) {
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

        // Center panel for displaying employee details
        employeeDetailsArea = new JTextArea(10, 30);
        employeeDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeDetailsArea);

        // Bottom panel for delete button
        JPanel deletePanel = new JPanel(new FlowLayout());
        deleteButton = new JButton("Delete Employee");
        deleteButton.setEnabled(false);
        deletePanel.add(deleteButton);

        // Add panels to main panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(deletePanel, BorderLayout.SOUTH);

        // Add action listeners
        DeleteEmployeeController controller = new DeleteEmployeeController(this, password);
        searchButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
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

    public void setEmployeeDetails(String details) {
        employeeDetailsArea.setText(details);
    }

    public String getEmployeeDetails() {
        return employeeDetailsArea.getText();
    }

    public void enableDeleteButton(boolean enable) {
        deleteButton.setEnabled(enable);
    }
}
