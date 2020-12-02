<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
* {
	box-sizing: border-box
}

body {
	font-family: "Lato", sans-serif;
}

/* Style the tab */
.tab {
	float: left;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
	width: 30%;
	height: 300px;
}

/* Style the buttons inside the tab */
.tab button {
	display: block;
	background-color: inherit;
	color: black;
	padding: 22px 16px;
	width: 100%;
	border: none;
	outline: none;
	text-align: left;
	cursor: pointer;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current "tab button" class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	float: left;
	padding: 0px 12px;
	border: 1px solid #ccc;
	width: 100%;
	border-left: none;
	height: 350px;
}

.button {
	border: none;
	color: white;
	padding: 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
}

.button4 {
	border-radius: 12px;
}
</style>

</head>
<body class="w3-theme-l5">
	<c:if test="${logged == null }">
		<c:redirect url="in.html"></c:redirect>
	</c:if>
	<!-- Top container -->
	<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
		<button
			class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
			onclick="w3_open();">
			<i class="fa fa-bars"></i>  Menu
		</button>
		<span class="w3-bar-item w3-right">Logo</span>
	</div>

	<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
		style="z-index: 3; width: 300px;" id="mySidebar">
		<br>
		<div class="w3-container w3-row">
			<div class="w3-col s4">
				<img src="/w3images/avatar2.png" class="w3-circle w3-margin-right"
					style="width: 46px">
			</div>
			<div class="w3-col s8 w3-bar">
				<span>Welcome, <strong>Mike</strong></span><br> <a href="#"
					class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
				<div class="w3-dropdown-content w3-card-4 w3-bar-block"
					style="width: 300px">
					<a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
				</div>

				<div class="w3-dropdown-hover w3-hide-small">
					<button class="w3-button w3-padding-large">
						<i class="fa fa-cog"></i>
					</button>
					<div class="w3-dropdown-content w3-card-4 w3-bar-block"
						style="width: 300px">
						<a href="#" class="w3-bar-item w3-button">Edit Profile</a> <a
							href="logout" class="w3-bar-item w3-button">Logout</a>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="w3-container">
			<h5>Dashboard</h5>
		</div>
		<div class="w3-bar-block">
			<a href="#"
				class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
				onclick="w3_close()" title="close menu"><i
				class="fa fa-remove fa-fw"></i>  Close Menu</a> <a href="#"
				class="w3-bar-item w3-button w3-padding w3-blue"><i
				class="fa fa-users fa-fw"></i>  Overview</a> <a href="schedule.jsp"
				class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-users fa-fw"></i>  View schedule </a> <a href="#"
				class="w3-bar-item w3-button"><i class="fa fa-user"></i> Make a
				report </a> <a href="#" class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-users fa-fw"></i>  Requests </a> <a href="#"
				class="w3-bar-item w3-button w3-padding"><i class="fa fa-bell"></i> Hours
				Worked</a> <a href="#" class="w3-bar-item w3-button w3-padding"><i
				class="fa fa-bell"></i> Notifications</a>
		</div>
	</nav>

	<!-- Overlay effect when opening sidebar on small screens -->
	<div class="w3-overlay w3-hide-large w3-animate-opacity"
		onclick="w3_close()" style="cursor: pointer" title="close side menu"
		id="myOverlay"></div>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

		<!-- Header -->
		<header class="w3-container" style="padding-top: 22px">
			<h5>
				<b><i class="fa fa-dashboard"></i> My Dashboard</b>
			</h5>
		</header>

		<div id="schedule" class="tabcontent">
			<h3>Weekly Schedule</h3>
			<p>These are the days you are scheduled to work this week.</p>
			<table class="w3-table w3-striped w3-white">
				<tr>
					<td><p>
							<b>MON</b>
						</p></td>
					<td>New record, over 90 views.</td>
					<td><i>10 Hours</i></td>
				</tr>
				<tr>
					<td><b>TUE</b></td>
					<td>Database error.</td>
					<td><i>8 Hours</i></td>
				</tr>
				<tr>
					<td><b>WED</b></td>
					<td>New record, over 40 users.</td>
					<td><i>11 Hours</i></td>
				</tr>
				<tr>
					<td><b>THU</b></td>
					<td>New comments.</td>
					<td><i>8 Hours</i></td>
				</tr>
				<tr>
					<td><b>FRI</b></td>
					<td>Check transactions.</td>
					<td><i>5 Hours</i></td>
				</tr>
			</table>
		</div>


		<div id="recentreport" class="tabcontent">
			<h3>Recent Report</h3>
			<p>This report was generated today</p>

		</div>

		<div id="punch" class="tabcontent">
			<h3>Last punched-in</h3>
			<p>You last punched in on</p>
			<button class="button button4 w3-blue">Clock-In</button>
		</div>


		<!-- End page content -->
	</div>
	<script>
		// Get the Sidebar
		var mySidebar = document.getElementById("mySidebar");

		// Get the DIV with overlay effect
		var overlayBg = document.getElementById("myOverlay");

		// Toggle between showing and hiding the sidebar, and add overlay effect
		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
				overlayBg.style.display = "none";
			} else {
				mySidebar.style.display = 'block';
				overlayBg.style.display = "block";
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
			overlayBg.style.display = "none";
		}

		function openCity(evt, cityName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(cityName).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>
</body>
</html>