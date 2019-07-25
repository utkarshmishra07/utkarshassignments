<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addproduct">
		pid:<input type="text" name="pid" readonly="readonly" value="${product.pid}"><br/>
		 Product Name:<input type="text" name="pname" value="${product.pname}"><br/> 
		 cost:<input type="text" name="cost" value="${product.cost}"><br /> 
			quality:<input type="text" name="quantity" value="${product.quantity}"><br/> 
			<input type="submit" value="submit">
		<input type="reset" value="reset">
		
	</form>
</body>
</html>
