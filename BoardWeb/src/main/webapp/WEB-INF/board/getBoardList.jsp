<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	String id = (String)session.getAttribute("id");
	if(id==null||"".equals(id)){
		response.sendRedirect("login.jsp");
	}
	//1.Board 정보 출력
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	List<BoardVO> list = dao.getBoardList(vo);
%> --%>
<%
	List<BoardVO> list = (List)session.getAttribute("boardList");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<h1>BoardList</h1>
	<h3><a href="logout.do">로그아웃</a></h3>
	<table border="1">
		<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>
		<c:forEach items="${boardList }" var="list">
			<tr>
			<td>${list.seq}</td>
			<td><a href="getBoard.do?seq=${list.seq }">${list.title}</a></td>
			<td><a href="getBoard.do?seq=${list.seq }">${list.writer }</a></td>
			<td>${list.regDate }</td>
			<td>${list.cnt }</td>
		</tr>
		</c:forEach>
		<%-- <%
			for(int i=0;i<list.size();i++){
		%>
		<tr>
			<td><%=list.get(i).getSeq() %></td>
			<td><a href="getBoard.jsp?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>
			<td><a href="getBoard.do?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>
			<td><%=list.get(i).getWriter() %></td>
			<td><%=list.get(i).getRegDate() %></td>
			<td><%=list.get(i).getCnt() %></td>
		</tr>
		<%				
			}
		%> --%>
	</table>
	<br>
	<a href="insertBoard.do">새글 쓰기</a>
</body>
</html>