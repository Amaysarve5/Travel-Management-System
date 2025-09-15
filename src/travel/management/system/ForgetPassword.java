package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
    JTextField tfusername, tfname, tfquestion, tfanswer, tfpassword;
    JButton Search, Retrieve, Back;

    public ForgetPassword() {
        setSize(850, 380);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);

        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 500, 280);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(220, 20, 150, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        Search = new JButton("Search");
        Search.setForeground(Color.WHITE);
        Search.setBackground(Color.GRAY);
        Search.setFont(new Font("Tahoma", Font.BOLD, 14));
        Search.setBounds(380, 20, 100, 25);
        Search.addActionListener(this);
        p1.add(Search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 60, 100, 25);
        lblname.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 60, 150, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40, 100, 150, 25);
        lblquestion.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(220, 100, 150, 25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);

        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(40, 140, 100, 25);
        lblanswer.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220, 140, 150, 25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);

        Retrieve = new JButton("Retrieve");
        Retrieve.setForeground(Color.WHITE);
        Retrieve.setBackground(Color.GRAY);
        Retrieve.setFont(new Font("Tahoma", Font.BOLD, 14));
        Retrieve.setBounds(380, 140, 100, 25);
        Retrieve.addActionListener(this);
        p1.add(Retrieve);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 180, 150, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.BOLD, 14));
        p1.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220, 180, 150, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);

        Back = new JButton("Back");
        Back.setForeground(Color.WHITE);
        Back.setBackground(Color.GRAY);
        Back.setFont(new Font("Tahoma", Font.BOLD, 14));
        Back.setBounds(170, 220, 120, 25);
        Back.addActionListener(this);
        p1.add(Back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Search) {
            try {
                String query = "SELECT * FROM account WHERE username='" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("question")); // Adjust column name
                } else {
                    JOptionPane.showMessageDialog(null, "Username not found");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Retrieve) {
            try {
                String query = "SELECT * FROM account WHERE answer='" + tfanswer.getText() + "' AND username='" + tfusername.getText() + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    tfpassword.setText(rs.getString("password"));
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid answer or username");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new ForgetPassword();
    }
}
