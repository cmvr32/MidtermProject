<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<title>Log In</title>
	

</head>
<body>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
<h2>Log In</h2>
	<form action="login.do" method="POST">
	<label for="username">Username</label><br>
		<input type="text" name="username">
	<br><label for="password">Password</label><br>
		<input type="password" name="password"/><br>
		<br><input type="submit" value="Log In" > 
		
	<h5> Don't have an account? Click the button below!</h5>
	</form><form action="directToCreateUser.do"> <button>Create An Account</button></form>

	
</body>
</html>