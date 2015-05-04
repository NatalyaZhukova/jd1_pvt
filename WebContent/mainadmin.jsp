<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% List<String> dates = (List<String>)request.getAttribute("dates"); %>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body class="admin">
		<div class="header">
		<h1>Административная панель</h1>
		</div>
			<div class="menu">
		<h2>Разделы</h2>
		<ul>
		<%= request.getAttribute("menu") %>
		</ul>
		<form action="adminController" method="get">
		<select name="date">
		<c:forEach var="date" items="${dates}">
		<option value="${date}">${date}</option>
		</c:forEach>
	    
		</select>
		<input type="submit" value="Выбрать">
		</form>
		</div>
		<div class="content">
		<div class="news">
		<a href="adminController?operation=addnews">Добавить новость</a>
		<br>
		<%= request.getAttribute("news") %>
		</div>
		</div>
	</body>
</html>