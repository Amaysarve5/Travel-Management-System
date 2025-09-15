package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {
    Thread t1;
    JLabel[] label = new JLabel[9];
    JLabel caption;

    public void run() {
        String[] text = new String[]{
            "JW Marriot Hotel", "Madarin Oriental Hotel", "Four Seasons Hotel", 
            "Raddison Blue Hotel", "Classico Hotel", "The Bay Club Hotel", 
            "Breeze Blow Hotel", "The Taj Hotel", "Happy Morning Motel", "River View Hotel"
        };
        try {
            for (int i = 0; i <9; i++) {
                if (label[i] != null) {
                    label[i].setVisible(true);
                    caption.setText(text[i]);
                    Thread.sleep(2500);
                    label[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels() {
        setBounds(500, 200, 800, 600);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        Image[] jimage = new Image[10];
        ImageIcon[] kimage = new ImageIcon[10];

        for (int i = 0; i <9; i++) {
            String path = "icons/Hotel" + (i + 1) + ".jpg";
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
        new CheckHotels();
    }
}
