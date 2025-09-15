package travel.management.system;

import java.awt.EventQueue;

public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Signup frame = new Signup();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
