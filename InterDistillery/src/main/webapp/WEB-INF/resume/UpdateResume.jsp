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



<h1>Update Your Resume</h1>
<h3> Displaying Resumes for:</h3>
<h3>${sessionScope.user.firstName} ${sessionScope.user.firstName}</h3>

<hr>


<h2> Resume Update Please select a resume from the list below to update</h2>
	
	 <form action="updateResume.do" method="GET">
	<input type="hidden" name="id" value="${editResume.id}" /> 
		<input type="text" name="contactInfo" value="${editResume.contactInfo}" /> 
		<label for="contactInfo"> Contact Information </label>
		<br> 
		<input type="text" name="introduction" value="${editResume.introduction}" /> 
		<label for="introduction"> About Me </label>
		<br> 
		<input type="text" name="experience" value="${editResume.experience}" /> 
		<label for="experience"> Experience </label>
		<br> 
		<input type="text" name="degree" value="${editResume.degree}" /> 
		<label for="degree"> Degree </label>
		<br> 
		<br> <br> <br>
		<input type="submit" />

	</form>
	<hr> 
	


</body>
</html>