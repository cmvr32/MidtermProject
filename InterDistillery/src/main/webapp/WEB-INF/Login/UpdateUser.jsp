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

<h1>Update Account</h1>

<h3>${sessionScope.user.firstName} ${sessionScope.user.lastName}</h3>

<hr>


<h2> Account Information </h2>
<h3> Please select a field to update from the list below</h3>
	
	 <form action="UpdateUser.do" method="GET">
	<input type="hidden" name="id" value="${userUpdate.id}" /> 
		<input type="text" name="firstName" value="${userUpdate.firstName}" /> 
		<label for="fristName"> First Name </label>
		<br> 
		<input type="text" name="lastName" value="${userUpdate.lastName}" /> 
		<label for="lastName"> Last Name </label>
		<br> 
		<input type="text" name="email" value="${userUpdate.email}" /> 
		<label for="email"> Email </label>
		<br> 
		<input type="text" name="biography" value="${userUpdate.biography}" /> 
		<label for="biography"> Bio </label>
		<br>
		<input type="text" name="profileImageUrl" value="${userUpdate.profileImageUrl}" /> 
		<label for="profileImageUrl"> Profile Image UURL</label>
		<br> 
		<input type="hidden" name="username" value="${userUpdate.username}" /> 
		<input type="hidden" name="password" value="${userUpdate.password}" /> 
	<%-- 	<input type="hidden" name="role" value="${userUpdate.role}" /> 
		<input type="hidden" name="active" value="${userUpdate.active}" /> --%>
		<br> <br> <br>
		<input type="submit" />

	</form>
	<hr> 

</div>
</body>
</html>