<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.p1.pojo.Banking"%>
    <%@ page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html>
<head>
<style> table, th, td { border: 1px solid black; border-collapse: collapse;} 
form { display: inline; }
</style>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>
<% LinkedList<Banking> t1=(LinkedList)request.getAttribute("blistobj");
	   out.println("<h3>Account Details:</h3>"); 
	   out.println("<table>");
	   out.println("<tr> <th>Account number</th> <th>Customer id</th> <th>category id</th> <th>date of init</th> <th>account balance</th> </tr>");
	  
	%> 
	
	<%
		if(request.getAttribute("blistobj") != null)  // Null check for the object
		{
			Iterator<Banking> iterator = t1.iterator();  // Iterator interface
			
			while(iterator.hasNext())
			{
				Banking tDetails = iterator.next(); //assign individual record to the transactions class object
			%>
			<tr><td><%=tDetails.getAccount_no()%></td>
				<td><%=tDetails.getCid()%></td>
				<td><%=tDetails.getCtg_id()%></td>
				<td><%=tDetails.getDateofinit()%></td>
				<td><%=tDetails.getAccbal()%></td>
				
			</tr>
	<%
	}
}
%>
	</table>
	<br/>
	<br/>
	<form name="myForm3" action="AccountsChoice.html" method="POST">
	<input type="Submit" value="Menu" >
	</form>
	
	<form name="myForm4" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>

</body>
</html>