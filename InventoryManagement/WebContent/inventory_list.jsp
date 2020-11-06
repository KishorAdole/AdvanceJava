<%@page import="com.project.dto.User"%>
<%@page import="com.project.dto.Inventory"%>
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
<meta charset="ISO-8859-1">
<title>Inventory List</title>
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
    		<th>Purchase Date</th>
    		<th>Price</th>
    		<th>Delete</th>
    		<th>Update</th>
  		</tr>
		<% 
		List<Inventory> list = (List<Inventory>)request.getAttribute("inventoryList");
		for(Inventory inventory : list){
		%>
		
		<tr>
			<td>
				<%=inventory.getItemName()%>
			</td>
			<td>
				<%=inventory.getQuantity()%>
			</td>
			<td>
				<%=inventory.getDate()%>
			</td>
			<td>
				<%=inventory.getPrice()%>
			</td>
			
		
		 <td>
				<a href="inventory_delete.htm?itemId=<%=inventory.getItemId()%>"  class="btn btn-outline-danger" type="button">Delete</a>
			</td>
			<td>
				<a href="inventory_update_form.htm?itemId=<%=inventory.getItemId()%>"  class="btn btn-outline-warning" type="button">Update</a>
			</td>
			</tr>
		
		<% } %>
		<tr>
			<td>
				<a href="home.jsp"  class="btn btn-outline-success" type="button">Back</a>
			</td>

		</tr>
	</table>

</body>
</html>
<%
	}else
		response.sendRedirect("index.jsp");
%>