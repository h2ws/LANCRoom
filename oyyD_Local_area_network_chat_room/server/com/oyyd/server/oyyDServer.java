package com.oyyd.server;

import com.oyyd.Dao.RoomsDao;
import com.oyyd.Dao.UsersDao;
import java.util.Set;

public class oyyDServer {
	public oyyDServer() {
		this.rooms = RoomsDao.getRooms();
	}

	public UsersDao.Entry regUser(String nickname, String password) {
		return null;
	}
	
	public UsersDao.Entry login(String nickname, String password) {
		//
		return null;
	}
	
	public oyyDServer(String ip, int port) {
		
	}
	
	public void exe_order(String order) {
		if(order == null)return;
		
		if (order.charAt(0) == '@') {
			//������
			String[] order_items= order.split("\\s+");
			switch(order_items[0]) { 
				case "help":System.out.println("������ѽ~");break;
				case "room_list": /* ���ݿ��ѯһ�� */break;
				case "new_room": /*par name [password] */break;
				case "join_room": /*par name [password] :��ͨ��id����name����*/break;
				case "out_room": break;
				case "set_room": break;
				default: System.out.println("��Ч������");
			}
			
		}
		else {
			//��Ϣ��
			
		}
	}
	
	private Set<RoomsDao.Entry> rooms;
	
	private boolean out_room(oyyDClient client){
		client.room = null;
	}

	private RoomsDao.Entry new_room(String name) {
		return null;
	}
	
	private boolean join_room (RoomsDao.Entry room, UsersDao.Entry user, String password)
	throws Exception {
		/*  */
		if(user == null) {
			throw new Exception("�쳣... user == null");
		}
		//--------���˴���----------------------
		
		
		
		if (room == null) {
			System.out.println("���䲻����");
			return false;
		}
		

		if(password == null && room.getPassword() != null) {
			System.out.println("�˷�����Ҫ����");
			return false;
		}
		else if(password != null && room.getPassword() != null && !password.equals(room.getPassword()) ) {
			System.out.println("���벻��ȷ");
			return false;
		}
		/*else:������ȷ*/
		
		if(/*�Ѿ��ڷ�����*/) {
			System.out.println("�Ѿ��ڴ˷�����");
		}
		else {
			/*ʹ�û�����˷���*/
			
		}
	}

}
