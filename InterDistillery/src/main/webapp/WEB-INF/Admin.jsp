<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Access</title>
<jsp:include page="bootstrapHead.jsp"/>
<%@ include file="nav.jsp"%>
</head>
<body>
<div class="container">
	<hr>
	<h4>Admin: ${sessionScope.admin.firstName}
		${sessionScope.admin.lastName}</h4>
	<hr>


	<div>
		<h4>User Accounts</h4>

		<form action="adminAccountInformation.do" method="GET"></form>



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

				<c:forEach var="user" items="${listUserAccounts}">

					<tr>


						<td>${user.id}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.active}</td>
						<td>${user.role}</td>


						<td><form action="changeUserRole.do" method="GET">
								<input type="text" hidden="true" value="${user.id}"
									name="userId" /> <input type="submit" value="Role">
							</form>

							
							<form action="deactivateUser.do" method="GET">
								<input type="text" hidden="true" value="${user.id}"
									name="userId" /> <input type="submit"
									value="Deactivate">
									</form></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	
	</div>
	<hr>
</div>
</body>
</html>