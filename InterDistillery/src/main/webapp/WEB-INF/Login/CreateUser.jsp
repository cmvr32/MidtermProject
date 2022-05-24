<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<H1>Create an Account</H1>

<form action="createResume.do" method="post">

	<label for="contactInfo">First Name</label><br>
	<input type="text" name="firstName" placeholder="first name"></input> 
	<br><br>
	<label for="introduction">Last Name</label><br>
	<input type="text" name="lastName" placeholder="last name"></input> 
	<br><br>
	<label for="experience">Email</label><br>
	<input type="text" name="email" placeholder="email"></input> 
	<br><br>
	<label for="degree">Create a user name</label><br>
	<input type="text" name="username" placeholder="user name"></input> 
	<br><br>
	<label for="degree">Create a password</label><br>
	<input type="text" name="password" placeholder="password"></input> 
	<br><br>
	<input type="submit"/>
</form>
</form><form action="directToHomePage.do"><button>Return Home</button></form>


</body>
</html>