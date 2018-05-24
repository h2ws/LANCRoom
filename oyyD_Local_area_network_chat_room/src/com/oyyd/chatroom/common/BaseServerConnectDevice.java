package com.oyyd.chatroom.common;

import java.io.IOException;
import java.net.UnknownHostException;

/**
* Title: ServerConnectDevice
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月25日
* 服务器连接驱动
* 1.获取一个协调线程
*/
public abstract class BaseServerConnectDevice implements Iconcertable{
	public abstract void connectServer(String host, int port) throws UnknownHostException, IOException;
}
