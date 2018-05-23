package com.oyyd.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadThread extends Thread{
	//这个线程回去port端口检查有没有数据包，一直阻塞
	//直到有数据包，显示，然后继续阻塞检查数据包
	
	private int port;
	public void run() {
		try {
			
			
			ServerSocket ssk =  new ServerSocket(port);
			Socket sk = null;
			while (true) {
				sk = ssk.accept();
				//阻塞，直到有port端口有数据包
				
				InputStream ism = sk.getInputStream();
				Reader reader= new InputStreamReader(ism);
				//获取数据包的数据流，为了方便，搭建桥梁流 （InputStreamReader

				BufferedReader bufreader = new BufferedReader(reader);
				//为方便，搭建缓冲流 （可以一次读取一行字符串
				
				String line = bufreader.readLine();
				System.out.println("I:"+line);
				
				//读取一行，并输出，进入下轮 （这里假设只发送单行数据
				
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
