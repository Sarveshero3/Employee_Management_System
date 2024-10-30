package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class PositionCountReportView {
    private JPanel panel;
    private JTable table;
    private DefaultTableModel tableModel;

    public PositionCountReportView() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        // Define column names and model
        String[] columnNames = { "Position", "Count" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Set Font Size for Table
        Font tableFont = new Font("Arial", Font.PLAIN, 14);
        table.setFont(tableFont);
        table.setRowHeight(20);

        // Adjust Column Widths
        table.getColumnModel().getColumn(0).setPreferredWidth(150);  // Position
        table.getColumnModel().getColumn(1).setPreferredWidth(50);   // Count

        // Style the Table Header
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 14));
        tableHeader.setBackground(new Color(70, 130, 180)); // Steel Blue
        tableHeader.setForeground(Color.WHITE);

        // Center Align Columns
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        // Add Scroll Pane
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add padding
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
