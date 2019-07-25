<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.mphasis.cart.beans.CartA" %>
     <%@ page import="com.mphasis.cart.bo.CartAUserBo" %>
     <%@ page import="com.mphasis.cart.bo.CartAUserBoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! CartAUserBo cartAUserBo = new CartAUserBoImpl(); %>
<% 
String name=request.getParameter("uname");
CartA user=cartAUserBo.login
(name,request.getParameter("pwd"));
try
{
session.setAttribute("sname",name);
out.print("Welcome" +name);
pageContext.setAttribute("pname",name,PageContext.APPLICATION_SCOPE);
%>
<%@include file="Menu.html"%>
<% 
}catch(Exception e)
{e.printStackTrace();
%>
<jsp:forward page="Login.html"></jsp:forward>
<%} %>
<br/>
<%= new java.util.Date() %>
</body>
</html>