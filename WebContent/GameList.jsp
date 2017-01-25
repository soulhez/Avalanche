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
				+ "<tr><button class=\"button white\" onclick=\"Edit(" + id
				+ ");\">Edit this Game</tr></td></table></div>";
		popUp.style.visibility = "visible";
	}
</script>
<title>Avalanche Game List Page</title>
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
				<li class="active"><a href="<c:url value='/toList'/>">Game
						List</a></li>
				<li><a>Edit Game</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="popupcontent" class="popupcontent"></div>

	<div align="center">
		<table class="my_table_list">
			<tr>
				<td align="center"><h1 class="homeHeadLine">Game List</h1></td>
			</tr>
			<c:forEach var="game" items="${AllGameList }">
				<tr align="left">
					<td class="big_text"><a
						href="javascript:onclick=toGame('${game.getId()}','${game.getGamename()}','${game.getGameinfo()}',
						'${game.getGamelink()}','${game.getGameimg()}')"><img
							src="${game.getGameimg()}" style="width: 200px;" alt="Image"></a></td>
					<td align="center" class="big_text" style="width: 300px;"><c:out
							value="${game.getGamename() }"></c:out></td>
				</tr>
				<p></p>
			</c:forEach>
		</table>
	</div>

	<br>
	<br>
	<br>
	<div class="my_footer">
		<p class="my_footer_text">Copyright &copy 2016 By Tianqi Zheng,
			Allrights Reserved.</p>
	</div>
</body>
</html>