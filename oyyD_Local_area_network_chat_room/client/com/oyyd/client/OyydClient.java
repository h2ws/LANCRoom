package com.oyyd.client;

import com.oyyd.dao.UsersDao;
import com.oyyd.server.OyydServer;
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

	/**
	 * 客户端所代表的 user实体
	 */
	public OyydServer server = null;   
	
	/**
	 * 客户端所连接上的服务端实例
	 */
	public UsersDao.Entry userEntry = null;

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

		String ip;
		int port;
		if (/*有历史记录*/false) {
			/* */
		}
		else {
			String ipPort;
			do {
				System.out.println("输入服务端ip:port");
				ipPort = sc.next();
			}
			while (!isIpPort(ipPort) );
			int signP = ipPort.indexOf(":");

			ip = ipPort.substring(0,  signP);
			port = Integer.valueOf( ipPort.substring(signP + 1) );
		}
		client.server = client.connectServer(ip, port);
		
	
		
		//主循环， 循环提交命令。
		while(true) {
			String order = sc.next();
			client.server.exe_order(order, client);
		}
	}           


	/**
	 * 连接服务端
	 * @param ip 
	 * @param port
	 * @return 服务端实例
	 */
	private OyydServer connectServer(String ip, int port) {
		return null;
	}

	
	/**
	 * 
	 * 判断 符合ip:port格式的字符串
	 */
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
	}
	
	
	private boolean serverLoad(String snc) {
		return true;
	}
	
	
	
}
