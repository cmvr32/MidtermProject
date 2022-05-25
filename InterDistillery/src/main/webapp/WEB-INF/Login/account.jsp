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
	<h2>User Profile</h2>
	
<ul>
<li>displace user info</li>
<li> ability to edit user info</li>
<li> add profile picture </li>
</ul>

	<%-- Output user details --%>

	<c:choose>
		<c:when test="${not empty sessionScope.loggedInUser }">
			<h6>Account ID: ${sessionScope.loggedInUser.userId}</h6>
			<h5>Username: ${sessionScope.loggedInUser.username}</h5>
			<p>
				<c:out value="${sessionScope.loggedInUser.firstName }" />
				<c:out value="${sessionScope.loggedInUser.lastName }" />
			</p>
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>
</body>
</html>