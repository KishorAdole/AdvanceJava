<%@page import="com.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >
<meta charset="ISO-8859-1">
<title>Welcome to Inventory Management</title>
</head>
<body>
	<div style="
    background: -moz-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%),-moz-linear-gradient(top,  rgba(57,173,219,.25) 0%, rgba(42,60,87,.4) 100%), -moz-linear-gradient(-45deg,  #670d10 0%, #092756 100%);
    background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -webkit-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -webkit-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
    background: -o-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -o-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -o-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
    background: -ms-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), -ms-linear-gradient(top,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), -ms-linear-gradient(-45deg,  #670d10 0%,#092756 100%);
    background: -webkit-radial-gradient(0% 100%, ellipse cover, rgba(104,128,138,.4) 10%,rgba(138,114,76,0) 40%), linear-gradient(to bottom,  rgba(57,173,219,.25) 0%,rgba(42,60,87,.4) 100%), linear-gradient(135deg,  #670d10 0%,#092756 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#3E1D6D', endColorstr='#092756',GradientType=1 );">

<div style="
                    display: flex;
                    justify-content: center;
                    align-items: center;
                    height: 60vh;
                    color: black;
                    font-size: large;">
                    
                  <h1 style=" ">  Welcome to Inventory Management System </h1>
                    
       </div>


  <div 
                style="
                display:flex;
                justify-content: center; 
                align-items: center;
                height:40vh"
                > 
                
                
            <div style="
                   flex: 1;
                   display:flex;
                   justify-content: center; 
                   align-items: center;
                   height:40vh;
                   margin-right:10px
                  ">
              
	
	<a href="prepared_registration_form.htm" class="btn btn-lg btn-primary" type="button" style="background:Green">Sign Up</a>
		
		
 </div>
 
   <div style="
                   flex: 1;
                   display:flex;
                   justify-content:center; 
                   align-items: center;
                   height:40vh;
                   ">
                  
		
		 <a href="prepared_login_form.htm" class="btn btn-lg btn-primary" type="button" >Sign In</a>
		 </div>
	</div>
	</div>

</body>
</html>
<%
	}
%>