package main;

import view.LoadingScreen;
import view.LoginView;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Set the look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Launch Loading Screen
        SwingUtilities.invokeLater(() -> {
            LoadingScreen loadingScreen = new LoadingScreen();
            loadingScreen.showLoading();

            // Once loading is done, show the login screen
            LoginView loginView = new LoginView();
            loginView.setVisible(true);
        });
    }
}
