package com.oyyd.chatroom.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream.GetField;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* Title: simpleSend
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 需协调的,可简单操作Socket
* 
*/
public class SimpleSocket {
	public SimpleSocket(String host, int port) throws UnknownHostException, IOException {
		this.socket = new Socket(host, port);
	}
	
	private Socket socket;
	
	public SimpleSocket(Socket socket) {
		this.socket = socket;
	}
	
	
	/**
	 * 简单的发送，给出发送的字符串即可
	 * @param sendstr 发送的字符串
	 * @throws IOException 可能的异常
	 */
	public void simpleSend(String sendstr) throws IOException{
		OutputStream out = this.socket.getOutputStream();
		OutputStreamWriter outwriter = new OutputStreamWriter(out);
		BufferedWriter bufwriter = new BufferedWriter(outwriter);
		
		bufwriter.write(sendstr);
		
		bufwriter.close();
		outwriter.close();
		out.close();
	}
	
	/**
	 * 简单的读取一行字符串，调用即可
	 * @return 读取到的一行字符串，可能为null
	 * @throws IOException
	 */
	public String simpleReadLine() throws IOException{
		InputStream input = this.socket.getInputStream();
		InputStreamReader inputreader = new InputStreamReader(input);
		BufferedReader bufreader = new BufferedReader(inputreader);
		
		String ret = null;
		ret = bufreader.readLine();
		
		bufreader.close();
		inputreader.close();
		input.close();
		
		return ret;
	}
}
