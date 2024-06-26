package com.example.dataInsert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicDataInsert {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bikkadit_jdbc";
        String user = "root";
        String pass = "Shubham0342@";
        String insertQuery = "Insert into Student values (?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            // Using PreparedStatement for safe insertion of data
            PreparedStatement ps = conn.prepareStatement(insertQuery);
            // Set values for placeholders (?)
            ps.setInt(1, 3); // Roll number
            ps.setString(2, "Rishabh"); // First name
            ps.setString(3, "Mantri"); // Last name
            int rowsInserted = ps.executeUpdate();
            System.out.println(rowsInserted + " rows inserted");
           // System.out.println("Done !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
