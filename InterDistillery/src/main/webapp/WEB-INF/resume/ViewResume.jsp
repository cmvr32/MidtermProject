<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Resume</title>

<jsp:include page="../bootstrapHead.jsp"/>
<%@ include file="../nav.jsp"%>
</head>
<body>

<h1>Resume Resources</h1>

<br><form action="directToAddResume.do"><button>Build a Resume</button></form>

<form action="directToUpdateResume.do" >
	<input type="hidden" name="id" value="${resume.id}"/>
	<button> Edit Resume </button>
</form>
<br>
<form action="directToDeleteResume.do" >
	<input type="hidden" name="id" value="${resume.id}"/>
	<button> Delete Resume </button>
</form> 
<br>

<br><form action=""><button>Example Resumes</button></form>

</body>
</html>