<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jspf"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css" />
<head>
<meta charset="UTF-8">
<script src="https://kit.fontawesome.com/64d58efce2.js"
	crossorigin="anonymous"></script>
<title>Password reset</title>
</head>
<body>


	
	<div id="schedule" class="tabcontent"
		style="margin-left: 0px; margin-top: 43px;">
		<c:if test="${newPassword == null }">
		<form action="Login" class="sign-in-form" method="post">
			<input type="hidden" name="command" value="RESETPASS" />
			<h2 class="title">Password reset</h2>

			<div class="input-field">
				<i class="fas fa-user"></i> <input type="text" name="employeeid"
					value="${em_id }" />
			</div>
			<div class="input-field">
				<i class="fas fa-user"></i> <input type="text" name="username"
					value="${uname }" />
			</div>

			<div class="input-field">
				<i class="fas fa-lock"></i> <input type="password" name="password"
					placeholder="new password" />
			</div>
			<input type="submit" class="btn" value="Reset password" />
		</form>
		</c:if>
		<c:if test="${newPassword != null }">
		Your password has been reset, Please logout to use your new password.<br>
		Thanks...<br>
		<a href="logout" class="w3-bar-item w3-button">Logout</a>
		</c:if>
	</div>
</body>
</html>