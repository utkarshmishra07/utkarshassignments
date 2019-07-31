<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="welcome.jsp"%>
<table border="1">
			<tr>
				<th>Cid</th>
				<th>Cemail</th>
				<th>Cname</th>
				<th>Phone</th>
				<th>Reg. Date</th>
				
			</tr>
			<c:forEach var="p" items="${ca}">
				<tr>
					<td>${p.cid}</td>
					<td>${p.cemail}</td>
					<td>${p.cname}</td>
					<td>${p.phone}</td>
					<td>${p.reg_date}</td>
					<td><a href="edit?cid=${p.cid}">Edit</a></td>
					<td><a href="remove?cid=${p.cid}">Remove</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="welcome.jsp">Return to Welcome page</a>

</body>
</html>