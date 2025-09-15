package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelUsername, labelName;
    JTextField tfNumber, tfAddress, tfCountry, tfEmail, tfPhone, tfId, tfGender;
    JButton update, back;

    UpdateCustomer(String username) {
        // Set JFrame properties
        setBounds(500, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        // Username label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(220, 50, 150, 25);
        add(labelUsername);

        // ID label and text field
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(30, 90, 150, 25);
        add(lblId);

        tfId = new JTextField();
        tfId.setBounds(220, 90, 150, 25);
        add(tfId);

        // Number label and text field
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30, 130, 150, 25);
        add(lblNumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);

        // Name label
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(30, 170, 150, 25);
        add(lblName);

        labelName = new JLabel();
        labelName.setBounds(220, 170, 150, 25);
        add(labelName);

        // Gender label and text field
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30, 210, 150, 25);
        add(lblGender);

        tfGender = new JTextField();
        tfGender.setBounds(220, 210, 150, 25);
        add(tfGender);

        // Country label and text field
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30, 250, 150, 25);
        add(lblCountry);

        tfCountry = new JTextField();
        tfCountry.setBounds(220, 250, 150, 25);
        add(tfCountry);

        // Address label and text field
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30, 290, 150, 25);
        add(lblAddress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220, 290, 150, 25);
        add(tfAddress);

        // Phone label and text field
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(30, 330, 150, 25);
        add(lblPhone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220, 330, 150, 25);
        add(tfPhone);

        // Email label and text field
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30, 370, 150, 25);
        add(lblEmail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 370, 150, 25);
        add(tfEmail);

        // Update button
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);

        // Back button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        // Image icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 100, 450, 300);
        add(image);

        // Fetch customer details from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username='" + username + "'");
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelName.setText(rs.getString("name"));
                tfId.setText(rs.getString("id"));
                tfNumber.setText(rs.getString("number"));
                tfGender.setText(rs.getString("gender"));
                tfCountry.setText(rs.getString("country"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String username = labelUsername.getText();
            String id = tfId.getText();
            String number = tfNumber.getText();
            String name = labelName.getText();
            String gender = tfGender.getText();
            String country = tfCountry.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            try {
                Conn c = new Conn();
                // Update the query to include a WHERE clause to ensure the correct record is updated
                String query = "update customer set id='" + id + "', number='" + number + "', gender='" + gender + "', country='" + country + "', address='" + address + "', phone='" + phone + "', email='" + email + "' where username='" + username + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer details updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("username");
    }
}
