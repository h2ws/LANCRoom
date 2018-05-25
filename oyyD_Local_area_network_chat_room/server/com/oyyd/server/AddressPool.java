package com.oyyd.server;

import java.net.Socket;
import java.util.Map;
import java.util.Set;

import com.oyyd.dao.UsersDao;

/**
* Title: AddressPool
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月25日
* 地址池 
* 用于维护登录用户与 Socket 的关系
* 
*
* 待加入：(勉强完成..
* 1.通过用户查地址
* 2.查询是否登录
* 3.用户集 到 地址集 方法
* 4.地址集 到 用户集 方法
* 
* 
*/
public class AddressPool {
	
	/**
	 * 登录的用户池
	 * 登录的用户映射，用户到所对的Socket
	 */
	private Map<UsersDao.Entry , Socket> loginUserMap;

	/**
	 * 向表中注册一个用户,可能注册失败
	 * @param username
	 * @param pwd
	 */
	public boolean regUser(String username, String pwd) {
		UsersDao.register(username, pwd);
		return true;
	}
	
	public UsersDao.Entry loginUser(String username, String pwd) {
		//向用户表中查询
		return null;
	}
	
	/**
	 * 通过socket判断是否连接
	 * @param socket
	 * @return
	 */
	public boolean isLogin(Socket socket){
		return true;
	}
	
	
	/**
	 * 通过本地映射查询
	 * 获取用户对应的Socket
	 * @param user
	 * @return
	 */
	public Socket toSocket(UsersDao.Entry user) {
		return null;
	}
	
	/**
	 * 获取用户集对应的Socket集
	 * @param users
	 * @return
	 */
	public Set<Socket> toSocketSet(Set<UsersDao.Entry> users) {
		return null;
	}
	
	
}
