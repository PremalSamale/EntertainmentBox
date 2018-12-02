<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<title>Customer Subscription</title>
</head>
<body>
    <div>
        <div>
            <h2>Hello </h2>
        </div>
     	<form action="customer" method="post">
			<input type="text" name="noOfMonths">
			<input type="text" readonly="readonly" name="price" value="12">
			<input type="submit" value="Subscribe">
		</form>
       
    </div>
    
</body>
</html>