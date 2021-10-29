<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.p1.pojo.Transactions"%>
    <%@ page import="java.util.LinkedList" %>
    <%@page import="java.util.Iterator"%> 
<!DOCTYPE html>
<html>
<head>
<style> table, th, td { border: 1px solid black; border-collapse: collapse;} 
form { display: inline; }</style>
<meta charset="ISO-8859-1">
<title>Transaction Details</title>
</head>
<body>
<% LinkedList<Transactions> t1=(LinkedList)request.getAttribute("tobj");
	   out.println("<h3>Transaction Details:</h3>"); 
	   out.println("<table>");
	   out.println("<tr> <th>transaction id</th> <th>Account number</th> <th>Transaction date</th> <th>Amount</th> <th>Comments</th> </tr>");
	  
	%> 
	
	<%
		if(request.getAttribute("tobj") != null)  // Null check for the object
		{
			Iterator<Transactions> iterator = t1.iterator();  // Iterator interface
			
			while(iterator.hasNext())
			{
				Transactions tDetails = iterator.next(); //assign individual record to the transactions class object
			%>
			<tr><td><%=tDetails.getTrn_id()%></td>
				<td><%=tDetails.getAccount_no()%></td>
				<td><%=tDetails.getTrn_date()%></td>
				<td><%=tDetails.getAmount()%></td>
				<td><%=tDetails.getComments()%></td>
				
			</tr>
	<%
	}
}
%>
	</table>
	<br/>
	<br/>
	<form name="myForm3" action="TransactionChoice.html" method="POST">
	<input type="Submit" value="Menu" >
	</form>
	
	<form name="myForm4" action="UserSessionServlet" method="GET">
	<input type="Submit" value="Logout" >
	</form>

</body>
</html>