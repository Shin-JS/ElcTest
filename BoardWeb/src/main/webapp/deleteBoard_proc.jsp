<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String seq = request.getParameter("seq");
	int result = -1;
	BoardDAO dao = new BoardDAO();
	result = dao.deleteBoard(Integer.parseInt(seq));
	if(result>0){
		response.sendRedirect("getBoardList.jsp");
	}else{
		out.print("<script>");
		out.print("alert('삭제 실패!');");
		out.print("history.back();");
		out.print("</script>");
	}
%>
