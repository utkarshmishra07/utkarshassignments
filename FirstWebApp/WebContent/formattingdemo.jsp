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
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>Formatting number</h1>
<c:set value="98567.345652" var="sal"/>

<f:formatNumber value="${sal }" type="currency"></f:formatNumber>
<br/><br/>
<f:formatNumber value="${sal }" type="number" groupingUsed="false"></f:formatNumber>
<br/><br/>
<f:formatNumber value="${sal }" type="percent"></f:formatNumber>
<br/><br/>
<f:formatNumber value="${sal }" type="number" maxIntegerDigits="4"></f:formatNumber>
<br/><br/>
<f:formatNumber value="${sal }" type="currency" currencyCode="USD"></f:formatNumber>
<br/><br/>
<c:set var="date" value="<%= new java.util.Date() %>"></c:set>
<h1>Formatting date</h1>
<f:formatDate value="${date }" pattern="MMM/dd/yyyy HH:MM:SS a" type="both"/>
<br/>
<f:formatDate value="${date }" type="date" dateStyle="long"/>
<br/>
<f:formatDate value="${date }" type="time" timeStyle="short"/>
<br/>
<f:formatDate value="${date }" type="date" pattern="MMM/dd/yyy"/>
<br/>
</body>
</html>