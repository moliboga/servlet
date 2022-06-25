<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP Actions Example</title>
</head>
<body>

<h1> Sex checker page</h1>
<div>
    <form action='/main?command=sex' method="POST">
        Wanna sex?:: <input type="checkbox" name="sexAddiction"><br><br>
        Are u 18+?:: <input type="checkbox" name="18"><br><br>
        <input type="submit" value="Check Sex Eligibility">
    </form>
</div>
</body>
</html>