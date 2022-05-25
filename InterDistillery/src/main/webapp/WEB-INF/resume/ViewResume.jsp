<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Resume</title>
</head>
<body>
<form action="directToHomePage.do"><button>Return Home</button></form>
<br><form action="directToAddResume.do"><button>Build a Resume</button></form>
<h1>Your Resume</h1>

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
<form action="homePage.do" >
	<button> Return To Home Page </button>
</form><br>

</body>
</html>