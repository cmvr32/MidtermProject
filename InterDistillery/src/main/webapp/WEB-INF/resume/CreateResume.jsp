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
<br><br>
<h6>Enter Your Basic Resume elements:</h6>

<form action="CreateResume.do" method="post">

	<label for="contactInfo">Contact Information</label><br>
	<input type="text" name="contactInfo" placeholder="Name, Email, Phone"></input> 
	<br><br>
	<label for="introduction">Bio</label><br>
	<input type="text" name="introduction" placeholder="Get to know you"></input> 
	<br><br>
	<label for="experience">Experience</label><br>
	<input type="text" name="experience" placeholder="Relevent work experience"></input> 
	<br><br>
	<input type="text" name="degree" list="degreeoptions">
    <datalist id="degree">
      <option value="Assosiates">
      <option value="Bachelors">
      <option value="Masters">
      <option value="Doctorate">
      <option value="Certificate">
    </datalist>


<!-- 	<label for="degree">Degree</label><br>
	<input type="text" name="degree" placeholder="Degree"></input> 
	<br><br>
	<input type="submit"/> -->
</form>
<br><br>
</div>
</div>
</div>
</body>
</html>