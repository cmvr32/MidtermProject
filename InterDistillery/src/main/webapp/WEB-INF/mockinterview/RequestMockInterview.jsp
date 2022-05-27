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

${sessionScope.user}

<form action="RequestMockInterview.do" method="GET">

	<label for="interviewDate">Appointment Date</label><br>
	<input type="date" id="interviewDate" name="interviewDate" id=data-role="calendarpicker" value="2022/05/26" data-format="%d %b %Y">
	<br><br>
	<label for="interviewTime">Appointment Time </label><br>
	<input type="time"  id="interviewTime"  name="interviewTime"></input> 
	<br><br>
	<label for="name">Name</label><br>
	<input type="text" id="name"  name="name" placeholder="Enter your name"></input> 
	<br><br>
	<label for="topic">Enter career and job title</label><br>
	<label for="topic">Software Development, Java Programmer</label><br>
	<input type="text" id="topic"  name="topic" placeholder="Software Development, Java Programmer"></input> 
	<br><br>
	<label for="interviewType">What kind of interview are you looking for?</label><br>
	<label for="interviewType">Professional, Technical, Lunch, Phone, etc</label><br>
	<input type="text"  id="interviewType" name="interviewType" placeholder="Enter Topic"></input> 
	<br><br>
	<label for="interviewLevel">Interview level</label><br>
	<label for="interviewLevel">How do you feel about interviews, interview skills, and presentation?</label><br>
	<input type="text"  id="interviewLevel" name="interviewLevel" placeholder="Interview level"></input> 
	<br><br>
	<label for="other">"Enter any information you think pertains to your interview request</label><br>
	<input type="text"  id="other" name="other" placeholder="Other Info"></input> 
	<br><br>
	<label for="Submit request">Click Submit to post interview request</label>
	<input type="submit"/>
	</form>

</div>
</body>
</html>