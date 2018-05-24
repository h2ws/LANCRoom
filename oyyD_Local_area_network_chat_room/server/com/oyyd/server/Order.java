package com.oyyd.server;

/**
* Title: Order
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 命令类
*/
public class Order {
	/*
	 * 1.判断是否为某个命令
	 * 2.如果是命令则执行，返回true
	 *   不是命令返回false
	 * 3.命令的静态final变量
	 */
	public static final int HELP = 0;
	public static final int ROOM_LIST = 1;
	public static final int NEW_ROOM = 2;
	public static final int JOIN_ROOM = 3;
	public static final int OUT_ROOM = 4;
	public static final int SET_ROOM = 5;
	public static final int REG = 6;
	public static final int LOGIN = 7;
	
	public Order(String str) {
		isExec = true;
	}
	
	/**
	 * @param str
	 * @return 判断为命令
	 */
	static public boolean isOrder(String str) {
		return true;
	}

	/**
	 * @param str
	 * @param iord 
	 * @return 判断是为iord命令
	 */
	static public boolean isOrder(String str, int iord) {
		return true;
	}

	/**
	 * @return 执行命令，并返回结果字符串，null
	 *
	 */
	public String exec() {
		if(isOrder) {
			return null;
		}
		else {
			return null;
		}
	}

//				case "help":System.out.println("你求我呀~");break;
//				case "room_list": /* 数据库查询一下 */break;
//				case "new_room": /*par name [password] */break;
//				case "join_room": /*par name [password] :可通过id或者name加入*/break;
//				case "out_room": break;
//				case "set_room": break;
}
