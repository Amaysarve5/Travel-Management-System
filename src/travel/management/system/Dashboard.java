package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonalDetails, updatePersonalDetails, viewPersonalDetails, deletePersonalDetails,
            CheckPackages, bookPackage, viewPackage, viewHotels, bookHotel,
            viewBookedHotel, destination, payments, calculators, notepad, about;

    Dashboard(String username) {
        this.username = username;

        // Set the frame to full screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        // Background image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        // Top panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        image.add(p1);

        // Dashboard icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        // Dashboard heading
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 50);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Side panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        image.add(p2);

        // Buttons on the side panel
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0, 300, 50);
        configureButton(addPersonalDetails);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 50, 300, 50);
        configureButton(updatePersonalDetails);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 100, 300, 50);
        configureButton(viewPersonalDetails);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 150, 300, 50);
        configureButton(deletePersonalDetails);
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        CheckPackages = new JButton("Check Package");
        CheckPackages.setBounds(0, 200, 300, 50);
        configureButton(CheckPackages);
        CheckPackages.addActionListener(this);
        p2.add(CheckPackages);

        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(0, 250, 300, 50);
        configureButton(bookPackage);
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage = new JButton("View Booked Package");
        viewPackage.setBounds(0, 300, 300, 50);
        configureButton(viewPackage);
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(0, 350, 300, 50);
        configureButton(viewHotels);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotel = new JButton("Book Hotel");
        bookHotel.setBounds(0, 400, 300, 50);
        configureButton(bookHotel);
        bookHotel.addActionListener(this);
        p2.add(bookHotel);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 450, 300, 50);
        configureButton(viewBookedHotel);
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destination = new JButton("Destinations");
        destination.setBounds(0, 500, 300, 50);
        configureButton(destination);
        destination.addActionListener(this);
        p2.add(destination);

        payments = new JButton("Payments");
        payments.setBounds(0, 550, 300, 50);
        configureButton(payments);
        payments.addActionListener(this);
        p2.add(payments);

        calculators = new JButton("Calculator");
        calculators.setBounds(0, 600, 300, 50);
        configureButton(calculators);
        calculators.addActionListener(this);
        p2.add(calculators);

        notepad = new JButton("Notepad");
        notepad.setBounds(0, 650, 300, 50);
        configureButton(notepad);
        notepad.addActionListener(this);
        p2.add(notepad);

        about = new JButton("About");
        about.setBounds(0, 700, 300, 50);
        configureButton(about);
        about.addActionListener(this);
        p2.add(about);

        // Main title on the background image
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(400, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        // Final frame setup
        setVisible(true);
    }

    // Helper method to configure button properties
    private void configureButton(JButton button) {
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setFocusPainted(false);
    }

    // Action performed for each button
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);  // Open AddCustomer form
        } else if (ae.getSource() == viewPersonalDetails) {
            new Viewcustomer(username);  // Open Viewcustomer to view details
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);
        } else if (ae.getSource() == CheckPackages) {
            new CheckPackages();  // Open the CheckPackages form
        } else if (ae.getSource() == bookPackage) {
            new BookPackage(username);
        } else if (ae.getSource() == viewPackage) {
            new ViewPackage(username);
        } else if (ae.getSource() == viewHotels) {
            new CheckHotels();
        } else if (ae.getSource() == bookHotel) {
            new BookHotel(username);
        } else if (ae.getSource() == viewBookedHotel) {
            new ViewBookHotel(username);
        } else if (ae.getSource() == destination) {
            new Destinations();
        } else if (ae.getSource() == payments) {
            new Payment();
        } else if (ae.getSource() == calculators) {
            try {
                Runtime.getRuntime().exec("calc.exe");  // Open calculator
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");  // Open notepad
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == about) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Dashboard("username");  // Replace with the username of your choice
    }
}
