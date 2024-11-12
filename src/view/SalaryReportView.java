// src/view/SalaryReportView.java

package view;

import javax.swing.*;
import java.awt.*;
import controller.SalaryReportController;
import javax.swing.table.DefaultTableModel;

public class SalaryReportView {
    private JPanel panel;
    private JTable reportTable;
    private DefaultTableModel tableModel;
    private String password;

    public SalaryReportView(String password) {
        this.password = password;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Table columns
        String[] columnNames = { "Employee ID", "First Name", "Last Name", "Position", "Salary" };

        // Initialize table model and table
        tableModel = new DefaultTableModel(columnNames, 0);
        reportTable = new JTable(tableModel);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(reportTable);

        // Add scroll pane to panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load data
        new SalaryReportController(this, password);
    }

    public JPanel getPanel() {
        return panel;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
