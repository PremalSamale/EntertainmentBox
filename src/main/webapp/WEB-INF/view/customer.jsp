<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Customer Subscription</title>
</head>
<body>
        <form action="subscribe" method="post">
			noOfMonths: <input type="text" name="noOfMonths"/>
			price:<input type="text" readonly="readonly" name="price" value="12"/>
			<input type="submit" value="Subscribe">
		</form>
</body>
</html>