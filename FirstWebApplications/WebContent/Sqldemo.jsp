<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:setDataSource driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe" user="mohit" password="notforsale" var="db"/>

<table border='1' >
<tr>
<th bgcolor="red">JCODE</th>
<th bgcolor="red">JNAME</th>

</tr>
<c:set value="992" var="jcode"/>
<c:set value="ramp" var="jname"/>
<s:transaction dataSource="${db}">
<s:update>
insert into job values(?,?)
<s:param value="${jcode}"></s:param>
<s:param value="${jname}"></s:param>
</s:update>
<s:update>
update job set jname= 'ramp' where jcode=121
</s:update>
</s:transaction>
<c:forEach var="pd" items="${rs.rows}">
<tr>
<td>${pd.jcode}</td>
<td>${pd.jname}</td>
</tr>
</c:forEach>
<s:query var="rs" dataSource="${db}">
	select * from job
</s:query>

</table>
</body>
</html>