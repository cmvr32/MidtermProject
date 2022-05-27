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
        <p class="card-text">Begin with the basics. Pull together your relevant work experience to build a strong Resume.</p>
        <a href="directToAddResume.do" class="btn btn-secondary">Create</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">View Resumes</h5>
        <p class="card-text">View all your resume drafts, edit and delete as needed.</p>
        <a href="ViewResume.do" class="btn btn-secondary">View</a>
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
        <p class="card-text">Check out some additional resources to get you started.</p>
        <a href="#" class="btn btn-secondary">Explore</a>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>