package travel.management.system;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.awt.*;

public class Paytm extends JFrame {
    Paytm() {
        setBounds(500, 200, 800, 600);
        setLayout(null); // Setting layout to null for custom positioning

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
            // Setting the page to the desired URL
            pane.setPage(new URL("https://paytm.com/rent-payment"));
        } catch (IOException e) {
            pane.setContentType("text/html");
            pane.setText("<html>Could not load, Error 404</html>");
        }

        JScrollPane sp = new JScrollPane(pane);
        sp.setBounds(20, 20, 500, 500); // Setting bounds for the JEditorPane
        add(sp);

        // Adding the Paytm QR code image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm_qr.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel qrImage = new JLabel(i3);
        qrImage.setBounds(550, 20, 250, 250); // Setting bounds for the QR code image
        add(qrImage);

        setTitle("Paytm Rent Payment");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
