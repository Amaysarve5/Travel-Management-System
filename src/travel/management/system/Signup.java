package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {
    JButton create, back;
    JTextField tfName, tfUsername, tfPassword, tfAnswer;
    Choice security;

    public Signup() {
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 20, 125, 25);
        lblUsername.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 20, 250, 25);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfUsername);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(50, 60, 125, 25);
        lblName.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblName);

        tfName = new JTextField();
        tfName.setBounds(150, 60, 250, 25);
        tfName.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfName);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(50, 100, 125, 25);
        lblPassword.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(150, 100, 250, 25);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfPassword);

        JLabel lblSecurity = new JLabel("Security Question");
        lblSecurity.setBounds(50, 140, 125, 25);
        lblSecurity.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblSecurity);

        security = new Choice();
        security.add("Fav character from the Boys");
        security.add("Fav Marvel superhero");
        security.add("Your lucky number");
        security.add("Your childhood superhero");
        security.setBounds(180, 140, 220, 25);
        p1.add(security);

        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setBounds(50, 180, 125, 25);
        lblAnswer.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblAnswer);

        tfAnswer = new JTextField();
        tfAnswer.setBounds(150, 180, 250, 25);
        tfAnswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfAnswer);

        create = new JButton("Create");
        create.setForeground(new Color(133, 193, 233));
        create.setBackground(Color.WHITE);
        create.setFont(new Font("Tahoma", Font.BOLD, 14));
        create.setBounds(120, 250, 100, 30);
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setForeground(new Color(133, 193, 233));
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setBounds(320, 250, 100, 30);
        back.addActionListener(this);
        p1.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 50, 250, 250);
        add(image);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String username = tfUsername.getText();
            String name = tfName.getText();
            String password = tfPassword.getText();
            String question = security.getSelectedItem();
            String answer = tfAnswer.getText();
            String query = "INSERT INTO account (username, name, password, question, answer) VALUES (?, ?, ?, ?, ?)";

            try {
                Conn c = new Conn();
                PreparedStatement stmt = c.c.prepareStatement(query);
                stmt.setString(1, username);
                stmt.setString(2, name);
                stmt.setString(3, password);
                stmt.setString(4, question);
                stmt.setString(5, answer);
                int i = stmt.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                }
                tfUsername.setText("");
                tfName.setText("");
                tfPassword.setText("");
                tfAnswer.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
