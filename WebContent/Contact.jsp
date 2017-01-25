<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link href="<c:url value='css/Global.css'/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value='css/Button.css'/>" rel="stylesheet"
	type="text/css">
<title>Game List</title>
</head>
<body>
	<div class="headline">
		<h1 class="headline">Welcome to Avalanche!</h1>
	</div>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/UserHome'/>">Avalanche</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/UserHome'/>">Home</a></li>
				<li><a href="<c:url value='/UserGames'/>">Games</a></li>
				<li class="active"><a href="<c:url value='/Contact'/>">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/UserAccount'/>"> My Account</a></li>
				<li><a href="<c:url value='/logout'/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div class="contact">
		<h1 class="subHeadLine">Avalanche Project</h1>
		<p class="normal_text">Builder: Tianqi Zheng</p>
		<p class="normal_text">E-mail: zhengtianqi94@gmail.com</p>
		<p class="normal_text">
			<a class="text"
				href="https://www.linkedin.com/in/tianqi-zheng-6851b6101">Add
				me to your LinkedIn contacts</a>
		</p>
	</div>

	<div class="my_footer">
		<p class="my_footer_text"">Copyright &copy 2016 By Tianqi Zheng,
			Allrights Reserved.</p>
	</div>
</body>
</html>