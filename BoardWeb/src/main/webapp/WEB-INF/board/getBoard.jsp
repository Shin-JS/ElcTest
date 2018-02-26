<%@page import="com.springbook.biz.board.impl.BoardDAO"%>
<%@page import="com.springbook.biz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%
	String seq = request.getParameter("seq");
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq)); //순번입력
	BoardDAO dao = new BoardDAO();
	vo = dao.getBoard(vo.getSeq()); //객체저장
%> --%>
<%-- <%
	BoardVO vo = (BoardVO)session.getAttribute("board");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.view.mainTitle"/></title>
<script>
	function myFunction(){
		alert(document.forms[0].uploadFile.value);
	}	
</script>
</head>
<body>
	<a href="logout.do"><spring:message code="message.user.link.logout"/></a>
	<hr>
	<form action="updateBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="seq" value="${board.seq}">
		<table border="1">
			<tr><td><spring:message code="message.board.view.title.title"/></td><td><input type="text" name="title" value="${board.title }"></td></tr>
			<tr><td><spring:message code="message.board.view.title.writer"/></td><td><input type="text" name="writer" value="${board.writer }"></td></tr>
			<tr><td><spring:message code="message.board.view.title.content"/></td><td><textarea name="content" cols="40" rows="10">${board.content }</textarea><br><img src="${board.files}"></td></tr>
			<tr><td><spring:message code="message.board.insert.table.head.upload"/></td><td><input type="file" name="uploadFile" value="${board.files}" onchange="myFunction()"><span id="p1"><a href="${board.files}">${board.files}</a></span></td></tr>
			<!-- link 태그는 미디어인 경우 실행되고, 일반 파일의 경우 다운로드됨 -->
			<tr><td><spring:message code="message.board.view.title.regDate"/></td><td>${board.regDate }</td></tr>
			<tr><td><spring:message code="message.board.view.title.cnt"/></td><td>${board.cnt }</td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="<spring:message code="message.board.view.viewBtn"/>"></td></tr>
		</table>
	</form>
	<hr>
	<a href="insertBoard.do"><spring:message code="message.board.view.link.insertBoard"/></a>&nbsp;&nbsp;&nbsp;
	<a href="deleteBoard.do?seq=${board.seq }"><spring:message code="message.board.view.link.deleteBoard"/></a>&nbsp;&nbsp;&nbsp;
	<a href="getBoardList.do"><spring:message code="message.board.view.link.getBoardList"/></a>
</body>
</html>