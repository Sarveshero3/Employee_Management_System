// src/view/MainView.java

package view;

import javax.swing.*;
import controller.MainController;
import java.awt.*;

public class MainView extends JFrame {
    // Menu components
    private JMenuBar menuBar;
    private JMenu employeeMenu, reportMenu;
    private JMenuItem addEmployeeItem, updateEmployeeItem, deleteEmployeeItem, viewEmployeeItem, listEmployeesItem;
    private JMenuItem salaryReportItem, positionCountReportItem;

    // Other components (if needed)
    private JPanel contentPanel;
    private String password;

    public MainView(String password) {
        this.password = password;
        setTitle("Employee Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the menu bar and menus
        menuBar = new JMenuBar();
        employeeMenu = new JMenu("Employee");
        reportMenu = new JMenu("Reports");

        // Initialize menu items for Employee Menu
        addEmployeeItem = new JMenuItem("Add Employee");
        updateEmployeeItem = new JMenuItem("Update Employee");
        deleteEmployeeItem = new JMenuItem("Delete Employee");
        viewEmployeeItem = new JMenuItem("View Employee");
        listEmployeesItem = new JMenuItem("List All Employees");

        // Add menu items to Employee Menu
        employeeMenu.add(addEmployeeItem);
        employeeMenu.add(updateEmployeeItem);
        employeeMenu.add(deleteEmployeeItem);
        employeeMenu.add(viewEmployeeItem);
        employeeMenu.add(listEmployeesItem);

        // Initialize menu items for Report Menu
        salaryReportItem = new JMenuItem("Salary Report");
        positionCountReportItem = new JMenuItem("Position-wise Employee Count");

        // Add menu items to Report Menu
        reportMenu.add(salaryReportItem);
        reportMenu.add(positionCountReportItem);

        // Add menus to the menu bar
        menuBar.add(employeeMenu);
        menuBar.add(reportMenu);

        // Set the menu bar for the frame
        setJMenuBar(menuBar);

        // Initialize content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Add the content panel to the frame
        add(contentPanel);

        // Add action listeners to menu items
        MainController controller = new MainController(this, password);
        addEmployeeItem.addActionListener(controller);
        updateEmployeeItem.addActionListener(controller);
        deleteEmployeeItem.addActionListener(controller);
        viewEmployeeItem.addActionListener(controller);
        listEmployeesItem.addActionListener(controller);

        salaryReportItem.addActionListener(controller);
        positionCountReportItem.addActionListener(controller);
    }

    // Getters for menu items (to be used in the controller)
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

    public JMenuItem getListEmployeesItem() {
        return listEmployeesItem;
    }

    public JMenuItem getSalaryReportItem() {
        return salaryReportItem;
    }

    public JMenuItem getPositionCountReportItem() {
        return positionCountReportItem;
    }

    // Method to update the content panel with new views
    public void setContentPanel(JPanel newPanel) {
        contentPanel.removeAll();
        contentPanel.add(newPanel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
