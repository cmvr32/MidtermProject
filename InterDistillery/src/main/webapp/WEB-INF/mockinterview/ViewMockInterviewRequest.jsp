<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Be prepared for the Interview!</title>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>

</head>
<body>
<div class="container">
<h1>View Scheduled Interview</h1>



<h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>
<div>
		<h2>Your Interviews</h2>
		<h5>Select a Interview to edit</h5>
		<form action="ViewMockInterviewRequest.do" method="GET">
		</form>
	
	<table>
		<thead>
			<tr>
				<th scope="col">Interview ID</th>
				<th scope="col">Interview Date</th>
				<th scope="col">Interview Time</th>
				<th scope="col">Topic</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userInterview" items="${interviews}"> 
			<tr>
			
			<td>${userInterview.id}</td>
			<td>${userInterview.interviewDate}</td>
			<td>${11:00 AM}</td>
			<td>${userInterview.topic}</td>
			<td>${userInterview.interviewee.firstName}</td>
			<td>${userInterview.interviewee.lastName}</td>
			<td>Request Pending</td>
			
			<td><form action="DeleteMockInterview.do" method="POST">
				<input type="text" hidden="true" value="${userInterview.id}" name="interviewId" /> 
				<input type="submit" value="delete">
				</form></td>
			
			</tr>
			</c:forEach>
			</tbody>
			</table>	




</div>
</body>
</html>