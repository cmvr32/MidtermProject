<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Your Resume</title>
</head>
<body>
<form action="directToHomePage.do"><button>Return Home</button></form>
<br><form action="directToAddResume.do"><button>Build a Resume</button></form>
	<div>
		<h2>Your Resumes</h2>
		<h5>Select a resume to edit.</h5>
		<form action="ViewResume.do" method="GET">
		<!-- <input type="submit" value="Refresh Table"> -->
		</form>
	<table>
		<thead>
			<tr>
				<th scope="col">Resume ID</th>
				<th scope="col">Contact Information</th>
				<th scope="col">Introduction</th>
				<th scope="col">Experience</th>
				<th scope="col">Degree</th>
				<th scope="col">User</th>
			
			</tr>
		</thead>
		
			<c:forEach var="userResume" items="${userResumes}"> 
			<tr>
			
			<td>${userResume.id}</td>
			<td>${userResume.contactInfo}</td>
			<td>${userResume.introduction}</td>
			<td>${userResume.experience}</td>
			<td>${userResume.degree}</td>
			<td>${userResume.user}</td>
			
			</tr>
			</c:forEach>
			</table>	
	</div>
	<hr>


</body>
</html>