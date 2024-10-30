package controller;

import model.EmployeeDAO;
import model.PositionCount;
import view.PositionCountReportView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PositionCountReportController {
    private PositionCountReportView positionCountReportView;
    private EmployeeDAO employeeDAO;

    public PositionCountReportController(PositionCountReportView positionCountReportView) {
        this.positionCountReportView = positionCountReportView;
        this.employeeDAO = new EmployeeDAO();
        loadPositionCounts();
    }

    private void loadPositionCounts() {
        List<PositionCount> counts = employeeDAO.getPositionWiseCount();
        DefaultTableModel tableModel = positionCountReportView.getTableModel();
        tableModel.setRowCount(0); // Clear existing data

        for (PositionCount pc : counts) {
            Object[] rowData = {
                pc.getPosition(),
                pc.getCount()
            };
            tableModel.addRow(rowData);
        }
    }
}
