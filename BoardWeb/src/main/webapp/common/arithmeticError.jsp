<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body bgcolor="#ffffff" text="#000000">
<!-- 타이틀 시작 -->
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr><td align="center" bgcolor="orange"><b>기본 에러 화면</b></td></tr>
</table>
<br>
<table width="100%" border="1" cellspacing="0" cellpadding="0">
	<tr><td align="center"><br><br><br><br><br>Message: ${exception.message}</td></tr>
</table>
</body>
</html>