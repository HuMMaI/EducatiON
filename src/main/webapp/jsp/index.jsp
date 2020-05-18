<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>

<div id="preloader">
    <div class="mosh-preloader"></div>
</div>

<jsp:include page="header.jsp"></jsp:include>

<section class="welcome_area clearfix" id="home" style="background-image: url(${pageContext.request.contextPath}/img/bg-img/welcome-bg.png)">
    <div class="hero-slides owl-carousel">
        <!-- Single Hero Slides -->
        <div class="single-hero-slide d-flex align-items-end justify-content-center">
            <div class="hero-slide-content text-center">
                <h2>Good IT faculties</h2>
                <h4>Start logging into IT now!</h4>
                <img class="slide-img" src="${pageContext.request.contextPath}/img/bg-img/device.png" alt="">
            </div>
        </div>
        <!-- Single Hero Slides -->
        <div class="single-hero-slide d-flex align-items-end justify-content-center">
            <div class="hero-slide-content text-center">
                <h2>The best humanities faculties</h2>
                <h4>Start to study in the humanitarian direction!</h4>
                <img class="slide-img" src="${pageContext.request.contextPath}/img/bg-img/books.png" alt="">
            </div>
        </div>
    </div>
</section>

<section class="mosh-features-area section_padding_100 clearfix">
    <div class="container">
        <div class="row justify-content-end">
            <div class="col-12 col-md-6">
                <div class="section-heading">
                    <p>future</p>
                    <h2>Why our university?</h2>
                </div>
                <div class="features-content">
                    <p>Our university has a very strong education system. All professors can help you with problems and indicate the right direction in training. If you want to become a good specialist, we will be waiting for you.</p>
                    <!-- Progress Bar Content Area -->
                    <div class="features-progress-bar mt-50">
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.2s">
                            <p>IT</p>
                            <div id="bar1" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="90"></span>
                            </div>
                        </div>
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.4s">
                            <p>Law</p>
                            <div id="bar2" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="70"></span>
                            </div>
                        </div>
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.6s">
                            <p>Management</p>
                            <div id="bar3" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="75"></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Feature Thumb -->
    <div class="features-img">
        <img src="${pageContext.request.contextPath}/img/core-img/features.png" alt="">
    </div>
</section>

<section class="mosh-more-services-area d-sm-flex clearfix">
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay=".1s">
            <img src="${pageContext.request.contextPath}/img/core-img/trophy.png" alt="">
            <h4>No1 in IT!</h4>
            <p>More practice, less theory!</p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay=".4s">
            <img src="${pageContext.request.contextPath}/img/core-img/edit.png" alt="">
            <h4>Tests</h4>
            <p>Every month verification test.</p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay=".7s">
            <img src="${pageContext.request.contextPath}/img/core-img/video-camera.png" alt="">
            <h4>Record</h4>
            <p>Each lecture will be recorded and available to you.</p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay="1s">
            <img src="${pageContext.request.contextPath}/img/core-img/presentation.png" alt="">
            <h4>Project</h4>
            <p>Each student will develop his own project.</p>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/plugin.js"></script>
<script src="${pageContext.request.contextPath}/js/wow.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.barfiller.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
</body>
</html>