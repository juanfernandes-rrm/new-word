<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controller"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Word</title>
</head>
<body>
	<form action="${controller}" method="POST">
		Word: <input type=text name="word" value="${word.content}"/>
		<input type="hidden" name="id" value="${word.id}">
		<input type="hidden" name="action" value="EditWord">
		<input type="submit" value="Edit"/>
	</form>
</body>
</html>