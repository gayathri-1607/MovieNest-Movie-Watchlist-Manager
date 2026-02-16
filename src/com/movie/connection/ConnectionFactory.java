package com.movie.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String url = "jdbc:mysql://localhost:3306/advancejava";
	private static final String sqluser  = "root";
	private static final String sqlpass = "Gayathri@16";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, sqluser, sqlpass);
	}
}
