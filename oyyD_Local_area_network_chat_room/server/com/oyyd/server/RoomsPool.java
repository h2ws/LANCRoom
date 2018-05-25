package com.oyyd.server;

import java.util.Map;
import java.util.Set;

import com.oyyd.dao.RoomsDao;
import com.oyyd.dao.UsersDao;

/**
* Title: RoomsPool
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月25日
* 房间池
* 房间到此房间内的用户集合
* 
* 待加入：
* 1.新增房间
* 2.删除房间
* 3.加入房间
* 4.退出房间
*/
public class RoomsPool {
	private Map<RoomsDao.Entry, Set<UsersDao.Entry>> roommap;
	
	/**
	 * 获取房间内的所有用户集合
	 * @param room
	 * @return
	 */
	public Set<UsersDao.Entry> getA(RoomsDao.Entry room){
		return null;
	}
	
	/**
	 * 获取用户所在的房间
	 * @param user
	 * @return
	 */
	public RoomsDao.Entry getB(UsersDao.Entry user){
		return null;
	}
}
