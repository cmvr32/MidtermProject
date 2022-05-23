<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Your Resume</title>
</head>
<body>

<h1>Update Your Resume</h1>
	<form action="updateResume.do" , method="post">
		<input type="hidden" name="contactInfo" value="" /> 
		<label for="contactInfo"> Contact Information </label>
		<br> 
		<input type="hidden" name="introduction" value="" /> 
		<label for="introduction"> About Me </label>
		<br> 
		<input type="hidden" name="experience" value="" /> 
		<label for="experience"> Experience </label>
		<br> 
		<input type="hidden" name="degree" value="" /> 
		<label for="degree"> Degree </label>
		<br> 
		<br> <br> <br>
		<input type="submit" />

	</form>

</body>
</html>