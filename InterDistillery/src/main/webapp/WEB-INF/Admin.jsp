<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Access</title>
</head>
<body>

			<table>
		<thead>
			<tr>
				<th scope="col">User ID</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Active</th>
				<th scope="col">Role</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="User" items="${User}"> 
			<tr>
			
			<td><a href="ViewResume.do?id=${user.id}">${user.id}</a></td>
			<td>${user.firstName}</td>
			<td>${userResume.lastName}</td>
			<td>${userResume.email}</td>
			<td>${userResume.active}</td>
			<td>${userResume.role}</td>
			
			
				<td><form action="directToUpdateResume.do" method="GET">
				<input type="text" hidden="true" value="${user.id}" name="resumeId" /> 
				<input type="submit" value="edit">
				</form>
				
				<form action="deleteResume.do" method="POST">
				<input type="text" hidden="true" value="${user.id}" name="resumeId" /> 
				<input type="submit" value="delete">
				</form></td>
			
			
			</tr>
			</c:forEach>
			</tbody>
			</table>
		
		
</body>
</html>