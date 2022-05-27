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

<h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}'s Interviews</h3>
<br><br>
<div>

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
				<th scope="col">Interview Status</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach var="userInterview" items="${interviews}"> 
			<tr>
			
			<td>${userInterview.id}</td>
			<td>${userInterview.interviewDate}</td>
			<td>11:00 AM</td>
			<td>${userInterview.topic}</td>
			<td>${userInterview.interviewee.firstName}</td>
			<td>${userInterview.interviewee.lastName}</td>
			<td>Request Pending</td>
			
			<td><form action="DeleteMockInterview.do" method="POST">
				<input type="text" hidden="true" value="${userInterview.id}" name="interviewId" /> 
				<input type="submit" value="Cancel">
				</form></td>
			
			</tr>
			</c:forEach>
			</tbody>
			</table>	




</div>
</body>
</html>