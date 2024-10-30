package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class ListEmployeesView {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;

    public ListEmployeesView() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        // Define column names and model
        String[] columnNames = { "ID", "First Name", "Last Name", "Position", "Salary" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Set Font Size for Table
        Font tableFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(tableFont);
        table.setRowHeight(20); // Decreased row height

        // Adjust Column Widths
        table.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(80);  // First Name
        table.getColumnModel().getColumn(2).setPreferredWidth(80);  // Last Name
        table.getColumnModel().getColumn(3).setPreferredWidth(90);  // Position
        table.getColumnModel().getColumn(4).setPreferredWidth(60);  // Salary

        // Style the Table Header
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(new Color(70, 130, 180)); // Steel Blue (Darker shade)
        tableHeader.setForeground(Color.WHITE);

        // Set Background and Font Colors for Table Rows
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);

        // Center Align Columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Add Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add padding around the panel content
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
    }

    // Getters and Setters

    public JPanel getPanel() {
        return panel;
    }

    public JTable getTable() {
        return table;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
