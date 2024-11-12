// src/model/UserDAO.java

package model;

import java.io.File;

public class UserDAO {
    private static final String FILE_NAME = "EmployeeData.xlsx";

    public boolean isFirstRun() {
        File file = new File(FILE_NAME);
        return !file.exists();
    }

    public boolean authenticateUser(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(password);
            employeeDAO.getAllEmployees(); // Try to read data
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setPassword(String password) {
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO(password);
            return employeeDAO.saveEmployees(new java.util.ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
