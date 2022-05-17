package com.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bitmy {
	private static Connection conn;
	private final static String driver = "com.mysql.cj.jdbc.Driver";
	private final static String url = "jdbc:mysql://localhost:3306/scott";
	private final static String user = "user01";
	private final static String pw = "1234";
	
	
	private Bitmy() {}
	
	public static Connection getConnection() throws SQLException {
		if(conn==null || conn.isClosed()) {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(url,user,pw);
		}
		return conn;
	}
}
