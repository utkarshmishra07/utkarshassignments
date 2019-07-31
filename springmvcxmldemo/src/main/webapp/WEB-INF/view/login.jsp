<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
${error}
<form action="login" method="post">
Email : <input type="email" name="email" required>
<br/>
<br/>
Password : <input type="password" name="pwd" required >
<br/>
<br/>
GET ALL: <input type="button">
<input type="submit" value="Login">
</form>

</body>
</html>