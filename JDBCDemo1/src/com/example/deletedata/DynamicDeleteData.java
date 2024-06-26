package com.example.deletedata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DynamicDeleteData {

	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/bikkadit_jdbc";
		String user ="root";
		String pass ="Shubham0342@";
		String deleteQuery ="delete from Student where rollno = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = conn.prepareStatement(deleteQuery);
			ps.setInt(1, 2);
			int executeUpdate = ps.executeUpdate();
			System.out.println(executeUpdate +"rows deleted");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
