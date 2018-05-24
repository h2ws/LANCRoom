package com.oyyd.client;

import com.oyyd.dao.UsersDao;
import com.oyyd.server.oyyDServer;

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.*;

public class oyyDClient {
	public static void main(String[] arjgs) {
		/* 登录 */
		//0. 设置服务端 IP port
		//1.注册 或者 登录
		//发现上次使用的服务端信息，是否使用？X
		//或.未发现服务端信息，请手动输入X

		Scanner sc = new Scanner(System.in);
		String IP = sc.next();
		int port = sc.nextInt();
		oyyDClient client = new oyyDClient();
		client.server = getServer(IP, port);
		
		//登录大循环 begin:
		big: while(true) {
			System.out.println("提示：输入r键，注册。若已有账户，输入其他任意键即可");
			String tidy = null;
			tidy = sc.next();
			//选择是否进入注册子系统
			
			
			//注册 begin
			while(tidy.equals("r")) {
				System.out.println("已进入注册子系统，输入@c返回上一级");
				String rg_user = sc.next();
				String rg_password = sc.next();
				if ( rg_user.equals("@c") || rg_password.equals("@c") ) {
					continue big;
				}
				client.user_entry = client.server.regUser(rg_user, rg_password);
				if (client.user_entry == null) {
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
			
			client.user_entry = client.server.login("user", "password");
			if (client.user_entry != null) {
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


	public oyyDServer server = null;
	public UsersDao.Entry user_entry = null;
	
	
	private boolean server_load(String snc) {
		boolean ret = true;
//		try {
//			FileReader r = new FileReader("./Dconfig.data");
//			String cfg = r.read
//		} catch (Exception e) {
//			ret = false;
//		}
//		finally{
//			return ret;
//		}
			return ret;
	}

	static private oyyDServer getServer(String IP, int port) {
		return null;
	}
	
	static private void resetting() {
		Scanner sc = new Scanner(System.in);
		boolean yesorno;
		System.out.println("输入服务端IP和端口，例如：135.32.53.12:8123");
		do {
			String ser_adr = sc.next();
			
			// 表达式对象(比较粗糙的验证
			Pattern p = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}:\\d{1,10}$");
			
			// 创建 Matcher 对象
			Matcher m = p.matcher(ser_adr);
			
			// 是否完全匹配
			 yesorno = m.matches();
		}
		while (!yesorno);
	}
	
	
	
}
