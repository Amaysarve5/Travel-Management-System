package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem26", "root", "codeforinterview");

            // Create a statement object
            s = c.createStatement();
            
            System.out.println("Connection successful!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
