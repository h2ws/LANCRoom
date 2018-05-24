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
	public static void main(String[] arjgs) {
		/* 登录 */
		//0. 设置服务端 IP port
		//1.注册 或者 登录
		//发现上次使用的服务端信息，是否使用？X
		//或.未发现服务端信息，请手动输入X
		
		//步骤精简！
		//1.连接服务端
		//2.循环给服务端发送命令

		Scanner sc = new Scanner(System.in);
		String ip = sc.next();
		int port = sc.nextInt();
		OyydClient client = new OyydClient();
		client.server = client.connectServer(ip, port);
		
		//登录大循环 begin:
		big: while(true) {
			System.out.println("提示：输入r键，注册。若已有账户，输入其他任意键即可");
			String tidy = null;
			tidy = sc.next();
			//选择是否进入注册子系统
			
			
			//注册 begin (move to server
			while("r".equals(tidy)) {
				System.out.println("已进入注册子系统，输入@c返回上一级");
				String rgUser = sc.next();
				String rgPassword = sc.next();
				if (  "@c".equals(rgUser) || "@c".equals(rgPassword) ) {
					continue big;
				}
				client.userEntry = client.server.regUser(rgUser, rgPassword);
				if (client.userEntry == null) {
					System.out.println("注册失败");
				}
				else {
					System.out.println("注册成功，已退出注册子系统");
					continue big;
				}
			}
			//注册 end
			
			System.out.println("输入你的用户名和密码");

			String user = sc.next();
			String password = sc.next();
			
			client.userEntry = client.server.login("user", "password");
			if (client.userEntry != null) {
				System.out.println("登录成功！");
				break;
			}
			else {
				System.out.println("登录失败，请再次输入！");
			}
		}
		//登录循环 end
	
		
		//主循环， 循环提交命令。
		while(true) {
			String order = sc.next();
			client.server.exe_order(order);
		}
	}


	/**
	 * 客户端所代表的 user实体
	 */
	public OyydServer server = null;           

	/**
	 * 客户端所连接上的服务端实例
	 */
	public UsersDao.Entry userEntry = null;   
	
	
	private boolean serverLoad(String snc) {
		return true;
	}

	private OyydServer connectServer(String ip, int port) {
		return null;
	}

	
	private final static Pattern PAT_ADDRESS = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}:\\d{1,10}$");
	
	
	/**
	 * 
	 * 设置 服务器的pi和port
	 */
	private void resetting() {
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
	
	
	
}
