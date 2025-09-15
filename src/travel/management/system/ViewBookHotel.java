package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookHotel extends JFrame implements ActionListener {
    JButton back;
    JLabel labelusername, labelpackage, labelperson, labeldays, labelid, labelnumber, labelprice, labelphone, labelac, labelfood;

    ViewBookHotel(String username) {
        setBounds(400, 200, 1000, 600); // Set window size and position
        getContentPane().setBackground(Color.WHITE); // Set background color
        setLayout(null);

        JLabel text = new JLabel("VIEW BOOK HOTEL DETAILS");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 0, 300, 30);
        add(text);

        // Adding labels and placeholders for customer information
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(30, 90, 150, 25);
        add(lblpackage);

        labelpackage = new JLabel();
        labelpackage.setBounds(220, 90, 150, 25);
        add(labelpackage);

        JLabel lblperson = new JLabel("Total Person");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);

        labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);

        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);

        labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);

        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);

        labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);

        JLabel lblfood = new JLabel("Food Included?");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);

        

        JLabel lbladdress = new JLabel("Total Cost");
        lbladdress.setBounds(30, 370, 150, 25);
        add(lbladdress);

        labelprice = new JLabel();
        labelprice.setBounds(220, 370, 150, 25);
        add(labelprice);

        // Back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this);
        add(back);

        // Load images and display
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT); // Adjusted size
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(450, 20, 500, 400);
            add(image);
        } catch (Exception e) {
            System.out.println("Image not found. Please check the path.");
        }

        // Load customer data from database
        loadCustomerData(username);

        setVisible(true);
    }

    // Method to load customer data
    public void loadCustomerData(String username) {
        try {
            Conn conn = new Conn();  // Establish database connection
            String query = "SELECT * FROM bookshotel WHERE username = ?";
            PreparedStatement ps = conn.c.prepareStatement(query);
            ps.setString(1, username); // Use prepared statement to avoid SQL injection
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelperson.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelprice.setText(rs.getString("price"));
                
            } else {
                JOptionPane.showMessageDialog(null, "No package data found for username: " + username);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching data from database.");
            e.printStackTrace();
        }
    }

    // Action event for back button
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);  // Close current window
        }
    }

    // Main method to test the ViewBookHotel class
    public static void main(String[] args) {
        new ViewBookHotel("username");  // Replace with a valid username from your database
    }
}
