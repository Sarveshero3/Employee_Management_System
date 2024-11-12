// src/controller/MainController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MainView;
import view.AddEmployeeView;
import view.UpdateEmployeeView;
import view.DeleteEmployeeView;
import view.ViewEmployeeView;
import view.ListEmployeesView;
import view.SalaryReportView;
import view.PositionCountReportView;

public class MainController implements ActionListener {
    private MainView mainView;
    private String password;

    public MainController(MainView mainView, String password) {
        this.mainView = mainView;
        this.password = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == mainView.getAddEmployeeItem()) {
            AddEmployeeView addEmployeeView = new AddEmployeeView(password);
            mainView.setContentPanel(addEmployeeView.getPanel());
        } else if (source == mainView.getUpdateEmployeeItem()) {
            UpdateEmployeeView updateEmployeeView = new UpdateEmployeeView(password);
            mainView.setContentPanel(updateEmployeeView.getPanel());
        } else if (source == mainView.getDeleteEmployeeItem()) {
            DeleteEmployeeView deleteEmployeeView = new DeleteEmployeeView(password);
            mainView.setContentPanel(deleteEmployeeView.getPanel());
        } else if (source == mainView.getViewEmployeeItem()) {
            ViewEmployeeView viewEmployeeView = new ViewEmployeeView(password);
            mainView.setContentPanel(viewEmployeeView.getPanel());
        } else if (source == mainView.getListEmployeesItem()) {
            ListEmployeesView listEmployeesView = new ListEmployeesView(password);
            mainView.setContentPanel(listEmployeesView.getPanel());
        } else if (source == mainView.getSalaryReportItem()) {
            SalaryReportView salaryReportView = new SalaryReportView(password);
            mainView.setContentPanel(salaryReportView.getPanel());
        } else if (source == mainView.getPositionCountReportItem()) {
            PositionCountReportView positionCountReportView = new PositionCountReportView(password);
            mainView.setContentPanel(positionCountReportView.getPanel());
        }
    }
}
