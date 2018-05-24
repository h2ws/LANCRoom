package com.oyyd.chatroom.common;

/**
* Title: Client
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 客户端的抽象
*/
public abstract class Client {

	/**
	 * 提供帮助,一般打印使用说明
	 */
	public abstract void help();

	/**
	 * @param ip
	 * @param port
	 * @return 服务端实例
	 * 	通过ip和port连接服务端
	 */
	public abstract Server connectServer(String ip, int port);
}
