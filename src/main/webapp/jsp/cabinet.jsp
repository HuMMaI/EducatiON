<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>

<div id="preloader">
    <div class="mosh-preloader"></div>
</div>

<jsp:include page="header.jsp"></jsp:include>

<div class="mosh-breadcumb-area" style="background-image: url(${pageContext.request.contextPath}/img/core-img/breadcumb.png);">
    <div class="container h-100">
        <div class="row h-100 align-items-center">
            <div class="col-12">
                <div class="bradcumbContent">
                    <h2>Cabinet</h2>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Fill info about yourself</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog-area section_padding_100">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-8">
                <div class="mosh-blog-posts">
                    <div class="row">
                        <div class="col-12">
                            <div class="single-blog wow fadeInUp" data-wow-delay="0.2s">
                                <div class="blog-post-thumb d-flex justify-content-center">
                                    <img src="" id="profile-img" alt="">
                                </div>
                                <h2>Short information about you</h2>
                                <p><i>Empty.</i></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-12 col-md-4">
                <div class="mosh-blog-sidebar">

<%--                    <div class="blog-post-archives mb-100">--%>
<%--                        <h5>Archives</h5>--%>
<%--                        <ul>--%>
<%--                            <li><a href="#">March 2018</a></li>--%>
<%--                            <li><a href="#">April 2018</a></li>--%>
<%--                            <li><a href="#">May 2018</a></li>--%>
<%--                        </ul>--%>
<%--                    </div>--%>

                    <div class="blog-post-categories mb-2">
                        <h5>First name</h5>
                        <p id="user-first-name"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>Last name</h5>
                        <p id="user-last-name"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>Email</h5>
                        <p id="user-email"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>Age</h5>
                        <p id="user-age"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>Gender</h5>
                        <p id="user-gender"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>Country</h5>
                        <p id="user-country"></p>
                    </div>

                    <div class="blog-post-categories mb-2">
                        <h5>City</h5>
                        <p id="user-city"></p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <h2>Requests</h2>
                <div class="d-flex flex-wrap" id="user-requests">

                </div>
            </div>
        </div>
    </div>
</section>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/cabinet.js"></script>
</body>
</html>