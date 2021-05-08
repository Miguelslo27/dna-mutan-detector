package com.dna.analyzer.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dna_registry", "root", "");
			
			if (connection != null) {
				System.out.println("No errors connecting to the Data Base!");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return connection;
	}
}