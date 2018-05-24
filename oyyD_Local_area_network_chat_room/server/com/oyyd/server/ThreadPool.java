package com.oyyd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Queue;

import com.oyyd.chatroom.common.SimpleSocket;

/**
* Title: ThreadPool
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月24日
* 线程池 (好像这个规范扫描不太认可....
*/
public class ThreadPool {
	static public Thread getReceiveThread(Queue<String> strtaskqueue, int receiveport){
		Thread thread = new Thread() {

			@Override
			synchronized public void run() {
				try {
					ServerSocket svrsocket = new ServerSocket(receiveport);
					while(true) {
						SimpleSocket spsocket = new SimpleSocket(svrsocket.accept());
						String line = spsocket.readLine();
						strtaskqueue.add(line);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		};
		return thread;
	}

	static public Thread getParseThread(Queue<String> strtaskqueue, Queue<Task> realtaskqueue){
		Thread parsethread = new Thread() {
			@Override 
			synchronized public void run() {
				while(true){
					String popstr = strtaskqueue.poll();
					if(popstr == null) {continue;}

					Task task = Task.parseTask(popstr);
					realtaskqueue.add(task);
					
				}

			}
		};
		return parsethread;
	}

	static public Thread getExecThread(Queue<Task> realtaskqueue){
		Thread execthread = new Thread() {
			@Override 
			synchronized public void run() {
				while(true) {
					Task task = realtaskqueue.poll();
					if(task == null) {continue; }
					task.exec();
					
				}
			}
		};
		return execthread;
	}
}
