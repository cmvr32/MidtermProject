<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-expand-lg bg-light" style="background-color:#0dcaf0;">
<div class="container">
<a href="directToHomePage.do"><img src="../images/Logo.png" alt="" width="60" height="60"/></a>
	
	<c:choose>
	  <c:when test="${not empty sessionScope.user }">
	    <a class="navbar-brand" style='color:grey' href="directToResumeResources.do">Resume</a>
	    <a class="navbar-brand" style='color:grey' href="directToMockInterviewResources.do">Interviews</a>
	    <a class="navbar-brand" style='color:grey' href="directToStretchGoalMessage.do">Discussions</a>
	    <a class="navbar-brand" style='color:grey' href="directToStretchGoalMessage.do">Study</a>
	    <a class="navbar-brand" style='color:grey' href="directToStretchGoalMessage.do">Jobs</a>
	    <a class="navbar-brand" style='color:grey' href="directToAccount.do">Account</a>
	    <a class="navbar-brand" style='color:grey' href="logout.do">Log Out</a>
	  </c:when>
	  <c:otherwise>
	    <a class="navbar-brand" style='color:grey' href="directToLogin.do">Log In</a>
	    <a class="navbar-brand" style='color:grey' href="directToCreateUser.do">Register</a>
	<form class="d-flex">
      <input class="form-control me-2" type="search" placeholder="Don't even try!" aria-label="Search">
      <button class="btn btn-outline-secondary" type="submit">Search</button>
    </form>
	  </c:otherwise>
	</c:choose>
	
	
	</div>
</nav>