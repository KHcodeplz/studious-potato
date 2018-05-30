package com.common.connect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		
		String prop_Path = JDBCTemplate.class.getResource("/config/driver.properties").getPath(); 
		
		try {
			prop.load(new FileReader(prop_Path));
			
//			use in oracle & windows
//			
			String driver = prop.getProperty("oracleDriver");
			String url = prop.getProperty("oracleURL");
			String dbid = prop.getProperty("oracleID");
			String dbpw = prop.getProperty("oraclePW");
//			
			
//			use in mysql & mac os
			
//			String driver = prop.getProperty("mysqlDriver");
//			String url = prop.getProperty("mysqlURL");
//			String dbid = prop.getProperty("mysqlID");
//			String dbpw = prop.getProperty("mysqlPW");
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, dbid, dbpw);
			
			con.setAutoCommit(false);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}