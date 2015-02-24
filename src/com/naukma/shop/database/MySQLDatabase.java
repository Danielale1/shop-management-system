package com.naukma.shop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class MySQLDatabase {
	
	private Connection con;
	private static MySQLDatabase instance = null;
	
	public static final String URL = "jdbc:mysql://37.140.192.17/u0044137_default";
	public static final String USER = "u0044137_default";
	public static final String PASSWORD = "hTrzP0p~tJB@";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	private MySQLDatabase() {
		try {
			Class.forName(DRIVER_CLASS);
			try {
				con = DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLDatabase getInstance() {
		if (instance == null) {
			instance = new MySQLDatabase();
		}
		return instance;
	}

	public ResultSet execute(String query) {
		try {
			Statement s = con.createStatement();
			
			s.execute(query);
			ResultSet rs = s.getResultSet();

			return rs;
		}

		catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return null;
	}
}
