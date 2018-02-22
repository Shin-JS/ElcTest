<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 사용자 정보
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2. DB처리
	UserVO user = new UserVO();
	user.setId(id);
	user.setPassword(password);
	UserDAO dao = new UserDAO();
	UserVO user2 = dao.getUser(user);
	
	//3.화면이동
	if(user2!=null){
		session.setAttribute("id",user.getId());
		response.sendRedirect("getBoardList.jsp");
	}else{
		response.sendRedirect("login.jsp");
	}
%>