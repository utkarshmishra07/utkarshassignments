<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<c:set var="employees">
		<employees> 
			<employee> 
				<eid>2321</eid>
				<ename>Raju</ename>
				<salary>2131234</salary>
			</employee> 
			<employee> 
				<eid>3211</eid> 
				<ename>Sanju</ename>
				<salary>2435234</salary> 
			</employee> 
			<employee> 
				<eid>3453</eid> 
				<ename>Manju</ename>
				<salary>32</salary> 
			</employee> 
		</employees>
	</c:set>
	<x:parse xml="${employees }" var="emps"/>
	<x:choose>
		<x:when select="$emps//employee/ename ='Raju'">
			Raju is good.
		</x:when>
		<x:when select="$emps//employee/ename ='Sanju'">
			Manju is bad.
		</x:when>
		<x:otherwise>
			employee not available
		</x:otherwise>
	</x:choose>
	<x:forEach select="$emps//employee/ename" var="n">
		<li><x:out select="$n"/></li>
	</x:forEach>
</body>
</html>