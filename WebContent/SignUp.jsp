<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<link href="<c:url value='css/Global.css'/>" rel="stylesheet"
	type="text/css">
<link href="<c:url value='css/Button.css'/>" rel="stylesheet"
	type="text/css">
<script type="text/javascript" src="<c:url value='js/Global.js'/>"></script>
<title>Sign Up</title>
</head>
<body>
	<div class="signin_box">
		<div align="center">
			<h1 class="subHeadLine">Become an Avalanche User</h1>
		</div>
		<table align="center">
			<tr>
				<td width="100px" class="info_text">User Name</td>
				<td><input type="text" id="username" name="username" /></td>
			</tr>
			<tr>
				<td width="100px" class="info_text">Password</td>
				<td><input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td width="150px" class="info_text">Confirm Password</td>
				<td><input type="password" id="passwordconfirm" name="password" />
					<span id="passdiff"></span></td>
			</tr>
			<tr>
				<td width="100px" class="info_text">Email</td>
				<td><input type="text" id="email" name="password" /></td>
			</tr>
		</table>
		<br>
		<div align="center">
			<table>
				<tr>
					<td><input id="confirm" class="button white" type="button"
						value="Sign Up" onclick="SignUp()" /></td>
					<td class="text">Already has an account?<a class="text"
						href="<c:url value='/Login'/>"> Sign In</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div id="popupcontent" class="popupcontent"></div>
	
	<div id="footer"
		style="position: fixed; left: 0; bottom: 0; width: 100%; height: 40px; overflow: hidden;">
		<p class="footer_text">Copyright &copy 2016 By Tianqi Zheng,
			Allrights Reserved.</p>
	</div>
</body>
</html>