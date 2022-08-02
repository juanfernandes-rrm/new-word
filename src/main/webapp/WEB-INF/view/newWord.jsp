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
	<h2>Anote as palavras e expressões que você tem dúvida!</h2>
	<p>${user.username}</p>
	<a href="controller?action=Logout" >sign out</a>
	<form action="${controller}" method="POST">
		Word: <input type="text" name="word"/>
		Phrase: <input type="text" name="phrase"/>
		<input type="hidden" value="NewWord" name="action">
		<input type="submit" value="Add"/>
	</form>
	
	<ul>
	<c:forEach items="${listCorrections}" var="correction">
		<li> 
			${correction.word.content} - ${correction.word.phrase}
			<a href="controller?action=DeleteWord&id=${correction.id}">delete</a>
			<a href="controller?action=EditWordForm&id=${correction.id}">edit</a>
		</li>
	</c:forEach>
	</ul>
</body>
</html>