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
			//命令区
			String[] order_items= order.split("\\s+");
			switch(order_items[0]) { 
				case "help":System.out.println("你求我呀~");break;
				case "room_list": /* 数据库查询一下 */break;
				case "new_room": /*par name [password] */break;
				case "join_room": /*par name [password] :可通过id或者name加入*/break;
				case "out_room": break;
				case "set_room": break;
				default: System.out.println("无效的命令");
			}
			
		}
		else {
			//消息区
			
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
			throw new Exception("异常... user == null");
		}
		//--------极端代码----------------------
		
		
		
		if (room == null) {
			System.out.println("房间不存在");
			return false;
		}
		

		if(password == null && room.getPassword() != null) {
			System.out.println("此房间需要密码");
			return false;
		}
		else if(password != null && room.getPassword() != null && !password.equals(room.getPassword()) ) {
			System.out.println("密码不正确");
			return false;
		}
		/*else:密码正确*/
		
		if(/*已经在房间里*/) {
			System.out.println("已经在此房间了");
		}
		else {
			/*使用户加入此房间*/
			
		}
	}

}
