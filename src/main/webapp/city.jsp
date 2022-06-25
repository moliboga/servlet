<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 25.06.2022
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>City never sleeps</title>
</head>
<body>
<form action="/api/city" method="POST">
    Enter city name <input type="text" name="name"><br><br>
    <input type="submit" value="Redirect to city weather json data">
</form>
</body>
</html>
