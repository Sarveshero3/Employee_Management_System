// src/view/ListEmployeesView.java

package view;

import javax.swing.*;
import java.awt.*;
import controller.ListEmployeesController;
import javax.swing.table.DefaultTableModel;

public class ListEmployeesView {
    private JPanel panel;
    private JTable employeesTable;
    private DefaultTableModel tableModel;
    private String password;

    public ListEmployeesView(String password) {
        this.password = password;
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Table columns
        String[] columnNames = { "Employee ID", "First Name", "Last Name", "Position", "Salary" };

        // Initialize table model and table
        tableModel = new DefaultTableModel(columnNames, 0);
        employeesTable = new JTable(tableModel);

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(employeesTable);

        // Add scroll pane to panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Load data
        new ListEmployeesController(this, password);
    }

    public JPanel getPanel() {
        return panel;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
