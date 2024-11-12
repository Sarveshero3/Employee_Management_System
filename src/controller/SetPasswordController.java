// src/controller/SetPasswordController.java

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserDAO;
import view.SetPasswordView;
import view.LoginView;

import javax.swing.JOptionPane;

public class SetPasswordController implements ActionListener {
    private SetPasswordView setPasswordView;
    private UserDAO userDAO;

    public SetPasswordController(SetPasswordView setPasswordView) {
        this.setPasswordView = setPasswordView;
        this.userDAO = new UserDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = setPasswordView.getPassword();
        String confirmPassword = setPasswordView.getConfirmPassword();

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(setPasswordView, "Please enter and confirm your password.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(setPasswordView, "Passwords do not match.");
            return;
        }

        if (userDAO.setPassword(password)) {
            JOptionPane.showMessageDialog(setPasswordView, "Password set successfully.");
            // Open login view
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
            setPasswordView.dispose();
        } else {
            JOptionPane.showMessageDialog(setPasswordView, "Failed to set password.");
        }
    }
}
