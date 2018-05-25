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
* 待加入：(逻辑说明完成
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
	
	/**
	 * 房间表新增房间, 并立即更新本地房间映射
	 */
	public void createRoom() {
		//往房间表中插入
		//更新本地映射
	}
	
	/**
	 * 房间表删除房间, 并立即更新本地房间映射
	 */
	public void deleteRoom() {
		//从房间表中删除
		//同步更新
	}
	
	/**
	 * 加入房间 
	 * @return 提示字符串, 为null则成功 
	 */
	public String joinRoom(UsersDao.Entry user, RoomsDao.Entry room, String pwd) {
		//可能需要密码
		//可能密码错误
		//以提示字符串返回给调用者, 若成功返回null
		//仅更新映射
		return null;
	}
	
	/**
	 * 退出房间
	 * @param user
	 * @param room
	 */
	public void outRoom(UsersDao.Entry user, RoomsDao.Entry room) {
		//仅更新映射
	}
	
	/**
	 * 设置房间
	 * @param room
	 */
	public void setRoom(RoomsDao.Entry room) {
		//将room同步到房间表中
	}
}
