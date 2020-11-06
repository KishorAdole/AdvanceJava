<%@page import="com.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %> 

<%  
	User user = (User)session.getAttribute("user");
	
	if(user !=null  && user.getUserId() > 0){
		if(user.getUserName().equalsIgnoreCase("admin")){
			response.sendRedirect("home.jsp");
		}else{
			response.sendRedirect("user_home.jsp");	
		}
		
	}else{
%>   
    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Welcome to Login Page</title>
</head>
<body>

  <div class="login">
	<h1>Login</h1>
		<spr:form action="login.htm" method="post" commandName="user" >
	
  			<spr:input type="text" path="userName" placeholder="Username" required="required" />
        	<spr:input type="password" path="userPassword" placeholder="Password" required="required" />
        	<button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
        	<br><a href="#" style="color:white;text-decoration:none">Forgot password ?</a><br><br>
        	<a href="prepared_registration_form.htm" style="color:white;text-decoration:none">New User</a>
   
		</spr:form>
  </div>
  	
</body>
</html>
<%
	}
%>