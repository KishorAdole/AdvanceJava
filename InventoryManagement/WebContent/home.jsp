<%@page import="com.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	User user =(User)session.getAttribute("user");
	if(user !=null  && user.getUserId() > 0 && user.getUserName().equalsIgnoreCase("admin")){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>

<table align="center" >
	<tr>
	<td>
	<h1> Welcome  <%= (session.getAttribute("user") !=null)?((User)session.getAttribute("user")).getUserName(): "!!!!!!!!!"%></h1>	
	</td>
	</tr>
		<tr>
			<td> <a href="prepare_inventory_add_form.htm" >Add Items</a> </td>
		</tr>
		<tr>
			<td> <a href="inventory_list.htm" >View Item List</a> </td>
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