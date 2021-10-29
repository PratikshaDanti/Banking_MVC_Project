<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="com.p1.pojo.UserLogin"%>
      <%@ page session= "true" %>
<!DOCTYPE html>
<html>
<head>
<style>
form { display: inline; }
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> Welcome to Net Banking</h2> 

	<h4>customer id:${cid} </h4>
	<h4>hi, ${cname} </h4>
	
	<form name="myForm1" action="CustomerChoice.html" method="POST">
	<input type="Submit" value="Customer" >
	</form>
	
	<form name="myForm2" action="AccountsChoice.html" method="POST">
	<input type="Submit" value="Accounts" >
	</form>
	
	<form name="myForm3" action="TransactionChoice.html" method="POST">
	<input type="Submit" value="Transactions" >
	</form>
	
	<form name="myForm6" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>
	
	<form name="myForm6" action="SessionById" method="POST">
	<input type="Submit" value="View Previous Sessions" >
	</form>

</body>
</html>