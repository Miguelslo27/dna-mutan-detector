package com.dna.analyzer.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection connection = null;

		String dbProtocol = "jdbc:mysql://";
		String dbHost = System.getenv("MYSQL_HOST");
		String dbPort = System.getenv("MYSQL_PORT");
		String dbName = System.getenv("MYSQL_DBNAME");
		String dbUser = System.getenv("MYSQL_USER");
		String dbPass = System.getenv("MYSQL_PASS");

		try {
			connection = DriverManager.getConnection(dbProtocol + dbHost + ":" + dbPort + "/" + dbName, dbUser, dbPass);

			if (connection != null) {
				System.out.println("No errors connecting to the Data Base!");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return connection;
	}
}
