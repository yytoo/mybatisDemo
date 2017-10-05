package com.mb.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mb.bean.Message;
import com.mb.dao.MessageDao;
import com.mysql.jdbc.SQLError;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		List<Message> list = new ArrayList<Message>();
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		MessageDao messageDao = new MessageDao();
		
		list = messageDao.queryMessageList(command, description);
		req.setAttribute("messageList", list);
		req.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(req, resp); //forward可以在跳转时带参数
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
