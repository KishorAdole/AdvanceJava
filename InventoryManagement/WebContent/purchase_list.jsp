<%@page import="com.project.dto.User"%>
<%@page import="com.project.dto.Purchase"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%  
	User user =(User)session.getAttribute("user");
	if(user !=null  && user.getUserId() > 0){
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" >

<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body  >

	<table align="center" >
		<tr>
    		<th>Item Name</th>
    		<th>Quantity</th>
    		<th>Price</th>
  		</tr>
		<% 
		List<Purchase> list = (List<Purchase>)request.getAttribute("purchaseList");
		for(Purchase purchase : list){
		%>
		<tr>
			<td>
				<%=purchase.getItemName()%>
			</td>
			<td>
				<%=purchase.getQuantity()%>
			</td>
			<td>
				<%=purchase.getPrice()%>
			</td>
			
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="buy_items.htm" class="btn btn-outline-danger" type="button" >Buy Items</a>
			</td>
			<td>
				<a href="user_home.jsp" class="btn btn-outline-danger" type="button" >Back</a>
			</td>
			
		</tr>
	</table>

</body>
</html>
<%
	}else
		response.sendRedirect("index.jsp");
%>