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
<br>
	<h3>Account Information</h3>
	<br>
	<div class="row">
<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="${sessionScope.user.profileImageUrl}" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">${sessionScope.user.firstName} ${sessionScope.user.lastName}</h5>
    <p class="card-text">${sessionScope.user.biography}</p>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item">${sessionScope.user.email}</li>
    <li class="list-group-item">${sessionScope.user.role}</li>
    <li class="list-group-item">${sessionScope.user.active}</li>
  </ul>
  <div class="card-body">
  
  <p><form action="directToUpdateUser.do" method="GET">
				<input type="number" hidden="true" value="${userAccountInfo.id}" name="userId" id="id" /> 
				<input type="submit" value="Edit">
				</form><p>
				<p>	<form action="DeleteUser.do" method="POST">
				<input type="text" hidden="true" value="${userAccountInfo.id}" name="userId" id="id" /> 
				<input type="submit" value="Deactivate">

			</form>
			<p>
  </div>
</div>
<div class="card" style="width: 18rem;">
  <div class="card-header">
    Activity Log
  </div>
  <ul class="list-group list-group-flush">
    <li class="invalid nav-item"><a href="index.html">valid</a></li>
    <li class="list-group-item">View Your Resumes</li>
    <li class="list-group-item">View Your Mock Interviews</li>
    <li class="list-group-item">View Your Posts</li>
    <li class="list-group-item">View Your Study Guides</li>
    <li class="list-group-item">View Your Job Listings</li>
  </ul>
</div>
  </div>
			<br><br><br>
</div>
<%-- 
	
	<form action="showUser.do" method="GET"></form>
	
		<hr>
		RESULT:	${sessionScope.user} 
		<hr>

<h3>USER FIELDS:</h3>
	<c:choose>
	
	
		<c:when test="${not empty sessionScope.user}">
			<h6>Account ID: ${sessionScope.user.id}</h6>
			<h5>Username: ${sessionScope.user.username}</h5>
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
		
	${sessionScope.user.id}
	
	<form action="showUser.do" method="GET"></form>
	
	 --%>
	<%-- <h3>User Account Info</h3>
	${userAccountInfo}
	
	<h5>Update your account information</h5>
	<p><form action="directToUpdateUser.do" method="GET">
				<input type="number" hidden="true" value="${userAccountInfo.id}" name="userId" id="id" /> 
				<input type="submit" value="Edit Account">
				</form><p>

<h5>Delete your Account</h5>
			<p>	<form action="DeleteUser.do" method="POST">
				<input type="text" hidden="true" value="${userAccountInfo.id}" name="userId" id="id" /> 
				<input type="submit" value="Delete Account">

			</form>
			<p>
			
			
			</p>
				
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>

  </div>	 --%>



</body>
</html>