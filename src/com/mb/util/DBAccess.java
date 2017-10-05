package com.mb.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	 public  SqlSession getSqlSession() throws IOException{
	        //ͨ�������ļ���ȡ���ݿ�������Ϣ
	        Reader reader = Resources.getResourceAsReader("com/mb/config/Configuration.xml");
	        //ͨ��������Ϣ����һ��SqlSessionFactory
	        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	        //ͨ��sqlSessionFactory��һ�����ݿ�Ự
	        SqlSession sqlSession = sqlSessionFactory.openSession();
	        return sqlSession;
	    }
}
