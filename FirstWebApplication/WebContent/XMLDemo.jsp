<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<c:set var="employees">
<employees>
	<employee>
		<eid>478</eid>
		<ename>kkk</ename>
		<salary>76465</salary>
	</employee>
	<employee>
		<eid>468</eid>
		<ename>zzz</ename>
		<salary>64563</salary>
	</employee>
		<employee>
		<eid>458</eid>
		<ename>yyy</ename>
		<salary>76763</salary>
	</employee>
</employees>

</c:set>
<x:parse xml="${employees}" var="emps"/>
<x:choose>
	<x:when select="$emps//employee/ename='zzz'">
	zzz is a good employee
	</x:when>
		<x:when select="$emps//employee/ename='kkk'">
	kkk is a good employee
	</x:when>
	<x:otherwise>
	Employee not available
	</x:otherwise>
</x:choose>
<ul>
<x:forEach select="$emps//employee/ename" var="n">
<li><x:out select="$n"></x:out></li>
</x:forEach></ul>

</body>
</html>