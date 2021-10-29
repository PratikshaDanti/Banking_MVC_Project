<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.p1.pojo.Customer"%>
    <%@ page import="com.p1.pojo.UserLogin"%>
   
<!DOCTYPE html>
<html>
<head>
<style> form { display: inline; }
table, th, td { border: 1px solid black; border-collapse: collapse;} </style>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
	<% //Customer c=(Customer)request.getAttribute("cobj");
	   //out.println("<h3>Customer Details:</h3>"); 
	   //out.println("<table>");
	   //out.println("<tr> <th>Customer id</th> <th>Customer Name</th> <th>Mobile number</th> <th>Mail id</th> <th>user id</th> </tr>");
	   //out.println("<tr> <td>"+c.getCid()+"</td><td>"+c.getCname()+"</td><td>"+c.getMob()+"</td><td>"+c.getMail_id()+"</td><td>"+c.getUid()+"</td>"+"</tr>");
	   //out.println("</table>");	
	%>
	<h3>Customer Details:</h3>
	<table>
	<tr> <th>Customer id</th> <th>Customer Name</th> <th>Mobile number</th> <th>Mail id</th> <th>user id</th> </tr>
	
	<tr> 
	<td> ${cobj.getCid()} </td>
	<td> ${cobj.getCname()} </td>
	<td> ${cobj.getMob()} </td>
	<td> ${cobj.getMail_id()} </td>
	<td> ${cobj.getUid()} </td>
	</table>
	<br/>
	<br/>
		
	<form name="myForm2" action="CustomerChoice.html" method="POST">
	<input type="Submit" value="Menu" >
	</form>
		
	<form name="myForm3" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>
</body>
</html>