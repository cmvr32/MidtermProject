<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
<br>
<br>
<div class="col d-flex justify-content-center">
<div class="card text-center text-black bg-light mb-3" style="width: 18rem;">
<br><br>
<H5>Create an Account</H5>

<form action="CreateUser.do" method="post">

	<label for="contactInfo">First Name</label><br>
	<input type="text" name="firstName" placeholder="first name"></input> 
	<br>
	<label for="introduction">Last Name</label><br>
	<input type="text" name="lastName" placeholder="last name"></input> 
	<br>
	<label for="experience">Email</label><br>
	<input type="text" name="email" placeholder="email"></input> 
	<br>
	<label for="degree">Create a user name</label><br>
	<input type="text" name="username" placeholder="user name"></input> 
	<br>
	<label for="degree">Create a password</label><br>
	<input type="password" name="password" placeholder="password"></input> 
	<br><br>
	<input type="submit"/>
	<br><br><br>
</form>
<br><br><br>

</div>
<br><br>
</div>
</body>
</html>