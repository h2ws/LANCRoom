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
		/* ��¼ */
		//0. ���÷���� IP port
		//1.ע�� ���� ��¼
		//�����ϴ�ʹ�õķ������Ϣ���Ƿ�ʹ�ã�X
		//��.δ���ַ������Ϣ�����ֶ�����X

		Scanner sc = new Scanner(System.in);
		String IP = sc.next();
		int port = sc.nextInt();
		oyyDClient client = new oyyDClient();
		client.server = getServer(IP, port);
		
		//��¼��ѭ�� begin:
		big: while(true) {
			System.out.println("��ʾ������r����ע�ᡣ�������˻��������������������");
			String tidy = null;
			tidy = sc.next();
			//ѡ���Ƿ����ע����ϵͳ
			
			
			//ע�� begin
			while(tidy.equals("r")) {
				System.out.println("�ѽ���ע����ϵͳ������@c������һ��");
				String rg_user = sc.next();
				String rg_password = sc.next();
				if ( rg_user.equals("@c") || rg_password.equals("@c") ) {
					continue big;
				}
				client.user_entry = client.server.regUser(rg_user, rg_password);
				if (client.user_entry == null) {
					System.out.println("ע��ʧ��");
				}
				else {
					System.out.println("ע��ɹ������˳�ע����ϵͳ");
					continue big;
				}
			}
			//ע�� end
			
			System.out.println("��������û���������");

			String user = sc.next();
			String password = sc.next();
			
			client.user_entry = client.server.login("user", "password");
			if (client.user_entry != null) {
				System.out.println("��¼�ɹ���");
				break;
			}
			else {
				System.out.println("��¼ʧ�ܣ����ٴ����룡");
			}
		}
		//��¼ѭ�� end
	
		
		//��ѭ���� ѭ���ύ���
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
		System.out.println("��������IP�Ͷ˿ڣ����磺135.32.53.12:8123");
		do {
			String ser_adr = sc.next();
			
			// ���ʽ����(�Ƚϴֲڵ���֤
			Pattern p = Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}:\\d{1,10}$");
			
			// ���� Matcher ����
			Matcher m = p.matcher(ser_adr);
			
			// �Ƿ���ȫƥ��
			 yesorno = m.matches();
		}
		while (!yesorno);
	}
	
	
	
}
