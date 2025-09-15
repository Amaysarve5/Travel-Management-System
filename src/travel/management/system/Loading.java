package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    // Assuming Dashboard class exists
                    new Dashboard(username);  
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);

        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Title text
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.BOLD, 35));
        text.setBounds(50, 20, 600, 40);
        add(text);

        // Progress bar
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        bar.setMaximum(100); // Set maximum value for the progress bar
        add(bar);

        // Loading text
        JLabel loading = new JLabel("Loading, please wait...");
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Tahoma", Font.BOLD, 16));
        loading.setBounds(230, 130, 200, 30);
        add(loading);

        // Welcome username label
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblusername.setBounds(20, 310, 400, 40);
        add(lblusername);

        t.start();  // Start the loading process
        setVisible(true);
    }

    public static void main(String[] args) {
        new Loading("");  // Provide an empty username for testing
    }
}
