<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <% String error=(String)request.getAttribute("error"); %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	
	<body>
		<div class="login">
			<form action="Login" method="POST">
			<label>Имя пользователя:</label><br>
			<input type="text" name="username"> <br>
			<label>Пароль:</label><br>
			<input type="password" name="password"> <br>
			<input type="submit" value="Войти"> <br>
			
			<span class="error">
			<c:if test = "${error!=null}" >
			<c:out value="${error}" />
			</c:if>
			</span>
			
			</form>
		</div>
	</body>
</html>