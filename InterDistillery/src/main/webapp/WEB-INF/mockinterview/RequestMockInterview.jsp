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
<h1>Schedule a Mock Interview</h1>
<h5> get comfortable in the hot seat be sure the study the interview questions!</h5>

<form action="RequestMockInterview.do" method="GET">

	<label for="Appointment Date">Appointment Date</label><br>
	<input type="text" data-role="calendarpicker" value="2022/05/26" data-format="%d %b %Y">
	<br><br>
	<label for="Appointment Time">Appointment Time </label><br>
	<input type="time" name="Appointment Time"></input> 
	<br><br>
	<label for="Name">Name</label><br>
	<input type="text" name="Name" placeholder="Enter your name"></input> 
	<br><br>
	<label for="Career Field">Enter career and job title</label><br>
	<label for="Career Field">Software Development, Java Programmer</label><br>
	<input type="text" name="topic" placeholder="Software Development, Java Programmer"></input> 
	<br><br>
	<label for="Interview Topic">What kind of interview are you looking for?</label><br>
	<label for="Interview Topic">Professional, Technical, Lunch, Phone, etc</label><br>
	<input type="text" name="topic" placeholder="Enter Topic"></input> 
	<br><br>
	<label for="Interview Confidence">Interview level</label><br>
	<label for="Interview Confidence">How do you feel about interviews, interview skills, and presentation?</label><br>
	<input type="text" name="Interview Confidence" placeholder="Interview level"></input> 
	<br><br>
	<label for="Additional Infomation">"Enter any information you think pertains to your interview request</label><br>
	<input type="text" name="Additional Information" placeholder="Other Info"></input> 
	<br><br>
	<label for="Submit request">Click Submit to post interview request</label>
	<input type="submit"/>
	</form>

</div>
</body>
</html>