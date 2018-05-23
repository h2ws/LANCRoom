package com.oyyd.two;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Person_A {
	//开启一个 接收信息的 线程
	//  A:8123  B:8222
	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner sc = new Scanner(System.in);
		System.out.print("输入接受信息的端口");
		int accpt_port = sc.nextInt();
		ReadThread readthread = new ReadThread(accpt_port);
		readthread.start();
		
		System.out.print("输入输出信息的端口");
		int out_port = sc.nextInt();
		String ip = sc.next();
		//阻塞，直到输入一行数据并确定
		//会发数据发送到某个端口
		//进入下轮循环，继续阻塞
		
		while(true) {
//			Scanner sc = new Scanner(System.in);
			String line = sc.next();
			
			Socket sk = new Socket(ip, out_port);
			OutputStream osm = sk.getOutputStream();
			Writer writer = new OutputStreamWriter(osm);
			BufferedWriter bufwriter = new BufferedWriter(writer);
			
			bufwriter.write(line);
			bufwriter.flush();
			
			osm.close();
			writer.close();
			bufwriter.close();
			sk.close();
		}
		
	}
}
