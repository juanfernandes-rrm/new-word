<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/controller" var="entradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${entradaServlet}" method="POST">
		Palavra: <input type=text name="palavra"/>
		<input type="hidden" value="NovaPalavra" name="action">
		<input type="submit" value="Cadastrar"/>
	</form>
	
	<ul>
	<c:forEach items="${listaPalavras}" var="palavra">
		<li> 
			${palavra.content}
		</li>
	</c:forEach>
	</ul>
</body>
</html>