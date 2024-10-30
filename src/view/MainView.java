package view;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JMenuBar menuBar;
    private JMenu employeeMenu, reportMenu;
    private JMenuItem addEmployeeItem, updateEmployeeItem, deleteEmployeeItem, viewEmployeeItem, salaryReportItem;
    private JMenuItem positionCountReportItem, listAllEmployeesItem;
    private JPanel contentPanel;

    public MainView() {
        setTitle("Employee Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        employeeMenu = new JMenu("Employee");
        employeeMenu.setFont(new Font("Arial", Font.BOLD, 16));
        menuBar.add(employeeMenu);

        addEmployeeItem = new JMenuItem("Add Employee");
        employeeMenu.add(addEmployeeItem);

        updateEmployeeItem = new JMenuItem("Update Employee");
        employeeMenu.add(updateEmployeeItem);

        deleteEmployeeItem = new JMenuItem("Delete Employee");
        employeeMenu.add(deleteEmployeeItem);

        viewEmployeeItem = new JMenuItem("View Employee");
        employeeMenu.add(viewEmployeeItem);

        reportMenu = new JMenu("Reports");
        reportMenu.setFont(new Font("Arial", Font.BOLD, 16));
        menuBar.add(reportMenu);

        salaryReportItem = new JMenuItem("Salary Report");
        reportMenu.add(salaryReportItem);

        positionCountReportItem = new JMenuItem("Position Count Report");
        reportMenu.add(positionCountReportItem);

        listAllEmployeesItem = new JMenuItem("List All Employees");
        reportMenu.add(listAllEmployeesItem);

        // Initialize the main content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.CENTER);
    }

    // Method to replace the current content panel with a new panel
    public void setContentPanel(JPanel panel) {
        contentPanel.removeAll(); // Remove existing components
        contentPanel.add(panel, BorderLayout.CENTER); // Add the new panel
        contentPanel.revalidate(); // Refresh the layout
        contentPanel.repaint(); // Repaint to apply changes
    }

    // Getters for the menu items
    public JMenuItem getAddEmployeeItem() {
        return addEmployeeItem;
    }

    public JMenuItem getUpdateEmployeeItem() {
        return updateEmployeeItem;
    }

    public JMenuItem getDeleteEmployeeItem() {
        return deleteEmployeeItem;
    }

    public JMenuItem getViewEmployeeItem() {
        return viewEmployeeItem;
    }

    public JMenuItem getSalaryReportItem() {
        return salaryReportItem;
    }

    public JMenuItem getPositionCountReportItem() {
        return positionCountReportItem;
    }

    public JMenuItem getListAllEmployeesItem() {
        return listAllEmployeesItem;
    }
}
