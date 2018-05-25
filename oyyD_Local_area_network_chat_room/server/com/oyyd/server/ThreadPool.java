package com.oyyd.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;
import java.util.Set;

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
	
	
	/**
	 * 一直从socket池，接收数据，
	 * @param strtaskqueue
	 * @param receiveport
	 * @return
	 */
	static public Thread getReceiveThread(Queue<Task.NeedParse> needparsetaskqueue, Set<Socket> sockets){
		Thread thread = new Thread() {

			@Override
			synchronized public void run() {
				try {
					while(true) {
						for(Socket socket : sockets) {
							SimpleSocket spsocket = new SimpleSocket(socket);
							String line = spsocket.simpleReadLine();
							if(line == null) continue;
							needparsetaskqueue.add(new Task.NeedParse(line, socket));
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
		};
		return thread;
	}
	

	static public Thread getAcceptThread(Set<Socket> sockets, int accpetport) {
		Thread thread = new Thread() {
			
			@Override 
			synchronized public void run() {
				ServerSocket svrsocket;
				try {
						svrsocket = new ServerSocket(accpetport);
						while(true) {
							Socket socketadd = svrsocket.accept();
							sockets.add(socketadd);
						}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return thread;
	}

	static public Thread getParseThread(Queue<Task.NeedParse> needparsetaskqueue, Queue<Task> parsedtaskqueue){
		Thread parsethread = new Thread() {
			@Override 
			synchronized public void run() {
				while(true){
					Task.NeedParse pop = needparsetaskqueue.poll();
					if(pop == null) {continue;}

					Task task = Task.parseTask(pop);
					parsedtaskqueue.add(task);
					
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
