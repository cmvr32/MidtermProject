<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Your Resume</title>

<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
</head>
<body>
<div class="container">
<h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>
<div>
		<h2>Your Resumes</h2>
		<h5>Select a resume to edit.</h5>
		<form action="ViewResume.do" method="GET"></form>
</div>	

<div>
	<table bgolor="black" width="700">
    	
      <thead>
        	<tr bgcolor="lightgrey">
				<th colspan="1" width="100">Resume ID</th>
				<th  colspan="2" width="100">Name</th>
				<th  colspan="1" width="100">Contact Information</th>
				<th  colspan="1" width="100">Introduction</th>
				<th  colspan="1" width="100">Experience</th>
				<th  colspan="1" width="100">Education</th>
				<th  colspan="1" width="100">Skills</th>
				<th  colspan="1" width="100">Edit</th>
				<th  colspan="1" width="100">Delete</th>
				
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userResume" items="${userResumes}"> 
		
			<tr bgcolor="lightgrey" align="center">
			<td>${userResume.id}</td>
			<td>${sessionScope.user.firstName}</td>
			<td>${sessionScope.user.lastName}</td>
			<td>${userResume.contactInfo}</td>
			<td>${userResume.introduction}</td>
			<td>${userResume.experience}</td>
			<td>Bachelors, Coding Bootcamp Certificate</td>
			<td>Java SQL Spring JPA Bootstrap Git</td>
			
			
				<td><form action="directToUpdateResume.do" method="GET">
				<input type="text" hidden="true" value="${userResume.id}" name="resumeId" /> 
				<input type="submit" value="Edit">
				</form></td>
				
				<td><form action="deleteResume.do" method="POST">
				<input type="text" hidden="true" value="${userResume.id}" name="resumeId" /> 
				<input type="submit" value="Delete">
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