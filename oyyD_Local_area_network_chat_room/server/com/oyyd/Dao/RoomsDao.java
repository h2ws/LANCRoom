package com.oyyd.Dao;

import java.util.Set;

public class RoomsDao {
	
	static public Set<RoomsDao.Entry> getRooms(){
		/*��ȡ���з���
		 * �����ݿ��ȡ����Room
		 * */
	}
	
	static public RoomsDao.Entry getRoom(int id){
		/* ��ѯid����ȡ���� */
		return null;
	}
	
	static public RoomsDao.Entry getRoom(String name) {
		/* ��ѯname����ȡ���� */
		return null;
	}
	
	static public RoomsDao.Entry createRoom(String name, UsersDao.Entry user, String password) {
		/* �����ݿ⹹��һ���·���, ����ȡ�˷���id�����ڹ�����Ӧ��ʵ��*/
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
