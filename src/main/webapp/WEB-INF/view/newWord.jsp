<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="controller"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Word</title>
</head>
<body>
	<h1>New Word</h1>
	<p>Anote as palavras e expressões que você tem dúvida!</p>
	<form action="${controller}" method="POST">
		Word: <input type=text name="word"/>
		<input type="hidden" value="NewWord" name="action">
		<input type="submit" value="Add"/>
	</form>
	
	<ul>
	<c:forEach items="${listWords}" var="word">
		<li> 
			${word.content}
			<a href="controller?action=DeleteWord&id=${word.id}">delete</a>
			<a href="controller?action=EditWordForm&id=${word.id}">edit</a>
		</li>
	</c:forEach>
	</ul>
</body>
</html>