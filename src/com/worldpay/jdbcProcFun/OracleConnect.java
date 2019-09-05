package com.worldpay.jdbcProcFun;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.CallableStatement;

public class OracleConnect {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DBURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DBPASS = "abc123";
	private static final String DBUSER = "ashi";
	//private static final String DBNAME = "ashi";
	private static Connection Conn;
	
	public static Connection getConn() {
		return Conn;
	}

	public static void setConn(Connection conn) {
		Conn = conn;
	}

	public static void ConnectDB() {
		try {
			Class.forName(DRIVER);
			Conn = DriverManager.getConnection(DBURL , DBUSER, DBPASS);
			//cs = Conn.pre();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void close() {
		try{
				Conn.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		
		}
     
}
}
