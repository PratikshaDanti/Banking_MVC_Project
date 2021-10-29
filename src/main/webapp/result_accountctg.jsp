<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.p1.pojo.AccountCtg"%>
<!DOCTYPE html>
<html>
<head>
<style> form { display: inline; }
table, th, td { border: 1px solid black; border-collapse: collapse;} </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% AccountCtg ac=(AccountCtg)request.getAttribute("acobj");
	
		out.println("<h3>Account Category Details:</h3>"); 
		out.println("<table>");
	   out.println("<tr> <th>Category id</th> <th>Category Name</th></tr>");
	   out.println("<tr> <td>"+ac.getCtg_id()+"</td><td>"+ac.getCategory()+"</td>"+"</tr>");
	   out.println("</table>");
		
	%>
	<br/>
	 <br/>
	 <br/>
	 <h3><a href="Logout.html">Logout</a></h3><br/>
	 <h3><a href="MainPage.html">Home</a></h3>
	 

</body>
</html>



