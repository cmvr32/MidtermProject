<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Resume</title>
</head>
<body>
<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
<div class="container">
<h1>Your resume has been deleted</h1>
<h3>${sessionScope.user.firstName} ${sessionScope.user.firstName}</h3>

<form action="index.do" >
	<button> Return To Home Page </button>
</form>

</div>
</body>
</html>