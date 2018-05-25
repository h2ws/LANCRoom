package com.oyyd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
* Title: UsersDao
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月23日
*/
public class UsersDao {
	
	
	/**
	 * 获取all集合
	 * @return
	 * @throws SQLException
	 */
	static public Set<Entry> selAll() throws SQLException {
		Set<Entry> ret = new HashSet<Entry>();
		Connection conn = ConnectDao.getConn();
		String sql = "select * from users";
		Statement stm = conn.createStatement();
		ResultSet resultset =  stm.executeQuery(sql);
		while(resultset.next()) {
			int uid = resultset.getInt("uid");
			String username = resultset.getString("username");
			String realname = resultset.getString("realname");
			String password = resultset.getString("password");
			String sign = resultset.getString("sign");
			java.sql.Date rgdate = resultset.getDate("rgdate");
			java.sql.Date birthdate = resultset.getDate("birthdate");
			Entry entry = new Entry(uid, username, realname, password, sign, rgdate, birthdate);
			ret.add(entry);
			
		}
		
		resultset.close();
		stm.close();
		conn.close();

		return ret;
	}
	
	/**
	 * 单值查询,并返回
	 * @param username
	 * @param pwd
	 * @return
	 * @throws SQLException 
	 */
	static public Entry setOnly(String username, String pwd) throws SQLException{
		Connection conn = ConnectDao.getConn();
		String sql = "select * FROM where username = ? and password = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, pwd);
		ResultSet resultset = pre.executeQuery();
		boolean only = resultset.next();
		Entry entry = null;
		if (only) {
			int uid = resultset.getInt("uid");
			String realname = resultset.getString("realname");
			String sign = resultset.getString("sign");
			java.sql.Date rgdate = resultset.getDate("rgdate");
			java.sql.Date birthdate = resultset.getDate("birthdate");
			entry = new Entry(uid, username, realname, pwd, sign, rgdate, birthdate);
		}
		
		pre.close();
		conn.close();
		
		return entry;
	}

	/**
	 * 新增一个数据项，并返回对应实体
	 * username重名则抛出异常
	 * @param username
	 * @param pwd
	 * @throws SQLException 
	 */
	static public Entry add(String username, String pwd) throws SQLException {
		Connection conn = ConnectDao.getConn();
		String sql = "insert into users (username, password) vlaue (?, ?)";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setString(1, username);
		pre.setString(2, pwd);
		pre.executeUpdate();

		pre.close();
		conn.close();
		
		return new Entry(username, pwd);
	}

	/**
	 * 从表中删除对应数据
	 * @param user
	 * @throws SQLException
	 */
	static public void del(Entry user) throws SQLException {
		Connection conn = ConnectDao.getConn();
		String sql = "delete users where uid = ?";
		PreparedStatement pre = conn.prepareStatement(sql);
		pre.setInt(1, user.getUid());
		pre.executeUpdate();
		
		pre.close();
		conn.close();
		
		user = null;
	}
	
//	static public 
	
	static public class Entry {
		private int uid;
		private String username;
		private String realname ;
		private String password;
		private String sign;
		private java.sql.Date rgdate;
		private java.sql.Date birthdate;
		
		

		public Entry(int uid, String username, String realname, String password, String sign, java.sql.Date rgdate,
				java.sql.Date birthdate) {
			super();
			this.uid = uid;
			this.username = username;
			this.realname = realname;
			this.password = password;
			this.sign = sign;
			this.rgdate = rgdate;
			this.birthdate = birthdate;
		}
		
		public int getUid() {
			return uid;
		}
		
		public Entry(String username, String pwd) {
			this.username = username;
			this.password = pwd;
		}
	}
	
	private UsersDao(){};
}