package com.oyyd.client;

import com.oyyd.chatroom.common.Server;
import com.oyyd.chatroom.common.SimpleSocket;
import com.oyyd.dao.UsersDao;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.regex.*;

/**
* Title: oyyDClient
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
*/
public class OyydClient {

	/**
	 * address(host:port)验证
	 */
	private final static Pattern PAT_ADDRESS = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}:\\d{1,10}$");

	public static void main(String[] arjgs) {
		/* 登录 */
		//0. 设置服务端 IP port
		//1.注册 或者 登录
		//发现上次使用的服务端信息，是否使用？X
		//或.未发现服务端信息，请手动输入X
		
		//步骤精简！
		//1.连接服务端
		//  -有历史连接记录
		//  -输入ip:port 

		//2.循环给服务端发送命令

		Scanner sc = new Scanner(System.in);
		OyydClient client = new OyydClient();

		String host;
		int port;
		OyydServerConnectDevice serdevice = null;
		if (/*有历史记录*/false) {
			/* */
		}
		else {
			String ipPort;
			err: do {
				System.out.println("输入服务端ip:port");
				ipPort = sc.next();
				int signP = ipPort.indexOf(":");

				host = ipPort.substring(0,  signP);
				port = Integer.valueOf( ipPort.substring(signP + 1) );

				if(!isIpPort(ipPort) )continue err;

				try {
					serdevice = new OyydServerConnectDevice();
					serdevice.connectServer(host, port);
				} catch (UnknownHostException e) {
					System.out.println("UHEX:连接失败");
					continue err;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("IOEX:连接失败");
					continue err;
				}

			}
			while (false);

		}
		
	
		
		//主循环， 循环提交命令。
		while(true) {
			String sendText = sc.next();
			try {
				serdevice.send(sendText);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("simpleSend失败");
			}
		}
		
		//-------------new
		
	}           


	
	static private boolean isIpPort(String ipPort) {
		Scanner sc = new Scanner(System.in);
		boolean yesorno;
		System.out.println("输入服务端IP和端口，例如：135.32.53.12:8123");
		do {
			String serverAddress = sc.next();
			
			// 创建 Matcher 对象
			Matcher m = PAT_ADDRESS.matcher(serverAddress);
			
			// 是否完全匹配
			 yesorno = m.matches();
		}
		while (!yesorno);
		return true;
	}
	
	
	
	
}
