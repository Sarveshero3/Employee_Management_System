// src/view/ViewEmployeeView.java

package view;

import javax.swing.*;
import java.awt.*;
import controller.ViewEmployeeController;

public class ViewEmployeeView {
    private JPanel panel;
    private JTextField employeeIdField;
    private JButton searchButton;
    private JTextArea employeeDetailsArea;
    private String password;

    public ViewEmployeeView(String password) {
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
        employeeDetailsArea = new JTextArea(15, 30);
        employeeDetailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeDetailsArea);

        // Add panels to main panel
        panel.add(searchPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add action listener
        ViewEmployeeController controller = new ViewEmployeeController(this, password);
        searchButton.addActionListener(controller);
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
}
