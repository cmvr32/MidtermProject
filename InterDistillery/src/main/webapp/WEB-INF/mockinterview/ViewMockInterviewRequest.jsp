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

<h1>Interview Resources</h1>

<br><form action="directToRequestMockInterview.do"><button>Schedule A Mock Interview</button></form>

<form action="directToEditMockInterview.do" >
	<input type="hidden" name="id" value="${mockinterview.id}"/>
	<button> Edit Interview appointment </button>
</form>
<br>
<form action="directToDeleteMockInterview.do" >
	<input type="hidden" name="id" value="${mockinterview.id}"/>
	<button> Delete Interview appointment </button>
</form> 
<br>

<br><form action=""><button>Example Interview Questions</button></form>

</body>
</html>