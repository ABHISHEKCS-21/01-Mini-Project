<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>
			<b>Contact Informatin</b>
		</h2>
	</center>

	<form:form action="saveContact?contactId=${contact.contactId}" method="post" modelAttribute="contact">

		<center>
			<h3>${succMsg }</h3>
		</center>
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="contactName"></form:input></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="ContactEmail"></form:input></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><form:input path="ContactNumber"></form:input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></input></td>
			<tr>
		</table>
	</form:form>
	<a href="view-contacts"> View All Contacts</a>
</body>
</html>