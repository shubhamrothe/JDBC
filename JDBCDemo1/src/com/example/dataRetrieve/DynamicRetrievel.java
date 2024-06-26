package com.example.dataRetrieve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DynamicRetrievel {
	public static void main(String[] args) {

		String SelectQuery="Select * from Student where rollno= ?";
		try {
			String url = "jdbc:mysql://localhost:3306/bikkadit_jdbc";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, "root", "Shubham0342@");
			PreparedStatement ps = conn.prepareStatement(SelectQuery);
			ps.setInt(1, 2);
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("rollno") + " "+ rs.getString("fname") + " "+ rs.getString("lname"));
		}
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
