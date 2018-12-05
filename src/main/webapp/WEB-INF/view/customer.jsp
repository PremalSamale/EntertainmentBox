<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/view/includes.jsp" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Customer Subscription</title>
</head>
<body>
	<form action="subscribe" method="post">
		<input type="hidden" name="emailaddress" value="${emailAddress}"/><br>
		Number of Months: <input type="text" name="noOfMonths"/><br>
		Price per month($):<input style="background-color: #E0E0E0;" type="text" readonly="readonly" name="price" value="10"/><br>
		<input type="submit" value="Pay & Subscribe">
	</form>
	<br><br>
	<form action="searchMovie">
		<input style="width:1000px" type"text" name="searchText"></input><br>
		<input type="submit" value="Search Movie">
	</form>
	<br>
	<table border="1">
		<th>Movie Title</th>
		<th>Movie Link</th>
		<c:forEach items="${movieList}" var="movie">
			<tr>
				<td>${movie.title}</td>
				<td><a href="${movie.movie}">link</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>