<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<%-- <%
	List<BoardVO> list = (List)session.getAttribute("boardList");
	
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.list.mainTitle"/></title>
</head>
<body>
	<h1><spring:message code="message.board.list.mainTitle"/></h1>
	<h3>${userName}<spring:message code="message.board.list.welcomeMsg"/><a href="logout.do">로그아웃</a></h3>
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td align="center"><select name="searchCondition">
					<c:forEach items="${conditionMap}" var="option">
						<option value="${option.value}">${option.key}</option>
					</c:forEach>
				</select><input type="text" name="searchKeyword"><input type="submit" value="<spring:message code="message.board.list.search.condition.btn"/>"></td>
			</tr>
		</table>
	</form>
	<!-- 검색 종료 -->
	<table border="1">
		<tr><th><spring:message code="message.board.list.title.seq"/></th><th><spring:message code="message.board.list.title.title"/></th><th><spring:message code="message.board.list.title.writer"/></th><th><spring:message code="message.board.list.title.regDate"/></th><th><spring:message code="message.board.list.title.cnt"/></th></tr>
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
	<a href="insertBoard.do"><spring:message code="message.board.list.link.insertBoard"/></a>
</body>
</html>