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
		Task parsetask = null;
		parsetask = new Task (){
			public String exec() {
				return null;
			}

			@Override
			public int getTaskId() {
				// TODO Auto-generated method stub
				return 0;
			}
		};

		return parsetask;
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
