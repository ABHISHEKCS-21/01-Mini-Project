<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

 			function confirmDelete(){
			return confirm("Are you Sure,to Delete?");
			} 
</script>
</head>
<body>
	<center>
		<h3>View Contacts</h3>
	</center>
	<a href="load-form"> +Add New Contact</a>
	<table border="1">
		<thead>
			<tr>
				<th>Contact Id</th>
				<th>Contact Name</th>
				<th>Contact Email</th>
				<th>Contact Phone</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach items="${contacts}" var="contact">
			<tr>
				<td>${contact.contactId}</td>
				<td>${contact.contactName}</td>
				<td>${contact.contactEmail}</td>
				<td>${contact.contactNumber}</td>
				<td><a href="edit?cid=${contact.contactId}">Edit</a> <a
					href="delete?cid=${contact.contactId}" onclick="return confirmDelete()">Delete</a></td>
			</tr>

		</c:forEach>
		<tbody>

		</tbody>
	</table>
</body>
</html>