<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-expand-lg bg-light">
<div class="container">
	<a class="navbar-brand" href="directToHomePage.do">InterDistillery</a>
		<img src="/docs/5.0/assets/brand/bootstrap-logo.svg" 
		alt=""
		width="30"
		height="24"/>
	<c:choose>
	  <c:when test="${not empty sessionScope.user }">
	    <a href="directToResumeResources.do" class="btn btn-success">Resume Resources </a>
	    <a href="directToMockInterviewResources.do" class="btn btn-success">Interview Preparation</a>
	    <a href="directToAccount.do" class="btn btn-success">Account</a>
	    <a href="logout.do" class="btn btn-primary">Log Out</a>
	  </c:when>
	  <c:otherwise>
	    <a href="directToLogin.do" class="btn btn-primary">Log In</a>
	    <a href="directToCreateUser.do" class="btn btn-primary">Register</a>
	  </c:otherwise>
	</c:choose>
	</div>
</nav>