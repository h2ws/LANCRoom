package com.oyyd.server;

import com.oyyd.dao.RoomsDao;
import com.oyyd.dao.UsersDao;
import com.oyyd.client.OyydClient;
import java.util.Set;

/**
* Title: OyydServer
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
*/
public class OyydServer {
	public OyydServer() {
		this.rooms = RoomsDao.getRooms();
	}

	public UsersDao.Entry regUser(String nickname, String password) {
		return null;
	}
	
	public UsersDao.Entry login(String nickname, String password) {
		//
		return null;
	}
	
	public OyydServer(String ip, int port) {
			System.out.print(">未登录 提示: \n"
					+         "注册用户命令 @reg 用户名 密码         e.g: @reg oyy 123456\n"
					+ 		  "登录用户命令 @login 用户名 密码      e.g: @login oyy 123456\n");
	}
	
	public void exe_order(String strOrder, OyydClient client) {
		if(order == null || client == null)return;
		//非空验证

		if(client.server != this) return;
		//此客户端 连接的 服务端 与当前实例不一致
		//即 : 命令只能运行在此客户端绑定的服务端
		
		
		boolean isLogin = client.userEntry != null;
		if (!isLogin) {
			//未登录:

			//只能是REG，LOGIN命令
			if (Order.isOrder(strOrder, Order.REG) || Order.isOrder(strOrder, Order.LOGIN)) {
				Order realOrder = new Order(strOrder);
				realOrder.exec();
			}
			else {
			//若不是，则打印未登录提示
				System.out.print(">未登录 提示: \n"
						+         "注册用户命令 @reg 用户名 密码         e.g: @reg oyy 123456\n"
						+ 		  "登录用户命令 @login 用户名 密码      e.g: @login oyy 123456\n");
			}
			
		}
		else if(Order.isOrder(strOrder)) {
			//如果是命令，则构造命令并并执行
			//命令区 (已登录
			Order realOrder = new Order(strOrder);
			String reuslt = realOrder.exec();
			System.out.println("执行结果:"+reuslt);
		}
		else {
			//消息区
			/* 发送消息 */
		}
		/*
		//登录大循环 begin:
		big: while(true) {
			String tidy = null;
			tidy = sc.next();
			//选择是否进入注册子系统
			
			
			//注册 begin (move to server
			while("r".equals(tidy)) {
				System.out.println("已进入注册子系统，输入@c返回上一级");
				String rgUser = sc.next();
				String rgPassword = sc.next();
				if (  "@c".equals(rgUser) || "@c".equals(rgPassword) ) {
					continue big;
				}
				client.userEntry = client.server.regUser(rgUser, rgPassword);
				if (client.userEntry == null) {
					System.out.println("注册失败");
				}
				else {
					System.out.println("注册成功，已退出注册子系统");
					continue big;
				}
			}
			//注册 end
			
			System.out.println("输入你的用户名和密码");

			String user = sc.next();
			String password = sc.next();
			
			client.userEntry = client.server.login("user", "password");
			if (client.userEntry != null) {
				System.out.println("登录成功！");
				break;
			}
			else {
				System.out.println("登录失败，请再次输入！");
			}
		}
		//登录循环 end
		 * */
	}
	
	private Set<RoomsDao.Entry> rooms;
	
	private boolean out_room(OyydClient client){
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
