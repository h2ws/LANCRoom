package com.oyyd.client;

import java.io.IOException;
import java.net.UnknownHostException;

import com.oyyd.chatroom.common.BaseServerConnectDevice;
import com.oyyd.chatroom.common.SimpleSocket;

/**
* Title: OyydServerConnectDevice
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月25日
* 实现的服务器连接驱动
* 
*/
public class OyydServerConnectDevice extends BaseServerConnectDevice {
	
	/**
	 *  运行协调线程时,将此字段改成true.
	 *  只能在运行协调线程后发送信息
	 */
	private boolean ready = false;
	
	private SimpleSocket spsocket;

	@Override
	public void startConcertThread() {
		// TODO Auto-generated method stub
		Thread thread = new Thread() {
			
			@Override 
			public void run(){
				ready = true;
				while(true){
					String line = null;
					try {
						line = spsocket.simpleReadLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(line == null) continue;
					System.out.println(line);
				}

				/*balalalla
				 * 接收服务端信息,并打印
				 * */
			}
		};
		thread.start();
	}
	
	public void send(String sendtext) throws Exception{
		if(!ready){
			throw new Exception("必须开启协调线程");
		}
		spsocket.simpleSend(sendtext);
	}

	/* (non-Javadoc)
	 * @see com.oyyd.chatroom.common.BaseServerConnectDevice#connectServer(java.lang.String, int)
	 * 连接服务器
	 */
	@Override
	public void connectServer(String host, int port) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		this.spsocket = new SimpleSocket(host, port);
	}

	
}
