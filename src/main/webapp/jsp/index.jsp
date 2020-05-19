<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <h2><spring:message code="slide_1_title"/></h2>
                <h4><spring:message code="slide_1_content"/></h4>
                <img class="slide-img" src="${pageContext.request.contextPath}/img/bg-img/device.png" alt="">
            </div>
        </div>
        <!-- Single Hero Slides -->
        <div class="single-hero-slide d-flex align-items-end justify-content-center">
            <div class="hero-slide-content text-center">
                <h2><spring:message code="slide_2_title"/></h2>
                <h4><spring:message code="slide_2_content"/></h4>
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
                    <h2><spring:message code="info_about_faculty_title"/></h2>
                </div>
                <div class="features-content">
                    <p><spring:message code="info_about_faculty_content"/></p>
                    <!-- Progress Bar Content Area -->
                    <div class="features-progress-bar mt-50">
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.2s">
                            <p><spring:message code="info_about_faculty_point_1"/></p>
                            <div id="bar1" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="90"></span>
                            </div>
                        </div>
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.4s">
                            <p><spring:message code="info_about_faculty_point_2"/></p>
                            <div id="bar2" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="70"></span>
                            </div>
                        </div>
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar mb-15 wow fadeInUp" data-wow-delay="0.6s">
                            <p><spring:message code="info_about_faculty_point_3"/></p>
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
            <h4><spring:message code="features_1_title"/></h4>
            <p><spring:message code="features_1_content"/></p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay=".4s">
            <img src="${pageContext.request.contextPath}/img/core-img/edit.png" alt="">
            <h4><spring:message code="features_2_title"/></h4>
            <p><spring:message code="features_2_content"/></p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay=".7s">
            <img src="${pageContext.request.contextPath}/img/core-img/video-camera.png" alt="">
            <h4><spring:message code="features_3_title"/></h4>
            <p><spring:message code="features_3_content"/></p>
        </div>
    </div>
    <div class="single-more-service-area">
        <div class="more-service-content text-center wow fadeInUp" data-wow-delay="1s">
            <img src="${pageContext.request.contextPath}/img/core-img/presentation.png" alt="">
            <h4><spring:message code="features_4_title"/></h4>
            <p><spring:message code="features_4_content"/></p>
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