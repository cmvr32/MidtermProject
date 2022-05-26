<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stretch Goal</title>
<jsp:include page="bootstrapHead.jsp"/>
<%@ include file="nav.jsp"%>
</head>
<body>
<div class="container">
<br><br>

<div class="card" style="width: 18rem;">
<img src="https://gifimage.net/wp-content/uploads/2018/04/page-loading-gif-9.gif" class="img-fluid rounded-start" alt="...">
<!--   <img src="..." class="card-img-top" alt="..."> -->
  <div class="card-body">
    <h5 class="card-title">Oops, Stretch Goal!</h5>
        <p class="card-text">Unfortunately we were unable to complete this function.</p>
    <a href="directToHomePage.do" class="btn btn-secondary">Better Luck Next Time</a>
  </div>
</div>


<!-- <div class="card mb-3" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="https://gifimage.net/wp-content/uploads/2018/04/page-loading-gif-9.gif" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">I was a Stretch Goal!</h5>
        <p class="card-text">We hope to come back to finish this function soon!</p>
      </div>
    </div>
  </div>
</div> -->
</div>
</body>
</html>