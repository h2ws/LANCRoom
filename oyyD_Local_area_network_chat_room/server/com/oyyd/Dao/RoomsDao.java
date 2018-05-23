package com.oyyd.Dao;

import java.util.Set;

public class RoomsDao {
	
	static public Set<RoomsDao.Entry> getRooms(){
		/*获取所有房间
		 * 从数据库获取所有Room
		 * */
	}
	
	static public RoomsDao.Entry getRoom(int id){
		/* 查询id，获取房间 */
		return null;
	}
	
	static public RoomsDao.Entry getRoom(String name) {
		/* 查询name，获取房间 */
		return null;
	}
	
	static public RoomsDao.Entry createRoom(String name, UsersDao.Entry user, String password) {
		/* 从数据库构造一个新房间, 并获取此房的id，用于构造相应的实体*/
		RoomsDao.Entry entry = new RoomsDao.Entry(-999, name, user, password);
		return entry;
	}

	static public class Entry {
		private int id;
		private String name;
		private UsersDao.Entry init_per;
		private String password;
		private Set<UsersDao.Entry> parts = null;
		public Entry(int id, String name, com.oyyd.Dao.UsersDao.Entry init_per, String password) {
			super();
			this.id = id;
			this.name = name;
			this.init_per = init_per;
			this.password = password;
		}
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public UsersDao.Entry getInit_per() {
			return init_per;
		}
		public void setInit_per(UsersDao.Entry init_per) {
			this.init_per = init_per;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Set<UsersDao.Entry> getParts() {
			return parts;
		}
		public void setParts(Set<UsersDao.Entry> parts) {
			this.parts = parts;
		}
		
	}
}
