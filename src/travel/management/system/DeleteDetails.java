package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener {
    JButton back;
    String username;
    JLabel labelusername, labelid, labelnumber, labelname, labelgender, labelcountry, labeladdress, labelphone, labelemail;
    
    // Constructor for the Viewcustomer class
    DeleteDetails(String username) {
        this.username = username;
        setBounds(450, 180, 870, 625); // Set window size and position
        getContentPane().setBackground(Color.WHITE); // Set background color
        setLayout(null);
        
        // Adding labels and placeholders for customer information
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 170, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(690, 170, 150, 25);
        add(labelphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 230, 150, 25);
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(690, 230, 150, 25);
        add(labelemail);
        
        // Back button
        back = new JButton("Delete");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);
        
        // Load images and display
        try {
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
            Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(20, 400, 600, 200);
            add(image);
        
            ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
            Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
            ImageIcon i6 = new ImageIcon(i5);
            JLabel image2 = new JLabel(i6);
            image2.setBounds(600, 400, 600, 200);
            add(image2);
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
            String query = "SELECT * FROM customer WHERE username = ?";
            PreparedStatement ps = conn.c.prepareStatement(query);
            ps.setString(1, username); // Use prepared statement to avoid SQL injection
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            } else {
                JOptionPane.showMessageDialog(null, "No customer data found for username: " + username);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching data from database.");
            e.printStackTrace();
        }
    }

    // Action event for back button
    public void actionPerformed(ActionEvent ae) {
        try{
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookshotel where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Main method to test the Viewcustomer class
    public static void main(String[] args) {
        new DeleteDetails("username");  // Replace with a valid username from your database
    }
}
