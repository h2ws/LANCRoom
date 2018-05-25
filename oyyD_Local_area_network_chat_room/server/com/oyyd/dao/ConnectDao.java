package com.oyyd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Title: ConnectDao
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月25日
* 单例模式的连接操作
*/
public class ConnectDao {
	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private ConnectDao(){}
	
	static final private String HOST = "127.0.0.1";
	static final private int PORT = 8255;
	
	static private Connection _conn;
	static public Connection getConn() throws SQLException {
		if (_conn == null ||_conn.isClosed()) {
			_conn = DriverManager.getConnection(String.format("jdbc:thin:@{0}:{1}8",HOST,PORT));
		}
		return _conn;
	}
	static public void close() throws SQLException {
		if (_conn != null && !_conn.isClosed()) {
			_conn.close();
		}
	}
	
}
