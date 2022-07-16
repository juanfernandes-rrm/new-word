<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controller"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher ${userLogin.username}</title>
</head>
<body>
	<h1>Welcome ${userLogin.username}</h1>
	<a href="controller?action=Logout" >sign out</a>
</body>
</html>