<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup page</title>
</head>
<body>
${name}
${error}
<form action="signup" method="post">

Name : <input type="text" name="cname">
<br/>
<br/>
Email : <input type="email" name="cemail" required>
<br/>
<br/>
Password : <input type="password" name="cpass" required >
<br/>
<br/>
Phone no. : <input type="number" name="phone">
<br/>
<input type="submit" value="Signup">

</form>
</body>
</html>