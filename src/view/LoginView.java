// src/view/LoginView.java

package view;

import javax.swing.*;
import controller.LoginController;
import java.awt.*;

public class LoginView extends JFrame {
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginView() {
        setTitle("Employee Management System - Login");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(loginButton);

        add(panel);

        // Add action listener
        LoginController controller = new LoginController(this);
        loginButton.addActionListener(controller);
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setPassword(String password) {
        this.passwordField.setText(password);
    }
}
