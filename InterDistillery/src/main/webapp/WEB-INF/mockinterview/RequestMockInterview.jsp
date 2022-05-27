<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
</head>
<body>
<div class="container">
<br>
<div class="col d-flex justify-content-center">
<div class="card text-center text-black bg-light mb-3" style="width: 18rem;">
<br>
<h2>Schedule a Mock Interview</h2>
<br>
<form action="RequestMockInterview.do" method="GET">

	<label for="interviewDate">Appointment Date</label><br>
	<input type="date" id="interviewDate" name="interviewDate" id=data-role="calendarpicker" value="2022/05/26" data-format="%d %b %Y">
	<br><br>
	<label for="interviewTime">Appointment Time </label><br>
	<input type="time"  id="interviewTime"  name="interviewTime"></input> 
	<br><br>
	<label for="name">Full Name</label><br>
	<input type="text" id="name"  name="name" placeholder="Enter your name"></input> 
	<br><br>
	<label for="topic">Career Field and Job Title</label><br>
	<!-- <label for="topic">Software Development, Java Programmer</label><br> -->
	<input type="text" id="topic"  name="topic" placeholder="Software Development, Java Programmer"></input> 
	<br><br>
	<label for="interviewType">Interview Focus</label><br>
	<!-- <label for="interviewType">Professional, Technical, Lunch, Phone, etc</label><br> -->
	<input type="text"  id="interviewType" name="interviewType" placeholder="General, Technical, etc."></input> 
	<br><br>
	<label for="interviewLevel">Interview Level</label><br>
<!-- 	<label for="interviewLevel">How do you feel about interviews, interview skills, and presentation?</label><br> -->
	<input type="text"  id="interviewLevel" name="interviewLevel" placeholder="entry-level, mid-level, late-career"></input> 
	<br><br>
	<label for="other">Additional Information</label><br>
	<input type="text"  id="other" name="other" placeholder="Other Info"></input> 
	<br><br>
	<label for="Submit request"></label>
	<input type="submit"/>
	</form>
	<br><br>

</div>
</div>
</div>
<br><br>
</body>
</html>