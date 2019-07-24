
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	table{ 
		border-collapse:collapse;
		background-color:white;
	}
	a:hover {
	color: green;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.role == 'admin'}">
<%@include file="menuadmin.html"%>
<table border="1">
			<tr>
				<th>Pid</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Quantity</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="p" items="${sessionScope.products}">
				<tr>
					<td>${p.pid}</td>
					<td>${p.pname}</td>
					<td>${p.cost}</td>
					<td>${p.qty}</td>
					<td><a href="edit?pid=${p.pid}">Edit</a></td>
					<td><a href="deleteservlet?pid=${p.pid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="addproduct.jsp">Add Product</a>
	</c:if>


	<c:if test="${sessionScope.role == 'customer'}">
		<%@include file="menucustomer.html"%>
	


		<table border="1">
			<tr>
				<th>Pid</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Quantity</th>
				<th>Buy</th>
			</tr>
			<c:forEach var="p" items="${sessionScope.products}">
				<tr>
					<td>${p.pid}</td>
					<td>${p.pname}</td>
					<td>${p.cost}</td>
					<td>${p.qty}</td>
					<td><a href="#?pid=${p.pid}">Buy</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
	
<%-- 
Logged in as 
${sessionScope.sname}
<br/>
<table border="1px">
	<tr>
		<th>Pid</th>
		<th>PName</th>
		<th>Cost</th>
		<th>Quantity</th>
		<th>Action</th>
	</tr>
		<c:forEach items="${sessionScope.products}" var="p">
		<tr>
		<td>${p.pid}</td>
		<td>${p.pname}</td>
		<td>${p.qty}</td>
		<td>${p.cost}</td>
		<td>
			<a href="edit?pid=${p.pid}&readonly=${'readonly'}">Edit</a>
			<a href="deleteservlet?pid=${p.pid}">Delete</a>
			
		</td>
		</tr>
	</c:forEach>
</table><br/>
<a href="addproduct.jsp?readonly=' ' ">Add product</a>
 --%></body>
</html>