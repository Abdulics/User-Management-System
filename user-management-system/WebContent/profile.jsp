<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<head>
<style type="text/css">
/* Style the tab content */
.tabcontent {
	float: left;
	padding: 0px 12px;
	border: 1px solid #ccc;
	width: 100%;
	border-left: none;
	height: 350px;
}

input {
	border-style: none;
}
</style>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body class="w3-theme-l5">

		<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); //http 1.0
		%>
	<c:if test="${logged == null }">
		<c:redirect url="login.html"></c:redirect>
	</c:if>

	<!-- Top container -->

	<c:if test="${edit == null }">
		<form action="Login" method="post">
			<input type="hidden" name="command" value="EDIT" />
			<div id="schedule" class="tabcontent"
				style="margin-left: 0px; margin-top: 43px;">
				<h3>Personal info</h3>

				<table class="w3-table w3-striped w3-white">
					<tr>
						<td><b>First name</b></td>
						<td><c:out value="${name }"></c:out></td>
					</tr>
					<tr>
						<td><b>Last name</b></td>
						<td><c:out value="${lname }"></c:out></td>
					</tr>
					<tr>
						<td><b>Email</b></td>
						<td><c:out value="${email }"></c:out></td>
					</tr>
					<tr>
						<td><b>Employee Id</b></td>
						<td><c:out value="${em_id }"></c:out></td>
					</tr>
					<tr>
						<td><b>Username</b></td>
						<td><c:out value="${uname }"></c:out></td>
					</tr>
					<tr>
						<td><b>Password</b></td>
						<td><c:out value="${pass }"></c:out></td>
					</tr>

				</table>
			</div>
			<input class="w3-bar-item w3-button w3-padding w3-blue" type="submit"
				value="Edit profile" />
		</form>

	</c:if>

	<c:if test="${edit}">
		<div id="schedule" class="tabcontent"
			style="margin-left: 0px; margin-top: 43px;">
			<form action="Login" method="post">
				<h3>Edit Personal info</h3>
				<input type="hidden" name="command" value="UPDATE" /> <input
					type="hidden" name="studentId" value="${em_id}" />

				<table class="w3-table w3-striped w3-white">
					<tbody>
						<tr>
							<td><label><b>First name</b></label></td>
							<td><input type="text" name="fname" value="${name}" /></td>
						</tr>

						<tr>
							<td><label><b>Last name</b></label></td>
							<td><input type="text" name="lname" value="${lname}" /></td>
						</tr>

						<tr>
							<td><label><b>Email</b></label></td>
							<td><input type="text" name="email" value="${email}" /></td>
						</tr>

						<tr>
							<td><label><b>Password</b></label></td>
							<td><input type="password" name="password" value="${pass}" /></td>
						</tr>
					</tbody>
				</table>
				<input class="w3-bar-item w3-button w3-padding w3-blue"
					type="submit" value="Update profile" />
			</form>
			<form action="Login" method="post">
				<input type="hidden" name="command" value="!EDIT" /> <input
					class="w3-bar-item w3-button w3-padding w3-blue" type="submit"
					value="Cancel Edit" />
			</form>
		</div>
	</c:if>



</body>
</html>