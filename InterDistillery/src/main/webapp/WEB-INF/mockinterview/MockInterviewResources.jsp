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
<div class="container">
<br><br>
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Schedule a Mock Interview</h5>
        <p class="card-text">Request a Mock Interview to strengthen your skills and receive feedback from peers.</p>
        <a href="directToRequestMockInterview.do" class="btn btn-secondary">Schedule</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">View Mock Interviews</h5>
        <p class="card-text">View your scheduled interviews and cancel if necessary, to reschedule simply submit a new request.</p>
        <a href="ViewMockInterviewRequest.do" class="btn btn-secondary">View</a>
      </div>
    </div>
  </div>
</div>
<br><br>
</div>
</body>
</html>