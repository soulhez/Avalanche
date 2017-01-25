<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="<c:url value='js/Global.js'/>"></script>
<title>Edit Game</title>
</head>
<body>
	<div class="headline">
		<h1 class="headline">Welcome, Administrator!</h1>
	</div>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/AdminHome'/>">Avalanche</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/AdminHome'/>">Home</a></li>
				<li><a href="<c:url value='/toList'/>">Game List</a></li>
				<li class="active"><a>Edit Game</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div>
		<input id="gameid" type="hidden" value="${gametoedit.getId()}">
	</div>

	<div id="popupcontent" class="popupcontent"></div>

	<div class="game_box">
		<div align="center">
			<h1 class="subHeadLine">Edit Game</h1>
		</div>
		<div align="center">
			<table>
				<tr>
					<td width="100px" class="info_text">Game Name</td>
					<td><input type="text" id="gamename" name="gamename" size="45"
						style="width: 500px;" value="${gametoedit.getGamename()}" /><br></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Website</td>
					<td><input type="text" id="gamesite" name="gamesite" size="45"
						style="width: 500px;" value="${gametoedit.getGamelink()}" /><br></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Info</td>
					<td><textarea id="gameinfo" name="gameinfo"
							style="width: 500px; height: 80px;">${gametoedit.getGameinfo()}</textarea><br></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Photo</td>
					<td><input type="text" id="gameimg" name="gameimg" size="45"
						style="width: 500px;" value="${gametoedit.getGameimg()}" /><br></td>
				</tr>
			</table>
			<br>
		</div>
		<div align="center">
			<table>
				<tr>
					<td><input id="confirm" class="button white" type="button"
						value="Confirm Edit" onclick="Confirm()" /></td>
					<td><input class="button white" type="button" value="Cancel"
						onclick="Cancel()" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="my_footer">
		<p class="my_footer_text">Copyright &copy 2016 By Tianqi Zheng,
			Allrights Reserved.</p>
	</div>
</body>
</html>