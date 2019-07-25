<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:set var="employees">
<employees>
<employee>
<eid>123</eid>
<ename>hari</ename>
<salary>2344</salary>
</employee>
<employee>
<eid>345</eid>
<ename>priya</ename>
<salary>13445</salary>
</employee>
</employees>
</c:set>
<x:parse xml="${employees}" var="emps"/>
<x:choose>
<x:when select="$emps//employee/ename='hari'">
hari is best employee
</x:when> 
<x:when select="$emps//employee/ename='priya'">
priya is best employee
</x:when> 
<x:otherwise>
employee not available
</x:otherwise>
</x:choose>
<ul>
<x:forEach select="$emps//employee/ename" var="n">
<li><x:out select="$n"/></li>
</x:forEach>
</ul>
</body>
</html>
