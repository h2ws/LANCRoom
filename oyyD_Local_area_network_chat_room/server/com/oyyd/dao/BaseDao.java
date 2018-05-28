package com.oyyd.dao;

import java.util.Map;
import java.util.Set;

/**
* Title: BaseDao
* Description: 
* Version:1.0.0  
* @author 28468
* @date 2018年5月28日
* 执行 sql
* [增] [删] [改] [查]
*/
public class BaseDao {
	/**
	 * @param table
	 * @param content
	 * @param where
	 * @return
	 * 这个东西好像有点难实现
	 */
	public Set<Object> select(String table, String content, String where){
		return null;
	}

	public int insert(String table, String keys, String values){
		return 0;
	}
	
	public int delete(String table, String where){
		return 0;
	}
	
	public int update(String table, Map<String, String> map, String where){
		return 0;
	}
}
