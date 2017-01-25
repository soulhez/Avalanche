function popup(status) {
	var popUp = document.getElementById("popupcontent");
	popUp.style.top = "15%";
	popUp.style.left = "50%";
	popUp.style.width = "800px";
	if (status == "success") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">This game has been successfully added to your favorites!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "error") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">Operating database error!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "alreadyhasgame") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">You already have this game in favorites!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "servererror") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">Server busy, try later!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "removesuccess") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">This game has been successfully removed from your favorites!</p></div>";
		popUp.style.visibility = "visible";
	} else if (status == "nouser") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">No such user!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "passerror") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">You have entered wrong password!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "hasuser") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">User already exists, please try login!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "addsuccess") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">This game has been successfully added to Avalanche!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "hasgame") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">This game already exsits in Avalanche!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "emptyfield") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">You must fill all the blanks, administrator!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	} else if (status == "URLempty") {
		popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">You must enter a valid URL for game photo, administrator!</p></div>"
				+ "<div align=\"center\"><table><td><tr><button class=\"button white\" onclick=\"hidePopup();\">Close</tr>";
		popUp.style.visibility = "visible";
	}
}

function gamepopup(name) {
	var popUp = document.getElementById("popupcontent");
	popUp.style.top = "15%";
	popUp.style.left = "50%";
	popUp.style.width = "800px";
	popUp.style.height = "100px";
	popUp.innerHTML = "<div align=\"center\"><p class=\"normal_text\">" + name
			+ " has been successfully updated!" + "</p></div>";
	popUp.style.visibility = "visible";

}

function Confirm() {
	if (document.getElementById("gamename").value == ''
			|| document.getElementById("gamename").value == "") {
		// alert("Please specify the Game Name!");
		popup("emptyfield");
	} else if (document.getElementById("gamesite").value == ''
			|| document.getElementById("gamesite").value == "") {
		alert("Please specify the Game Site!");
		popup("emptyfield");
	} else if (document.getElementById("gameinfo").value == ''
			|| document.getElementById("gameinfo").value == "") {
		alert("Please specify the Game Information!");
		popup("emptyfield");
	} else if (document.getElementById("gameimg").value == ''
			|| document.getElementById("gameimg").value == "") {
		alert("Please specify the photo URL!");
		popup("emptyfield");
	} else {
		var picpath = document.getElementById("gameimg").value;
		var name = document.getElementById("gamename").value;
		var site = document.getElementById("gamesite").value;
		var info = document.getElementById("gameinfo").value;
		var gameid = document.getElementById("gameid").value;

		$.ajax({
			url : encodeURI(encodeURI('/CSYE6220FinalProject/updateGames?path='
					+ picpath + '&name=' + name + '&site=' + site + '&info='
					+ info + '&id=' + gameid)),
			type : 'get',
			cache : false,
			success : function(data) {
				if (data == "success") {
					// alert(name + " has been successfully updated!");
					// hidePopup();
					gamepopup(name);
					window.setTimeout("hidePopup()", 3000);
					setTimeout(function() {
						window.location.reload();
					}, 2000);
					// window.location.reload();
				} else if (data == "error") {
					// alert("Error operating database!");
					// hidePopup();
					popup("error");
					// window.setTimeout("hidePopup()", 3000);
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
	document.getElementById("gameimg").value = '';
	document.getElementById("gamename").value = '';
	document.getElementById("gamesite").value = '';
	document.getElementById("gameinfo").value = '';
}

function hidePopup() {
	var popUp = document.getElementById("popupcontent");
	popUp.style.visibility = "hidden";
}

function addToFavorites(id) {
	// console.log("addToFavorites called");
	$
			.ajax({
				url : encodeURI(encodeURI('/CSYE6220FinalProject/addFavorite?ID='
						+ id)),
				type : 'get',
				cache : false,
				success : function(data) {
					if (data == "success") {
						// alert("This game has been successfully added to your
						// favorites!");
						hidePopup();
						popup("success");
						// window.setTimeout("hidePopup()", 2000);
					} else if (data == "alreadyhasgame") {
						// alert("You already have this game in favorites!");
						hidePopup();
						popup("alreadyhasgame");
						// window.setTimeout("hidePopup()", 2000);
					}
				},
				error : function() {
					popup("servererror");
					window.setTimeout("hidePopup()", 2000);
				}
			});
}

function Edit(id) {
	window.location.href = "/CSYE6220FinalProject/toEdit?ID=" + id;
}

function removefromFavorites(id) {
	// console.log("addToFavorites called");
	$.ajax({
		url : encodeURI(encodeURI('/CSYE6220FinalProject/removeFavorite?ID='
				+ id)),
		type : 'get',
		cache : false,
		success : function(data) {
			if (data == "success") {
				// alert("This game has been successfully removed from your
				// favorites!");
				hidePopup();
				popup("removesuccess");
				window.setTimeout("hidePopup()", 3000);
				setTimeout(function() {
					window.location.reload();
				}, 2000);
				// window.location.reload();
			}
		},
		error : function() {
			popup("servererror");
			window.setTimeout("hidePopup()", 2000);
		}
	});
}

function CheckUser() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	$.ajax({
		url : encodeURI(encodeURI('/CSYE6220FinalProject/login?Username='
				+ username + '&Password=' + password)),
		type : 'get',
		cache : false,
		success : function(data) {
			if (data == "user") {
				window.location.href = "/CSYE6220FinalProject/UserHome";
			} else if (data == "nouser") {
				// alert("No such user!");
				// hidePopup();
				popup("nouser");
				// window.setTimeout("hidePopup()", 2000);
			} else if (data == "passerror") {
				popup("passerror");
				// window.setTimeout("hidePopup()", 2000);
			} else if (data == "admin") {
				window.location.href = "/CSYE6220FinalProject/AdminHome";
			}
		},
		error : function() {
			popup("servererror");
			window.setTimeout("hidePopup()", 2000);
		}
	});
}

function toSignUp() {
	window.location.href = "/CSYE6220FinalProject/SignUp"
}

$(document).ready(function() {
	$(document).keyup(function(evnet) {
		if (evnet.keyCode == '13') {
			document.getElementById("confirm").click();
		}
	});
});

function SignUp() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var passwordconfirm = document.getElementById("passwordconfirm").value;
	var email = document.getElementById("email").value;
	$
			.ajax({
				url : encodeURI(encodeURI('/CSYE6220FinalProject/signup?Username='
						+ username
						+ '&Password='
						+ password
						+ '&PasswordConfirm='
						+ passwordconfirm
						+ '&Email='
						+ email)),
				type : 'get',
				cache : false,
				success : function(data) {
					if (data == "success") {
						window.location.href = "/CSYE6220FinalProject/Login";
					} else if (data == "hasuser") {
						// hidePopup();
						popup("hasuser");
						// window.setTimeout("hidePopup()", 2000);
						// alert("User already exists, please try login!");
					} else if (data == "passdiff") {
						document.getElementById("passdiff").innerHTML = "<font color='red'>Password does not match</font>";
					}
				},
				error : function() {
					popup("servererror");
					window.setTimeout("hidePopup()", 2000);
				}
			});
}
