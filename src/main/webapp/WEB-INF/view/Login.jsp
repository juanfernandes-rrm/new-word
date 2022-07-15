<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controller"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="${controller}" method="POST">
		Login: <input type="text" name="username"/>
		Password: <input type="text" name="password"/>
		<input type="hidden" value="Login" name="action">
		<input type="submit" value="Sign in"/>
	</form>
</body>
</html>