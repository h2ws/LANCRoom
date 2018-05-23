package com.oyyd.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadThread extends Thread{
	//����̻߳�ȥport�˿ڼ����û�����ݰ���һֱ����
	//ֱ�������ݰ�����ʾ��Ȼ���������������ݰ�
	
	private int port;
	public void run() {
		try {
			
			
			ServerSocket ssk =  new ServerSocket(port);
			Socket sk = null;
			while (true) {
				sk = ssk.accept();
				//������ֱ����port�˿������ݰ�
				
				InputStream ism = sk.getInputStream();
				Reader reader= new InputStreamReader(ism);
				//��ȡ���ݰ�����������Ϊ�˷��㣬������� ��InputStreamReader

				BufferedReader bufreader = new BufferedReader(reader);
				//Ϊ���㣬������� ������һ�ζ�ȡһ���ַ���
				
				String line = bufreader.readLine();
				System.out.println("I:"+line);
				
				//��ȡһ�У���������������� ���������ֻ���͵�������
				
				ism.close();
				reader.close();
				bufreader.close();
				sk.close();
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ReadThread(int port){
		this.port = port;
	}

}
