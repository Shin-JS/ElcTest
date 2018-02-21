<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="login_proc.jsp" method="post">
		<table border="1" cellpadding="0" cellspacing="0">
			<tr><td>아이디</td><td><input type="text" name="id"></td></tr><br>
			<tr><td>비밀번호</td><td><input type="password" name="password"></td></tr><br>
			<tr><td colspan="2" align="center"><input type="submit" value="로그인"></td><br>
		</table>
	</form>
</body>
</html>