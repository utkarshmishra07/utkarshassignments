<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	
	form{
	border:4px solid violet;
	text-align:center;
	border-radius: 10px;
	padding:20px;
	}
	legend{
		color:red;
		text-align: center;
	}
		
	body{
		text-align:left;
		font-size:25px;
		font-family:calibri;
		font-weight: 800;
		text-shadow: black 1px 1px ;
		color :rgb(50,150,200);
		margin-top:20px;
		background-repeat: no-repeat;
		background-image: linear-gradient(to bottom right, rgb(180,150,256), white);
		background-size: 1000px 1000px;
	}
	
	input{
		background-color: cyan;
		border: 1px solid cyan;
		
	}
	</style>
	

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="addproduct">

Pid: &emsp; &emsp;	<input type="number" name="pid" value="${product.pid}" readonly/>
<br/>
<%String name = (String)request.getAttribute("readonly"); %>

Name:&emsp; &nbsp; <input type="text" placeholder="Enter Name" value="${product.pname}" name="pname" />
<br/>
Cost: &emsp;&emsp;<input type="number" placeholder="Enter Cost" value="${product.cost}" name="cost"/>
<br/>
Quantity: &nbsp;<input type="number" placeholder="Enter Quantity" value="${product.qty}" name="qty">
<br/>
<input type="submit" value="Submit"/>&nbsp;
<input type="reset" value="Reset"/>
</form>
</body>
</html>