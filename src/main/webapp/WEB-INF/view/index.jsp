<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="border: 1px solid #ccc; padding: 5px; margin-bottom: 20px;"/>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
            <h1>Welcome to Entertainment Box!</h1>
			<h2><a style="font-size:150%" href="/signup">Signup</a></h2>
  			<h2><a style="font-size:150%" href="/login">Login</a></h2>
  			<u><h2 style="color: red;">
            <a onclick="document.forms['logoutForm'].submit()">Logout</a>
            </h3></u>
    <form id="logoutForm" method="POST" action="${contextPath}/logout">
    </form>
</body>
</html>