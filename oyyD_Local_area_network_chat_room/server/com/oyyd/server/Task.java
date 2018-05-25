package com.oyyd.server;

/**
* Title: Order
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 任务类:将字符串解析成方利于执行的任务
*/
public abstract class Task {
	public static void main(String[] args) {
		String str = "@help";
		String[] strs = str.split("\\s+");
	}
	/*
	 * 任务ID对照表,方便判断
	 */
	public static final int HELP = 0;
	public static final int ROOM_LIST = 1;
	public static final int NEW_ROOM = 2;
	public static final int JOIN_ROOM = 3;
	public static final int OUT_ROOM = 4;
	public static final int SET_ROOM = 5;
	public static final int REG = 6;
	public static final int LOGIN = 7;
	public static final int TALK = 8;
	
	/**
	 * 获取任务id
	 * @return 任务id
	 */
	public abstract int getTaskId();
	
	/**
	 * 将命令解析并构造成相应的任务 (无法解析就返回null
	 * @param str
	 */
	static public Task parseTask(String str) {
		Task parsedtask = null;
		String[] stage = str.split("\\s+");
		switch(stage[0]) {
		case "@help": parsedtask = new Task() {
				public int getTaskId(){
					return Task.HELP;
				}

				public String exec(){
					return "这个oyyd服务端";
				}
				
			};break;
		
		case "@room_list": parsedtask = new Task(){
				public int getTaskId(){
					return Task.ROOM_LIST;
				}
				
				public String exec(){
					//查询房间池
					return null;
				}
		};
		
		case "@new_room": parsedtask = new Task(){
				public int getTaskId() {
					return Task.NEW_ROOM;
				}
				
				public String exec(){
					//用房间池对象新增房间
					return null;
				}
		};
		
		case "@join_room": parsedtask = new Task() {
				public int getTaskId() {
					return Task.JOIN_ROOM;
				}
				
				public String exec() {
					//用房间池往房间内加入用户
					return null;
				}
		};
		
		case "@out_room": parsedtask = new Task() {
				public int getTaskId() {
					return Task.OUT_ROOM;
				}
				
				public String exec() {
					//从房间池删除用户
					return null;
				}
		};
		
		case "@set_room": parsedtask = new Task() {
				public int getTaskId() {
					return Task.SET_ROOM;
				}
				
				public String exec() {
					//设置房间池内的房间
					return null;
				}
		};
		
		case "@reg": parsedtask = new Task() {
				public int getTaskId() {
					return Task.REG;
				}
				
				public String exec() {
					//通过地址池，注册用户 (仅仅是在数据库新增数据项
					return null;
				}
		};
		
		case "@login": parsedtask = new Task() {
				public int getTaskId() {
					return Task.LOGIN;
				}
				
				public String exec() {
					//通过地址池，登录用户
					return null;
				}
		};
		
		case "@talk": parsedtask = new Task() {
				public int getTaskId() {
					return Task.TALK;
				}
				
				public String exec() {
					//用过地址池和房间池，发送消息
					return null;
				}
				
		};
			
		
		}
		
		return parsedtask;
	}
	
	/**
	 * 判断是否为指定的任务id
	 * @param id
	 * @return 此任务是指定的任务id
	 */
	public boolean isTaskId(int id) {
		return getTaskId() == id;
	}

	/**
	 * 抽象的执行命令方法，由解析方法具体实现
	 * @return 执行命令，并返回结果字符串，null
	 *
	 */
	public abstract String exec();

}
