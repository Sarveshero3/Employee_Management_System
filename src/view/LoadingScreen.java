package view;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JFrame {
    private JLabel animationLabel;

    public LoadingScreen() {
        // Frame Settings
        setTitle("Loading Employee Management System...");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setUndecorated(true); // Remove default borders
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Loading Label
        JLabel loadingLabel = new JLabel("Loading, please wait...");
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 16));
        loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loadingLabel, BorderLayout.NORTH);

        // Loading Animation (Icon)
        animationLabel = new JLabel();
        animationLabel.setHorizontalAlignment(SwingConstants.CENTER);        
        ImageIcon loadingGif = new ImageIcon(getClass().getResource("loading.gif"));
        animationLabel.setIcon(loadingGif);
        add(animationLabel, BorderLayout.CENTER);
    }

    // Simulate Loading Time
    public void showLoading() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            try {
                Thread.sleep(3000); // Show the loading screen for 3 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setVisible(false);
        });
    }
}
