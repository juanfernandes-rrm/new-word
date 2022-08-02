<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controller"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Correction</title>
</head>
<body>
	<p>${correction.word.content}</p>
	<p>${correction.word.phrase}</p>
	<p>${correction.teacher.username}</p> - <p>${correction.comment}</p>
	<form action="${controller}" method="POST">
		Comment: <input type="text" name="comment" value="${correction.comment}"/>
		<input type="hidden" name="id" value="${correction.id}">
		<input type="hidden" name="action" value="CorrectionWord">
		<input type="submit" value="Add"/>
	</form>
</body>
</html>