<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Let's Build Your Resume!</title>
</head>
<body>

<h1>Let's Build Your Resume!</h1>

<form action="createResume.do" method="post">

	<label for="contactInfo">Contact Information</label><br>
	<input type="text" name="contactInfo" placeholder="Name, Email, Phone"></input> 
	<br><br>
	<label for="introduction">About Me</label><br>
	<input type="text" name="introduction" placeholder="Share a bit about yourself"></input> 
	<br><br>
	<label for="experience">Experience</label><br>
	<input type="text" name="experience" placeholder="List relevent work experience"></input> 
	<br><br>
	<label for="degree">Degree</label><br>
	<input type="text" name="degree" placeholder="Degree"></input> 
	<br><br>
	<input type="submit"/>
	
</form>
	
</body>
</html>