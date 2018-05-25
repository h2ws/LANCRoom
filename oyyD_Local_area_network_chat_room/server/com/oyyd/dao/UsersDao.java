package com.oyyd.dao;


/**
* Title: UsersDao
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月23日
*/
public class UsersDao {

	/**
	 * username重名则抛出异常
	 * @param username
	 * @param pwd
	 */
	static public void register(String username, String pwd) {
		
	}
	
//	static public 
	
	static public class Entry {
		private int uid;
		private String username;
		private String realname ;
		private String password;
		private String sign;
		private String rgdate;
		private String birthdate;
		
		public Entry(String username) {
			this.username = username;
		}
	}
	
	private UsersDao(){};
}