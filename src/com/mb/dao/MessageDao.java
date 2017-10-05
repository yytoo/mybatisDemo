package com.mb.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;


import org.apache.log4j.Logger;

import com.mb.bean.Message;
import com.mb.util.DBAccess;

/**
 * @author Administrator
 *
 */
public class MessageDao {
	public List<Message> queryMessageList(String command,String description){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			
			//通过sqlSession执行sql语句
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();	
			}
		}
		return messageList;
	}

	/*
	 * 单条删除
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;	
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();	
			}
		}
		
	}
	
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;	
		try {
			sqlSession = dbAccess.getSqlSession();
			
			//通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();	
			}
		}
		
	}
	
/*	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
		Map<String,Message> messageMap = new HashMap<String,Message>();
		messageMap.put("key", new Message());
		Logger log;
		log.debug("adf");
		log.info(message);
		log.warm(message);
		log.error(message);
	}*/
	
}
