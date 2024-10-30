package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.UserDAO;
import view.LoginView;
import view.LoadingScreen;
import view.MainView;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class LoginController implements ActionListener {
    private LoginView loginView;
    private UserDAO userDAO;

    public LoginController(LoginView loginView) {
        this.loginView = loginView;
        this.userDAO = new UserDAO();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = loginView.getUsername();
        String password = loginView.getPassword();

        if (userDAO.authenticateUser(username, password)) {
            JOptionPane.showMessageDialog(loginView, "Login Successful!");
            loginView.setVisible(false); // Close the login window

            // Launch Loading Screen
            LoadingScreen loadingScreen = new LoadingScreen();
            loadingScreen.showLoading();

            // Show the Main Application Window
            SwingUtilities.invokeLater(() -> {
                MainView mainView = new MainView();
                new MainController(mainView);
                mainView.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid username or password.");
        }
    }
}
