
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Employees</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
  

<script>
$(document).ready( function () {
    $('#myTable').DataTable();
} );

function deleteConfirm(){
	return confirm("Are you sure to Delete?");
}

</script>


</head>
<body>

<h2 align="center">Employee Records</h2>

<table id="myTable">
<thead>
<tr align="left">
	<th>Employee ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Gender</th>
	<th>Actions</th>
</tr>
</thead>

<c:forEach items = "${employees}" var="e">
<tr>
	<td>${ e.emp_id }</td>
	<td>${ e.first_name } </td>
	<td>${ e.last_name } </td>
	<td>${ e.gender } </td>
	<td><a href="editEmp?id=${ e.emp_id }">Edit</a> | 
	<a href="deleteEmp?id=${ e.emp_id }" onclick="deleteConfirm()">Delete</a></td>	
</tr>

</c:forEach>
</table>

</body>
</html>