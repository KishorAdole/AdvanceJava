<%@page import="com.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
   
<%  
	User user =(User)session.getAttribute("user");
	if(user !=null  && user.getUserId() > 0){
%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Update Items</title>
</head>
<body>
	<div class="login">
	  <h1>Update Items</h1>
	  
		<spr:form action="inventory_update.htm" method="post" commandName="inventory" >
	
			<spr:hidden path="itemId"/>
			<spr:input type="text" path="itemName" placeholder="Item Name" required="required" />
			<spr:input type="text" path="quantity" placeholder="Quantity" required="required" />
        	<spr:input type="text" path="date" placeholder="Date" required="required" />
        	<spr:input type="text" path="price" placeholder="Price" required="required" />
        	<button type="submit" class="btn btn-primary btn-block btn-large">Update</button>	
        		
        	
		</spr:form>
		
	</div>
	
</body>
</html>
<%
	}else
		response.sendRedirect("index.jsp");
%>