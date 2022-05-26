<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Access</title>
</head>
<body>

<h4>Admin:${sessionScope.user.firstName} ${sessionScope.user.lastName} </h4>
			
			
			
			<div>
		<h2>User Accounts</h2>
		<h5>Manage user accounts.</h5>
		<form action="ViewResume.do" method="GET">
	
		</form>
	
			
			
			<table>
		<thead>
			<tr>
				<th scope="col">User ID</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
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
			<td>${userResume.username}</td>
			<td>${userResume.password}</td>
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
			
			</div>
		
		
</body>
</html>