package com.oyyd.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

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
	private Connection _conn;
	public Connection getConn(String IP,int port) {
		if (_conn.isClosed()) {
			_conn = DriverManager.getConnection(String.format("jdbc:thin:@{0}:{1}8",IP,port),
		}
		_conn.close();
		return _conn;
	}
	
}
