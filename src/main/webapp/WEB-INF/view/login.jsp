<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Customer Subscription</title>
</head>
<body>
        <form action="login" method="post" modelAttribute="userlogin">
			emailAddress: <input type="email" name="emailAddress"/>
			password:<input type="password"  name="password" />
			<input type="submit" value="Login">
		</form>
</body>
</html>