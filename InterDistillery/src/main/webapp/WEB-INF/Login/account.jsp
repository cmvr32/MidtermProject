<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Profile</title>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
</head>
<body>
<div class="container">
	<h2>User Profile</h2>
	
<ul>
<li>displace user info</li>
<li>displace user info</li>
<li>displace user info</li>
<li>displace user info</li>

<li> ability to edit user info</li>
<li> add profile picture </li>
</ul>

	<%-- Output user details --%>
	
	
	<form action="showUser.do" method="GET"></form>
	
		
		RESULT:	${sessionScope.user} 

	<c:choose>
		<c:when test="${not empty sessionScope.user}">
			<%-- <h6>Account ID: ${sessionScope.user.id}</h6>
			<h5>Username: ${sessionScope.user.username}</h5> --%>
			<p>
				<c:out value="${sessionScope.user.firstName }" />
				<c:out value="${sessionScope.user.lastName }" />
			</p>
				
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>
	
	
	<form action="showUser.do" method="POST">
	
		</form>
	
	<table>
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Username</th>
				<th scope="col">Biography</th>
				<th scope="col">dateCreated</th>
				<th scope="col">Account Status</th>
				<th scope="col">Account Permission Group</th>
				<th scope="col">Profile Image Url</th>
				<th scope="col">Banner Image Url</th>
				
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userInfo" items="${accountInfo}"> 
			<tr>
			
			<td><a href="showUser.do?id=${userInfo.id}">${userInfo.id}</a></td>
			<td>${userInfo.firstName}</td>
			<td>${userInfo.lastName}</td>
			<td>${userInfo.email}</td>
			<td>${userInfo.username}</td>
			<td>${userInfo.biography}</td>
			<td>${userInfo.password}</td>
			<td>${userInfo.dateCreated}</td>
			<td>${userInfo.active}</td>
			<td>${userInfo.role}</td>
			<td>${userInfo.profileImageUrl}</td>
			<td>${userInfo.bannerImageUrl}</td>

			</tr>
			</c:forEach>
			</tbody>
			</table>	
</div>	
</body>
</html>