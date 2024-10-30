package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;
import view.AddEmployeeView;
import view.UpdateEmployeeView;
import view.DeleteEmployeeView;
import view.ViewEmployeeView;
import view.SalaryReportView;
import view.PositionCountReportView;
import view.ListEmployeesView;

public class MainController implements ActionListener {
    private MainView mainView;

    public MainController(MainView mainView) {
        this.mainView = mainView;

        // Attach action listeners
        mainView.getAddEmployeeItem().addActionListener(this);
        mainView.getUpdateEmployeeItem().addActionListener(this);
        mainView.getDeleteEmployeeItem().addActionListener(this);
        mainView.getViewEmployeeItem().addActionListener(this);
        mainView.getSalaryReportItem().addActionListener(this);
        mainView.getPositionCountReportItem().addActionListener(this);
        mainView.getListAllEmployeesItem().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == mainView.getAddEmployeeItem()) {
            AddEmployeeView addEmployeeView = new AddEmployeeView();
            mainView.setContentPanel(addEmployeeView.getPanel());
        } else if (source == mainView.getUpdateEmployeeItem()) {
            UpdateEmployeeView updateEmployeeView = new UpdateEmployeeView();
            mainView.setContentPanel(updateEmployeeView.getPanel());
        } else if (source == mainView.getDeleteEmployeeItem()) {
            DeleteEmployeeView deleteEmployeeView = new DeleteEmployeeView();
            mainView.setContentPanel(deleteEmployeeView.getPanel());
        } else if (source == mainView.getViewEmployeeItem()) {
            ViewEmployeeView viewEmployeeView = new ViewEmployeeView();
            mainView.setContentPanel(viewEmployeeView.getPanel());
        } else if (source == mainView.getSalaryReportItem()) {
            SalaryReportView salaryReportView = new SalaryReportView();
            mainView.setContentPanel(salaryReportView.getPanel());
        } else if (source == mainView.getPositionCountReportItem()) {
            PositionCountReportView positionCountReportView = new PositionCountReportView();
            mainView.setContentPanel(positionCountReportView.getPanel());
        } else if (source == mainView.getListAllEmployeesItem()) {
            ListEmployeesView listEmployeesView = new ListEmployeesView();
            mainView.setContentPanel(listEmployeesView.getPanel());
        }
    }
}
