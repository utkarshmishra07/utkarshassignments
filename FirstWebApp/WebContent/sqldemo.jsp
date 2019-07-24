<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQL DEMO</title>
</head>
<body>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql"%>

	<s:setDataSource driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="nano" password="nano"
		var="db"/>
	<c:set value="450" var="qty"></c:set>
	<c:set value="200" var="cost"></c:set>
	<s:transaction dataSource="${db }">
	<s:update>
		update product set quantity=?,cost=? where pid=13
		<s:param value="${qty }"></s:param>
		<s:param value="${cost }"></s:param>
	</s:update>
	<s:query var="rs">
		select * from product
	</s:query>
	</s:transaction>
	<table border="1px">
		<tr>
			<th>Pid</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Cost</th>
		</tr>
		<c:forEach var="pd" items="${rs.rows}">
		<tr>
			<td>${pd.pid}</td>
			<td>${pd.pname}</td>
			<td>${pd.quantity}</td>
			<td>${pd.cost}</td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>