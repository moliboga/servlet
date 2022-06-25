<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP Actions Example</title>
</head>
<body>

<h1> Vote checker page</h1>
<div>
    <form action='/api/vote' method="POST">
        Person Name:: <input type="text" name="pname"><br><br>
        Person Age:: <input name="page"><br><br>
        <input type="submit" value="Check Voting Eligibility">
    </form>
</div>
</body>
</html>