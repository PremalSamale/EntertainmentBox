<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Customer Subscription</title>
</head>
<body>
        <form action="subscribe" method="post">
        	<input type="hidden" name="emailaddress" value="${emailAddress}"/><br>
			noOfMonths: <input type="text" name="noOfMonths"/><br>
			price:<input type="text" readonly="readonly" name="price" value="12"/><br>
			<input type="submit" value="Subscribe">
		</form>
</body>
</html>