<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="message.user.login.title"/></title>
</head>
<body>
	<h1><spring:message code="message.user.login.title"/></h1>
	<a href="login.do?lang=en">
		<spring:message code="message.user.language.en"/>
	</a>&nbsp;&nbsp;&nbsp;
	<a href="login.do?lang=ko">
		<spring:message code="message.user.language.ko"/>
	</a>
	<form action="login.do" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr><td><spring:message code="message.user.login.id"/></td><td><input type="text" name="id" value="${u.id}"></td></tr><br>
			<tr><td><spring:message code="message.user.login.password"/></td><td><input type="password" name="password" value="${u.password}"></td></tr><br>
			<tr><td colspan="2" align="center"><input type="submit" value="<spring:message code="message.user.login.loginBtn"/>"></td><br>
		</table>
	</form>
</body>
</html>