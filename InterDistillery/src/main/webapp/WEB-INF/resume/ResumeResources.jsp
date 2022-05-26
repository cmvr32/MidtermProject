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
<div class="container">
<br><br>
<div class="row">
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Create a Resume</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="directToAddResume.do" class="btn btn-secondary">Go somewhere</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">View Resumes</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="ViewResume.do" class="btn btn-secondary">Go somewhere</a>
      </div>
    </div>
  </div>
</div>
<br>
<div class="row">
<div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Resume Examples</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-secondary">Go somewhere</a>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>