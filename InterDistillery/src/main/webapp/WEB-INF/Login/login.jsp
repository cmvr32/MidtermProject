<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
	<%@ include file="bootstrapHead.jsp"%>

</head>
<body>
<%--Edit the file nav.jsp to change nav links --%>
<%@ include file="nav.jsp" %>
<h2>Log In</h2>
<form action="login.do" method="POST">
	<%-- Error messages --%>
	<input type="text" name="userName">
	<input type="password" name="password"/>
	<input type="submit" value="Log In" > 
</form>
</body>
</html>