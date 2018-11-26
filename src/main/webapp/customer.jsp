<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Subscription</title>
</head>
<body>
<form action="subscribe" method="post">
	No Of Months&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Subscription Amount Per month
	<br>
	<input type="text" name="noOfMonths">
	<input type="text" readonly="readonly" name="price" value="12">
	<input type="submit" value="Subscribe">
</form>
</body>
</html>