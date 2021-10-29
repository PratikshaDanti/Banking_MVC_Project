<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.p1.pojo.UserSession"%>
    <%@ page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html>
<head>
<style> table, th, td { border: 1px solid black; border-collapse: collapse;} 
form { display: inline; }</style>
<meta charset="ISO-8859-1">
<title>Session Details</title>
</head>
<body>
<% LinkedList<UserSession> t1=(LinkedList)request.getAttribute("tobj");
	   out.println("<h3>Session Details:</h3>"); 
	   out.println("<table>");
	   out.println("<tr> <th>Login time</th> <th>Logout time</th> <th>session id</th> <th>user id</th> </tr>");
	  
	%> 
	
	<%
		if(request.getAttribute("tobj") != null)  // Null check for the object
		{
			Iterator<UserSession> iterator = t1.iterator();  // Iterator interface
			
			while(iterator.hasNext())
			{
				UserSession tDetails = iterator.next(); //assign individual record to the transactions class object
			%>
			<tr><td><%=tDetails.getCreatetime()%></td>
				<td><%=tDetails.getLastaccesstime()%></td>
				<td><%=tDetails.getSid()%></td>
				<td><%=tDetails.getUserid()%></td>
				
			</tr>
	<%
	}
}
%>
	</table>
	<br/>
	<br/>
	<form name="myForm3" action="result_login.jsp" method="POST">
	<input type="Submit" value="Menu" >
	</form>
	
	<form name="myForm3" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>

</body>
</html>