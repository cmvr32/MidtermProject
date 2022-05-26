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
<<<<<<< HEAD

<div class="container">
	<h2>User Profile</h2>

=======
<div class="container">
>>>>>>> a062bb178eb846c40673322ced0055b0b43d1d0f
	<h2>Welcome, ${sessionScope.user.firstName}</h2>

	
<ul>
<li>${sessionScope.user.firstName}</li>
<li>${sessionScope.user.lastName}</li>
<li>${sessionScope.user.email}</li>
<li>${sessionScope.user.biography}</li>
<li>${sessionScope.user.dateCreated}</li>


</ul>

	<%-- Output user details --%>
	
	
	<form action="showUser.do" method="GET"></form>
	
		<hr>
		RESULT:	${sessionScope.user} 
		<hr>

<h3>USER FIELDS:</h3>
	<c:choose>
	
	
		<c:when test="${not empty sessionScope.user}">
			<%-- <h6>Account ID: ${sessionScope.user.id}</h6>
			<h5>Username: ${sessionScope.user.username}</h5> --%>
			<p>
				<c:out value="${sessionScope.user.firstName }" />
				<c:out value="${sessionScope.user.lastName }" />
				<c:out value="${sessionScope.user.email}"/>
				<c:out value="${sessionScope.user.biography}"/>
				<c:out value="${sessionScope.user.dateCreated}"/>
				<c:out value="${sessionScope.user.role}"/>
				<c:out value="${sessionScope.user.active}"/>
				<c:out value="${sessionScope.user.username}"/>
				<c:out value="${sessionScope.user.password}"/>
				<c:out value="${sessionScope.user.profileImageUrl}"/>		
			</p>
				
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>
	
	<form action="directToUpdateResume.do" method="GET">
				<input type="text" hidden="true" value="${user.id}" name="userId" /> 
				<input type="submit" value="edit">
				</form>
<<<<<<< HEAD

				<form action="deleteResume.do" method="POST">
				<input type="text" hidden="true" value="${user.id}" name="userId" /> 
				<input type="submit" value="delete">
				</form>
</div>
=======
				
				<form action="deleteResume.do" method="POST">
				<input type="text" hidden="true" value="${user.id}" name="userId" /> 
				<input type="submit" value="delete">
				</form></td>
  </div>	
>>>>>>> a062bb178eb846c40673322ced0055b0b43d1d0f
</body>
</html>