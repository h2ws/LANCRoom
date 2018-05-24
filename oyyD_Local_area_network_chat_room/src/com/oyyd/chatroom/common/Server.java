package com.oyyd.chatroom.common;

/**
* Title: Server
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 服务端的抽象
*/
public abstract class Server {

	/**
	 * 提供帮助,一般打印使用说明
	 */
	public abstract void help();

	/**
	 * @param strOrder 运行命令
	 * 使用服务端执行命令
	 */
	public abstract void execOrder(String strOrder);
	
	/**
	 * @return 反馈信息的线程 
	 */
	public abstract Thread getThread();
}
