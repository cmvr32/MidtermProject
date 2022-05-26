<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>InterDistillery</title>
<jsp:include page="bootstrapHead.jsp"/>
<%@ include file="nav.jsp"%>
</head>
<body>
<br><br>
<div class="container">
	<c:choose>
	  <c:when test="${empty sessionScope.user }">
	<div class="container max-height d-flex align-tiems-center">
	<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
    <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" class="active" aria-current="true" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" class="active" aria-current="true" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="3" class="active" aria-current="true" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="4" class="active" aria-current="true" aria-label="Slide 5"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="5" class="active" aria-current="true" aria-label="Slide 6"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="6" class="active" aria-current="true" aria-label="Slide 7"></button>
  </div>
  <div class="carousel-inner">
 <div class="carousel-item active" data-bs-interval="2000">
      <img src="../images/LogoC.png" class="d-sm-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
      </div>
    </div>
    <div class="carousel-item active" data-bs-interval="2000">
      <img src="../images/ResumeC.png" class="d-sm-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Resume Support</h5>
        <p>Get access to the resources you need to build a powerful resume.</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../images/InterviewC.png" class="d-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Interview Preparation</h5>
        <p>Participate in mock interviews and improve your skills.</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../images/DiscussionC.png" class="d-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Discussion Board</h5>
        <p>Connect with peers, ask questions and seek advice.</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../images/StudyC.png" class="d-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Study Materials</h5>
        <p>The best way to prepare for an interview is to keep coding!</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../images/JobC.png" class="d-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Job Listings</h5>
        <p>Post and view job listings with the online community.</p>
      </div>
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="../images/SDC.png" class="d-block w-100 h-100" alt="...">
      <div class="carousel-caption d-none d-md-block" style='color:black'>
        <h5>Get Skilled!</h5>
        <p>Checkout Skill Distillery and apply for the next cohort today.</p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>
  </c:when>
	  <c:otherwise>
<div class="row">
            <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/ResumeStock.png" alt="">
                   <div class="card-body">
                    <h5 class="card-title">Resume Support</h5>
                    <p class="card-text"> Get access to the resources you need to build a powerful resume.</p>
                    <a href="directToResumeResources.do" class="btn btn-secondary">Explore</a>
                   </div>
                </div>
            </div>
            <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/InterviewStock.png" alt="">
                    <div class="card-body">
                     <h5 class="card-title">Interview Support</h5>
                     <p class="card-text">Participate in mock interviews and improve your skills.</p>
 					 <a href="directToMockInterviewResources.do" class="btn btn-secondary">Explore</a>
                    </div>
                </div>
            </div>
                <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/DiscussionBoardStock.png" alt="">
                    <div class="card-body">
                     <h5 class="card-title">Discussion Board</h5>
                     <p class="card-text">Connect with peers, ask questions and seek advice. </p>
 					 <a href="directToStretchGoalMessage.do" class="btn btn-secondary">Explore</a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/StudyStock.png" alt="">
                   <div class="card-body">
                    <h5 class="card-title">Study Materials</h5>
                    <p class="card-text">The best way to prepare for an interview is to keep coding!</p>
                    <a href="directToStretchGoalMessage.do" class="btn btn-secondary">Explore</a>
                   </div>
                </div>
            </div>
            <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/JobPostStock.png" alt="">
                    <div class="card-body">
                     <h5 class="card-title">Job Listings</h5>
                     <p class="card-text">Post and view job listings with the online community.</p>
 					 <a href="directToStretchGoalMessage.do" class="btn btn-secondary">Explore</a>
                    </div>
                </div>
            </div>
                        <div class="col-lg-4 mb-2">
                <div class="card"style="width: 18rem;">
                    <img class="card-img-top" src="../images/SDStock.png" alt="">
                    <div class="card-body">
                     <h5 class="card-title">Get Skilled!</h5>
                     <p class="card-text"> Checkout Skill Distillery and apply for the next cohort today.</p>
 					 <a href="https://skilldistillery.com/" class="btn btn-secondary">Explore</a>
                    </div>
                </div>
            </div>
        </div>
          </c:otherwise>
	</c:choose>
</div>	
</body>
</html>