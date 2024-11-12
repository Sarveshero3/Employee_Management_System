// src/controller/LoginController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserDAO;
import view.LoginView;
import view.SetPasswordView;
import view.MainView;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginController implements ActionListener {
    private LoginView loginView;
    private UserDAO userDAO;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userDAO = new UserDAO();

        if (userDAO.isFirstRun()) {
            SwingUtilities.invokeLater(() -> {
                SetPasswordView setPasswordView = new SetPasswordView();
                setPasswordView.setVisible(true);
                loginView.dispose();
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = loginView.getPassword();

        if (userDAO.authenticateUser(password)) {
            JOptionPane.showMessageDialog(loginView, "Login Successful!");
            // Open the main application window
            SwingUtilities.invokeLater(() -> {
                MainView mainView = new MainView(password);
                mainView.setVisible(true);
            });
            loginView.dispose(); // Close the login window
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid password.");
        }
    }
}
