<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="<%=basePath%>/resources/list.css" type="text/css" />

  </head>
  
  <body>
  <form action="List.action" method="post">
	  <div class='search' name="提交">
	  	<span>介绍:</span><input type="text" name="command"><span>描述：</span><input type="text" name="description">
	  <input type="submit" value="submit"></button>
	  </div>
	    <table class='list_table'>
	    	<tr>
	    		<th>选择</th>
	    		<th>序号</th>	
	    		<th>指令名称</th>
	    		<th>描述</th>
	    		<th>操作</th>
	    	</tr>
	    	<c:forEach items = "${messageList}" var ="message" varStatus="status">
	    		<tr <c:if test="${status.index%2!=0}">style='background-color;#ECF6EE;'</c:if>>
		    		<td><input type="checkbox"></td>
		    		<td>${status.index+1 }</td>
		    		<td>${message.command}</td>
		    		<td>${message.description}</td>
		    		<td>
		    			<a href="#">修改</a>&nbsp&nbsp&nbsp
		    			<a href="${basePath }DeleteOneServlet.action?id=${message.id}">删除</a>
		    		</td>
		    	</tr>
	    	</c:forEach>
	    </table>
	    
    </form>
  </body>
</html>
