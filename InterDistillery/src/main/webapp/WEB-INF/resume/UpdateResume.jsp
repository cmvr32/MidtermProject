<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Your Resume</title>

<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>


</head>
<body>
<div>
<h1>Update Your Resume</h1>
<h3> Displaying Resumes for:</h3>
<h3>${sessionScope.user.firstName} ${sessionScope.user.firstName}</h3>
</div>
<hr>

<div>
<h2> Resume Update Please select a resume from the list below to update</h2>
	<%-- <form action="updateResume.do" , method="GET">
	<input type="hidden" name="id" value="${resume}" /> 
		<input type="hidden" name="contactInfo" value="${resume.contactInfo}" /> 
		<label for="contactInfo"> Contact Information </label>
		<br> 
		<input type="hidden" name="introduction" value="${resume.introduction}" /> 
		<label for="introduction"> About Me </label>
		<br> 
		<input type="hidden" name="experience" value="${resume.experience}" /> 
		<label for="experience"> Experience </label>
		<br> 
		<input type="hidden" name="degree" value="${resume.degree}" /> 
		<label for="degree"> Degree </label>
		<br> 
		<br> <br> <br>
		<input type="submit" />

	</form>
	<hr> --%>
	



		<h2>Your Resumes</h2>
		<h5>Select a resume to edit.</h5>
		<form action="ViewResume.do" method="GET">
		 <input type="submit" value="Refresh Tab">
		</form>
	<table>
		<thead>
			<tr>
				<th scope="col"> Name</th>
				<th scope="col">Resume ID</th>
				<th scope="col">Contact Information</th>
				<th scope="col">Introduction</th>
				<th scope="col">Experience</th>
				<th scope="col">Degree</th>
				<th scope="col">resumeEducationLevel</th>
				<th scope="col">Job Skills</th>
				<th scope="col">User</th>
			
			</tr>
		</thead>
		
			<c:forEach var="userResume" items="${userResumes}"> 
			<tr>
			
			<td><a href="updateResume.do?id=${userResume.id}">${userResume.id}</a></td>
			<td>${sessionScope.user.firstName} ${sessionScope.user.lastName}</td>
			<td>${userResume.contactInfo}</td>
			<td>${userResume.introduction}</td>
			<td>${userResume.experience}</td>
			<td>${userResume.degree}</td>
			<td>${userResume.user}</td>
			
			
			<td>
				
				<form action="directToAddResume.do"><button>Build a Resume</button></form>
			
				<td><form action="updateResume.do" method="GET">
				<input type="text" hidden="true" value="${userResume.id}" name="updateResume" /> 
				<input type="submit" value="edit">
				</form>
				
				<form action="deleteFilm.do" method="POST">
				<input type="text" hidden="true" value="${userResume.id }" name="deleteResume" /> 
				<input type="submit" value="delete">
				</form></td>
		</tr>
			
			</tr>
			</c:forEach>
			</table>	
	</div>
	<hr>
<form action="directToHomePage.do"><button>Return Home</button></form>
<br><form action="directToAddResume.do"><button>Build a Resume</button></form>


</body>
</html>