package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {
    Thread t1;
    JLabel[] label = new JLabel[10];

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Destinations() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i < 10; i++) {
            String path = "icons/dest" + (i + 1) + ".jpg";
            java.net.URL imgURL = getClass().getClassLoader().getResource(path);
            if (imgURL != null) {
                System.out.println("Found file: " + path);
                image[i] = new ImageIcon(imgURL);
                jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
                kimage[i] = new ImageIcon(jimage[i]);
                label[i] = new JLabel(kimage[i]);
                label[i].setBounds(0, 0, 800, 600);
                label[i].setVisible(false);
                add(label[i]);
            } else {
                System.err.println("Couldn't find file: " + path);
                label[i] = new JLabel();
                label[i].setBounds(0, 0, 800, 600);
                label[i].setVisible(false);
                add(label[i]);
            }
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
