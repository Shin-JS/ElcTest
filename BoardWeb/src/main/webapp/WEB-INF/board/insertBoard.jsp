<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.board.insert.mainTitle"/></title>
</head>
<body>
	<h1><spring:message code="message.board.insert.mainTitle"/></h1>
	<a href="logout_proc.jsp"><spring:message code="message.user.link.logout"/></a>
	<hr>
	<form action="insertBoardProc.do" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr><td><spring:message code="message.board.insert.table.head.title"/></td><td><input type="text" name="title"></td></tr>
			<tr><td><spring:message code="message.board.insert.table.head.writer"/></td><td><input type="text" name="writer" value="${userName}" readonly></td></tr>
			<tr><td><spring:message code="message.board.insert.table.head.content"/></td><td><textarea name="content" cols="40" rows="10"></textarea></td></tr>
			<tr><td colspan="2"><input type="file" name="uploadFile"></td></tr>
			<tr><td colspan="2" align="center"><input type="submit" value="<spring:message code="message.board.insert.insertBtn"/>"></td></tr>
		</table>
	</form>
	<hr>
	<a href="getBoardList.do"><spring:message code="message.board.insert.link.getBoardList"/></a>&nbsp;&nbsp;&nbsp;
</body>
</html>