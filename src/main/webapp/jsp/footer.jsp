<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">

    <title>Hello, world!</title>
</head>
<body>

<footer class="footer-area clearfix">
    <!-- Top Fotter Area -->
    <div class="top-footer-area section_padding_100_0">
        <div class="container">
            <div class="row">
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-footer-widget mb-100">
                        <a href="#" class="mb-50 d-block"><img src="${pageContext.request.contextPath}/img/core-img/education_logo.png" alt="education logo"></a>
                        <p><spring:message code="footer_content"/></p>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-footer-widget mb-100">
                        <h5>Fast links</h5>
                        <ul>
                            <li><a href="/"><spring:message code="home_menu"/></a></li>
                            <li><a href="/faculty"><spring:message code="faculties_menu"/></a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
<%--                    <div class="single-footer-widget mb-100">--%>
<%--                        <h5>News</h5>--%>
<%--                        <div class="footer-single--blog-post">--%>
<%--                            <a href="#" class="blog-post-date">--%>
<%--                                <p>23 September, 2017</p>--%>
<%--                            </a>--%>
<%--                            <a href="#" class="blog-post-title">--%>
<%--                                <h6>Why we love stock photos</h6>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="footer-single--blog-post">--%>
<%--                            <a href="#" class="blog-post-date">--%>
<%--                                <p>22 September, 2017</p>--%>
<%--                            </a>--%>
<%--                            <a href="#" class="blog-post-title">--%>
<%--                                <h6>Designin on grid. A few rules. </h6>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="footer-single--blog-post">--%>
<%--                            <a href="#" class="blog-post-date">--%>
<%--                                <p>20 September, 2017</p>--%>
<%--                            </a>--%>
<%--                            <a href="#" class="blog-post-title">--%>
<%--                                <h6>2017 World Design Congress</h6>--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
                <div class="col-12 col-sm-6 col-lg-3">
<%--                    <div class="single-footer-widget mb-100">--%>
<%--                        <h5>Contact Info</h5>--%>
<%--                        <div class="footer-single-contact-info d-flex">--%>
<%--                            <div class="contact-icon">--%>
<%--                                <img src="img/core-img/map.png" alt="">--%>
<%--                            </div>--%>
<%--                            <p>4127/ 5B-C Mislane Road, Gibraltar, UK</p>--%>
<%--                        </div>--%>
<%--                        <div class="footer-single-contact-info d-flex">--%>
<%--                            <div class="contact-icon">--%>
<%--                                <img src="img/core-img/call.png" alt="">--%>
<%--                            </div>--%>
<%--                            <p>Main: 203-808-8613 <br> Office: 203-808-8648</p>--%>
<%--                        </div>--%>
<%--                        <div class="footer-single-contact-info d-flex">--%>
<%--                            <div class="contact-icon">--%>
<%--                                <img src="img/core-img/message.png" alt="">--%>
<%--                            </div>--%>
<%--                            <p>office@yourbusiness.com</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>
    <!-- Fotter Bottom Area -->
    <div class="footer-bottom-area">
        <div class="container h-100">
            <div class="row h-100">
                <div class="col-12 h-100">
<%--                    <div class="footer-bottom-content h-100 d-md-flex justify-content-between align-items-center">--%>
<%--                        <div class="copyright-text">--%>
<%--                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->--%>
<%--                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>--%>
<%--                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->--%>
<%--                            </p>--%>
<%--                        </div>--%>
<%--                        <div class="footer-social-info">--%>
<%--                            <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>--%>
<%--                            <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>--%>
<%--                            <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>--%>
<%--                            <a href="#"><i class="fa fa-dribbble" aria-hidden="true"></i></a>--%>
<%--                            <a href="#"><i class="fa fa-behance" aria-hidden="true"></i></a>--%>
<%--                            <a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
                </div>
            </div>
        </div>
    </div>
</footer>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>--%>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
</html>
