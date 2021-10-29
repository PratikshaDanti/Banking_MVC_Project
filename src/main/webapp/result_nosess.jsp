<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>
	<% String val=(String)request.getAttribute("val");
	   out.println(""+val); %>
	 </h2>
	 <br/>
	 <br/>
	 
	 <form name="myForm3" action="result_login.jsp" method="POST">
	<input type="Submit" value="Menu" >
	</form>
	
	<form name="myForm2" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>
</body>
</html>