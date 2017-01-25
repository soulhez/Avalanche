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
	function AddGame() {
		if (!checkURL(document.getElementById("picpath").value)) {
			popup("URLempty");
		} else {
			var picpath = document.getElementById("picpath").value;
			var name = document.getElementById("gamename").value;
			var site = document.getElementById("gamelink").value;
			var info = document.getElementById("gameinfo").value;
			console.log(picpath);
			$
					.ajax({
						url : encodeURI(encodeURI('/CSYE6220FinalProject/addGames?path='
								+ picpath
								+ '&name='
								+ name
								+ '&site='
								+ site
								+ '&info=' + info)),
						type : 'get',
						cache : false,
						success : function(data) {
							if (data == "addsuccess") {
								//alert("This game has been successfully added to Avalanche!");
								popup("addsuccess");
								window.location.reload();
							} else if (data == "hasgame") {
								//alert("This game already exsits in Avalanche!");
								popup("hasgame");
							}
						},
						error : function() {
							popup("servererror");
							window.setTimeout("hidePopup()", 2000);
						}
					});
		}
	}

	function Cancel() {
		document.getElementById("picpath").value = '';
		document.getElementById("gamename").value = '';
		document.getElementById("gamelink").value = '';
		document.getElementById("gameinfo").value = '';
	}

	function checkURL(URL) {
		var str = URL;
		var Expression = /http(s)?:\/\/([\w-]+\.)+[\w-]+(\/[\w- .\/?%&=]*)?/;
		var objExp = new RegExp(Expression);
		if (objExp.test(str) == true) {
			return true;
		} else {
			return false;
		}
	}
</script>
<title>Avalanche Admin Home Page</title>
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
				<li class="active"><a href="<c:url value='/AdminHome'/>">Home</a></li>
				<li><a href="<c:url value='/toList'/>">Game List</a></li>
				<li><a>Edit Game</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<div id="popupcontent" class="popupcontent"></div>

	<div class="game_box">
		<div align="center">
			<h1 class="subHeadLine">New Game</h1>
		</div>
		<div align="center">
			<table>
				<tr>
					<td width="100px" class="info_text">Game Name</td>
					<td><input type="text" id="gamename" name="gamename" size="45"
						style="width: 500px;" /><br></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Website</td>
					<td><input type="text" id="gamelink" name="gamelink" size="45"
						style="width: 500px;" /></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Introduction</td>
					<td><textarea id="gameinfo" name="gameinfo"
							style="width: 500px; height: 80px;"></textarea></td>
				</tr>
			</table>
			<br>
			<table>
				<tr>
					<td width="100px" class="info_text">Game Photo</td>
					<td><input type="text" style="width: 500px;" id="picpath"></td>
				</tr>
			</table>
		</div>
		<br>
		<div align="center">
			<table>
				<tr>
					<td><input id="confirm" class="button white" type="button"
						value="Add to Games" onclick="AddGame()" /></td>
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