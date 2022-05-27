<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Let's Build Your Resume!</title>
</head>
<body>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
<div class="container">
<br>
<div class="col d-flex justify-content-center">
<div class="card text-center text-black bg-light mb-3" style="width: 18rem;">
<br>
<h4>Basic Resume Elements:</h4>

<form action="CreateResume.do" method="post">

	<label for="contactInfo">Contact Information</label><br>
	<input type="text" name="contactInfo" placeholder="Name, Email, Phone"></input> 
	<br><br>
	<label for="introduction">Introduction</label><br>
	<input type="text" name="introduction" placeholder="Get to know you"></input> 
	<br><br>
	<label for="experience">Experience</label><br>
	<input type="text" name="experience" placeholder="Relevent work experience"></input> 
	<br><br>
	<label for="education">Education</label><br>
	<input type="text" name="education" placeholder="Enter education"></input> 
	<br><br>
	<label for="skills">Professional Skills</label><br>
	<input type="text" name="skills" placeholder="Enter skills"></input> 
	<br><br>
	<label for="certs">Certificates/Awards</label><br>
	<input type="text" name="certs" placeholder="Enter Certifications/Awards"></input> 
	<br><br>
	<label for="certs">Additional Information</label><br>
	<!-- <label for="certs">Enter it here</label><br> -->
	<input type="text" name="info" placeholder="Share here"></input> 

	<br><br>
	<input type="submit"/> 
</form>
<br><br>
</div>
</div>
</div>
</body>
</html>