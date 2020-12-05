<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/header.jspf" %>
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="w3-theme-l5">

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<c:if test="${logged == null }">
		<c:redirect url="in.html"></c:redirect>
	</c:if>
	<!-- Top container -->
	<div id="schedule" class="tabcontent" style="margin-left: 0px; margin-top: 43px;">
		<h3>Weekly Schedule</h3>
		<p>These are the days you are scheduled to work this week.</p>
		<table class="w3-table w3-striped w3-white">
		<tr>
        <th>Day of week</th>
        <th>Shift Time</th>
        <th>Hours Will Work</th>
      </tr>
			<tr>
				<td>
						<b>MON</b>
					</td>
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
	<a href="#" class="w3-bar-item w3-button w3-padding w3-blue" style="margin-top 43"><i
				></i> Request-Schedule-Change</a>
</body>
</html>