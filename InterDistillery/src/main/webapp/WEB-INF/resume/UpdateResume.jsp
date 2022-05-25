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

<h1>Update Your Resume</h1>
	<form action="updateResume.do" , method="GET">
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
	
	
	<div>
		<h2>List Resumes</h2>
		<form action="ViewResume.do" method="GET">
		<input type="submit" value="Refresh Table">
		</form>
	<table>
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">contactInfo</th>
				<th scope="col">introduction</th>
				<th scope="col">experience</th>
				<th scope="col">degree</th>
				<td scope="col">user</td>
			
			</tr>
		</thead>
		
			<c:forEach var="userResume" items="${userResumes}"> 
			<tr>
			
			<td><a href="updateResume.do?id=${userResume.id}">${userResume.id}</a></td>
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