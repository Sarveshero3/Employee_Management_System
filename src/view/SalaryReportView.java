package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import controller.SalaryReportController;

public class SalaryReportView {
    private JPanel panel;
    private JTable reportTable;
    private DefaultTableModel tableModel;

    public SalaryReportView() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        String[] columnNames = { "ID", "First Name", "Last Name", "Position", "Salary" };
        tableModel = new DefaultTableModel(columnNames, 0);
        reportTable = new JTable(tableModel);

        // Set Font Size for Table
        Font tableFont = new Font("Arial", Font.PLAIN, 14);
        reportTable.setFont(tableFont);
        reportTable.setRowHeight(20);

        // Adjust Column Widths
        reportTable.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        reportTable.getColumnModel().getColumn(1).setPreferredWidth(80);  // First Name
        reportTable.getColumnModel().getColumn(2).setPreferredWidth(80);  // Last Name
        reportTable.getColumnModel().getColumn(3).setPreferredWidth(90);  // Position
        reportTable.getColumnModel().getColumn(4).setPreferredWidth(60);  // Salary

        // Style the Table Header
        JTableHeader tableHeader = reportTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(new Color(100, 149, 237));
        tableHeader.setForeground(Color.WHITE);

        // Center Align Columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        reportTable.setDefaultRenderer(Object.class, centerRenderer);

        // Add Scroll Pane
        JScrollPane scrollPane = new JScrollPane(reportTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add padding
        panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        // Instantiate the controller here
        new SalaryReportController(this);
    }

    // Getters and Setters

    public JPanel getPanel() {
        return panel;
    }

    public JTable getReportTable() {
        return reportTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
