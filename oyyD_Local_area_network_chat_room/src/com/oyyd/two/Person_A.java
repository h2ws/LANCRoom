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
	//����һ�� ������Ϣ�� �߳�
	//  A:8123  B:8222
	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner sc = new Scanner(System.in);
		System.out.print("���������Ϣ�Ķ˿�");
		int accpt_port = sc.nextInt();
		ReadThread readthread = new ReadThread(accpt_port);
		readthread.start();
		
		System.out.print("���������Ϣ�Ķ˿�");
		int out_port = sc.nextInt();
		String ip = sc.next();
		//������ֱ������һ�����ݲ�ȷ��
		//�ᷢ���ݷ��͵�ĳ���˿�
		//��������ѭ������������
		
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
