// src/view/SetPasswordView.java

package view;

import javax.swing.*;
import controller.SetPasswordController;
import java.awt.*;

public class SetPasswordView extends JFrame {
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton setPasswordButton;

    public SetPasswordView() {
        setTitle("Set Password");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        setPasswordButton = new JButton("Set Password");

        // Layout setup
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(new JLabel("Enter Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPasswordField);
        panel.add(new JLabel());
        panel.add(setPasswordButton);

        add(panel);

        // Add action listener
        SetPasswordController controller = new SetPasswordController(this);
        setPasswordButton.addActionListener(controller);
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void setPassword(String password) {
        this.passwordField.setText(password);
    }

    public String getConfirmPassword() {
        return new String(confirmPasswordField.getPassword());
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPasswordField.setText(confirmPassword);
    }
}
