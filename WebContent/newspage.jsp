<%@page import="tables.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="newsList" class="tables.News" scope="session"></jsp:useBean>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="styles.css">
	</head>
	<body class="feed">
		<div class="header">
		<h1>Лента Новостей</h1>
		</div>
		<div class="menu">
		<h2>Разделы</h2>
		<ul>
		<%= request.getAttribute("menu") %>
		</ul>
		</div>
		<div class="content">
			<div class="news">
			<p class="title"><a href="NewsFeed?id=${news.id}">${news.title}</a></p>
			<span class ="date">${news.release_date}</span> |  
            <span class="author">${news.author}</span>  |
			<span class="category">${news.category }</span>
			<p class="full_text">${news.full_text}</p>
			</div>
		</div>
	</body>
</html>