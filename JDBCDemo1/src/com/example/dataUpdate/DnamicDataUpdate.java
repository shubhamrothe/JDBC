package com.example.dataUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DnamicDataUpdate {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/bikkadit_jdbc";
        String user = "root";
        String pass = "Shubham0342@";
        String updateQuery = "Update Student SET fname = ?, lname = ? WHERE rollno = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            // Set the new values for the first and last name
            ps.setString(1, "Mahesh");
            ps.setString(2, "Nalkande");
            // Set the roll number of the record to be updated
            ps.setInt(3, 1);
            int rowsAffected = ps.executeUpdate(); // Execute the update operation
            System.out.println(rowsAffected + " rows updated");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
