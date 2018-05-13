<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" language = "java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
        <title>Store App</title>
    </head>
    <body>
        <h3>App from Anton</h3>
		<br/>
		<a href="<c:url value="transactions"/>" target="_blank"> Transactions list</a>
		<br/>
		<a href="<c:url value="stores"/>" target="_blank"> Stores list</a>
		<br/>
		<a href="<c:url value="products"/>" target="_blank"> Products</a>
		<br/>
    </body>
</html>
