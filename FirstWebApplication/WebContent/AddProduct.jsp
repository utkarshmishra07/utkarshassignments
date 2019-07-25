<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${requestScope.Product}" var="p"/>
<form action="Add">
Pid:<input type="number" name="pid" value="${p.pid}" readonly="readonly">
<br/><br/>
Pname:<input type="text" name="pname"value="${p.pname}">
<br/><br/>
Cost:<input type="text" name="cost"value="${p.cost}">
<br/><br/>
Quantity:<input type="text" name="quantity"value="${p.quantity}">
<br/>
<br/>
<input type="submit" name="submit" value="AddProduct">

</form>

</body>
</html>