<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<h1>Bundle Demo</h1>
<f:setBundle basename="com.mphasis.cart.beans.Message" var="m"/>
<f:message key="snacks.pani" bundle="${m}"></f:message>
<f:message key="snacks.bhel" bundle="${m}"></f:message>
<f:message key="snacks.masala" bundle="${m}"></f:message>

</body>
</html>