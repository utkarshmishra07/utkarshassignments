<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set value="RASHMI is a bad girl" var="name"/>
<c:set value="HULK SMAAAAAAASHHH" var="comment"/>
<c:if test="${fn:containsIgnoreCase(name,'rashmi is a bad girl')}">
<p>The String contains rashmi </p>
</c:if>
<br/>
${fn:toLowerCase(name)}

<br/>
${fn:escapeXml(comment)} 
<br/>
</body>
</html>