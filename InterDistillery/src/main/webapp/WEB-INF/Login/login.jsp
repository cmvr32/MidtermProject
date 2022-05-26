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
<br><br><br>
<div class="col d-flex justify-content-center">
<div class="card text-center text-black bg-light mb-3" style="width: 18rem;">
<br>
<h2>Log In</h2>
	<form action="login.do" method="POST">
	<label for="username">Username</label><br>
		<input type="text" name="username">
	<br><label for="password">Password</label><br>
		<input type="password" name="password"/><br>
		<br><input type="submit" value="Log In" >
	</form> 
	<br>
	</div>
</div>	
</body>
</html>