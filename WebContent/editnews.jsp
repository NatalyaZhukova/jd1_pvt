<%@page import="tables.Category"%>
<%@page import="tables.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="categories" class="tables.Category" scope="session"></jsp:useBean>
<jsp:useBean id="news" class="tables.News" scope="session"></jsp:useBean>
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
		<input type="hidden" name="operation" value="editwritenews">
		<input type="hidden" name="id" value="${news.id}">
		Заголовок:<input type="text" name="title" value="${news.title }"><br>
		Дата: <input type="text" name="release_date" value="${news.release_date}"><br>
		Категория: 
		<select name="category">
	    <c:forEach var="category" items="${categories}">
	    <option value='${category.id}'>${category.name}</option>
	    </c:forEach>
		</select> <br>
		Автор: <input type="text" name="author" value="${news.author}"><br>
		Аннотация: <textarea name="annotation" >${news.annotation }</textarea> <br>
		Полный текст: <textarea name="fulltext">${news.full_text}</textarea>
		<input type="submit" value="Сохранить новость">
		</form>
		</div>
	</body>
</html>