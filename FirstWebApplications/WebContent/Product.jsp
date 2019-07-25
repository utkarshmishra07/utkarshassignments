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
<%@include file="Menu.html" %>
Logged in as ${sessionScope.uname}
<table>
<tr>
<th>PID</th>
<th>Name</th>
<th>Cost</th>
<th>Quantity</th>
<th> Action</th>
</tr>
<c:forEach items="${sessionScope.products}" var="p">
<tr>
<td>${p.pid}</td>
<td>${p.pname}</td>
<td>${p.cost}</td>
<td>${p.quantity}</td>
<td><a href="edit?pid=${p.pid}">Edit</a>
<a href="delete?pid=${p.pid}">Delete</a>
</td>
</tr>
</c:forEach>


</table> 
</body>
</html>