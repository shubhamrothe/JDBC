package com.example.dataRetrieve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataRetrieve {

    public static void main(String[] args) {
        String createTable = "CREATE TABLE IF NOT EXISTS Student (rollno INT PRIMARY KEY, fname VARCHAR(50), lname VARCHAR(50))";
        String insertQuery = "INSERT INTO Student (rollno, fname, lname) VALUES (1, 'Shubham', 'Rothe'), (2, 'Rishabh', 'Mantri')";
        String query = "SELECT * FROM Student";
        try {
            String url = "jdbc:mysql://localhost:3306/bikkadit_jdbc";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, "root", "Shubham0342@");
            Statement statement = connection.createStatement();

            // Create the table only if it doesn't exist
            statement.executeUpdate(createTable);
            System.out.println("Student table created successfully or already exists.");

            // Insert data into the table
            int rowsAffected = statement.executeUpdate(insertQuery);
            System.out.println(rowsAffected + " rows inserted successfully.");
            System.out.println("Hello world !!");
            System.out.println("Hello world !!");

            // Retrieve data from the table
            ResultSet rs = statement.executeQuery(query);

            // Display the retrieved data
            while (rs.next()) {
                int rollno = rs.getInt(1);
                String fname = rs.getString(2);
                String lname = rs.getString(3);

                System.out.println(rollno + " " + fname + " " + lname);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
