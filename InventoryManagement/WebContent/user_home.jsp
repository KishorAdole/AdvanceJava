<%@page import="com.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	User user1 =(User)session.getAttribute("user");
	if(user1 !=null  && user1.getUserId() > 0){
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
</head>
<body>

	<table align="center" >
		<tr>
			<td><h1> Welcome <%= (session.getAttribute("user") !=null)?((User)session.getAttribute("user")).getUserName(): "!!!!!!!!!"%> </h1></td>
		</tr>
		
		<tr>
			<td> <a href="prepare_item_add_form.htm" >Purchase Item</a> </td>
		</tr>
		<tr>
			<td> <a href="purchase_list.htm" >Show List</a> </td>
		</tr>
		<tr>
			<td> <a href="logout.htm" >Logout</a> </td>
		</tr>
		
	</table>
	

</body>
</html>

<%
	}else
		response.sendRedirect("index.jsp");
%>