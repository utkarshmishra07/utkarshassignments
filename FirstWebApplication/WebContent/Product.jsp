<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
a:hover {
	color: red;
}
</style>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:if test="${sessionScope.role == 'admin'}">
		<%@include file="MenuAdmin.html"%>
		<%-- <%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %> --%>

		<%-- <s:setDataSource driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="java166"
		password="1234" var="db" /> --%>


		<%-- <s:query var="rs" dataSource="${db }"%>
select * from product
</s:query> --%>


		<table border="1">
			<tr>
				<th>Pid</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Quantity</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="pd" items="${sessionScope.products}">
				<tr>
					<td>${pd.pid}</td>
					<td>${pd.pname}</td>
					<td>${pd.cost}</td>
					<td>${pd.quantity}</td>
					<td><a href="Edit?pid=${pd.pid}">Edit</a></td>
					<td><a href="delete?pid=${pd.pid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="AddProduct.jsp">Add Product</a>
	</c:if>


	<c:if test="${sessionScope.role == 'customer'}">
		<%@include file="MenuCustomer.html"%>
	


		<table border="1">
			<tr>
				<th>Pid</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Quantity</th>
				<th>Buy</th>
			</tr>
			<c:forEach var="pd" items="${sessionScope.products}">
				<tr>
					<td>${pd.pid}</td>
					<td>${pd.pname}</td>
					<td>${pd.cost}</td>
					<td>${pd.quantity}</td>
					<td><a href="#?pid=${pd.pid}">Buy</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>