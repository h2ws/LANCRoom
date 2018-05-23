package com.oyyd.Dao;


public class UsersDao {
	static public void register(String nickname) {
		
	}
	
	static public class Entry {
		private int uid;
		private String nickname;
		private String realname ;
		private String sign;
		private String rgdate;
		private String birthdate;
		
		public Entry(String nickname) {
			this.nickname = nickname;
		}
	}
	
	private UsersDao(){};
}
