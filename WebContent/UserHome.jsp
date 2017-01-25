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
<script type="text/javascript" src="<c:url value='js/Global.js'/>"></script>
<script type="text/javascript">
	function toGame(id, name, info, link, img, w, h) {
		var popUp = document.getElementById("popupcontent");
		var id = id;
		var info = info;
		var name = name;
		var link = link;
		var img = img;
		popUp.style.top = "15%";
		popUp.style.left = "50%";
		popUp.style.width = "800px";
		popUp.innerHTML = "<div style=\"height:250px; overflow:auto;\">"
				+ "<h1 class=\"headline\">"
				+ name
				+ "</h1><table><tr><td class=\"text\">"
				+ "<img src=\"<c:url value='"+img+"'/>\" style=\"width: 200px;\" alt=\"Image\">"
				+ "</td><td class=\"info_text\" style=\"width:350px; padding:25px;\">"
				+ info
				+ "</td><td class=\"info_text\" style=\"width:50px; padding:25px;\">"
				+ "<a class=\"text\" href=\""+link+"\" target=\"_blank\">"
				+ "Game HomeSite"
				+ "</a>"
				+ "</td></tr></table><br>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Back</tr>"
				+ "<tr><button class=\"button white\" onclick=\"addToFavorites("
				+ id + ");\">Add to Favorites</tr></td></table></div>";
		popUp.style.visibility = "visible";
	}
</script>
<title>Avalanche User Home Page</title>
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
				<li class="active"><a href="<c:url value='/UserHome'/>">Home</a></li>
				<li><a href="<c:url value='/UserGames'/>">Games</a></li>
				<li><a href="<c:url value='/Contact'/>">Contact</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/UserAccount'/>"> My Account</a></li>
				<li><a href="<c:url value='/logout'/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="popupcontent" class="popupcontent"></div>

	<div class="container">
		<div>
			<h1 class="homeHeadLine">Avalanche Featured Games</h1>
		</div>
		<div id="popupcontent" class="popupcontent"></div>
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">${Gamelist[0].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[0].getId()}','${Gamelist[0].getGamename()}','${Gamelist[0].getGameinfo()}',
						'${Gamelist[0].getGamelink()}','${Gamelist[0].getGameimg()}')">
							<img src="${Gamelist[0].getGameimg()}" class="img-responsive"
							style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[0].getGameinfo()}</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-danger">
					<div class="panel-heading">${Gamelist[1].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[1].getId()}','${Gamelist[1].getGamename()}','${Gamelist[1].getGameinfo()}',
						'${Gamelist[1].getGamelink()}','${Gamelist[1].getGameimg()}')">
							<img src="<c:url value='${Gamelist[1].getGameimg()}'/>"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[1].getGameinfo()}</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-success">
					<div class="panel-heading">${Gamelist[2].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[2].getId()}','${Gamelist[2].getGamename()}','${Gamelist[2].getGameinfo()}',
						'${Gamelist[2].getGamelink()}','${Gamelist[2].getGameimg()}')">
							<img src="<c:url value='${Gamelist[2].getGameimg()}'/>"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[2].getGameinfo()}</div>
				</div>
			</div>
		</div>
	</div>
	<br>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">${Gamelist[3].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[3].getId()}','${Gamelist[3].getGamename()}','${Gamelist[3].getGameinfo()}',
						'${Gamelist[3].getGamelink()}','${Gamelist[3].getGameimg()}')">
							<img src="<c:url value='${Gamelist[3].getGameimg()}'/>"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[3].getGameinfo()}</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">${Gamelist[4].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[4].getId()}','${Gamelist[1].getGamename()}','${Gamelist[4].getGameinfo()}',
						'${Gamelist[4].getGamelink()}','${Gamelist[4].getGameimg()}')">
							<img src="<c:url value='${Gamelist[4].getGameimg()}'/>"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[4].getGameinfo()}</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading">${Gamelist[5].getGamename()}</div>
					<div class="panel-body">
						<a
							href="javascript:onclick=toGame('${Gamelist[5].getId()}','${Gamelist[5].getGamename()}','${Gamelist[5].getGameinfo()}',
						'${Gamelist[5].getGamelink()}','${Gamelist[5].getGameimg()}')">
							<img src="<c:url value='${Gamelist[5].getGameimg()}'/>"
							class="img-responsive" style="width: 100%" alt="Image">
						</a>
					</div>
					<div class="panel-footer">${Gamelist[5].getGameinfo()}</div>
				</div>
			</div>
		</div>
		<br> <br> <br>
		<div class="my_footer">
			<p class="my_footer_text"">Copyright &copy 2016 By Tianqi Zheng,
				Allrights Reserved.</p>
		</div>
	</div>
</body>
</html>