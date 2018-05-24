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
	 * 获取一个协调线程
	 * :所有服务端反馈都由它接收处理
	 * @return
	 */
	public abstract Thread getConcertThread();
	
}
