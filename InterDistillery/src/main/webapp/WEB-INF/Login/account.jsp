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
				<p>	<form action="deactivateUser.do" method="POST">
				<input type="text" hidden="true" value="${userAccountInfo.id}" name="userId" id="id" /> 
				<input type="submit" value="Deactivate">

			</form>
			<p>
  </div>
</div>
  </div>
  <c:choose>
	  <c:when test="${not empty sessionScope.admin}">
	  
	    <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Manage Users</h5>
        <p class="card-text">View all active users.</p>
        <a href="adminAccountInformation.do" class="btn btn-secondary">Explore</a>
      </div>
    </div>
  </div>
	</c:when>
	</c:choose>  
			<br><br><br>
</div>


</body>
</html>