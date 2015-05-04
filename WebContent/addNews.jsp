<%@page import="tables.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="categories" class="tables.Category" scope="session"></jsp:useBean>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body class="admin">
		<div class="header">
		<h1>Добавление новостей</h1>
		</div>
		<div class="content">
		
		<form action="adminController" method="post">
		<input type="hidden" name="operation" value="addwritenews">
		<input type="hidden" name="id" value="<%= request.getAttribute("id") %>">
		Заголовок:<input type="text" name="title"><br>
		Дата: <input type="text" name="release_date"><br>
		Категория: 
		<select name="category">
	    <c:forEach var="category" items="${categories}">
	    <option value='${category.id}'>${category.name}</option>
	    </c:forEach>
		</select> <br>
		Автор: <input type="text" name="author"><br>
		Аннотация: <textarea name="annotation"></textarea> <br>
		Полный текст: <textarea name="fulltext"></textarea>
		<input type="submit" value="Добавить новость">
		</form>
		</div>
	</body>
</html>