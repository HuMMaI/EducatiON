<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

    <link id="contextPathHolder" data-contextPath="${pageContext.request.contextPath}"/>

    <title>Hello, world!</title>
</head>
<body>

<header class="header_area clearfix">
    <div class="container-fluid h-100">
        <div class="row h-100">
            <div class="col-12 h-100">
                <div class="menu_area h-100">
                    <nav class="navbar h-100 navbar-expand-lg align-items-center">
                        <a class="navbar-brand" href="/"><img src="${pageContext.request.contextPath}/img/core-img/education_logo.png" alt="logo"></a>

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mosh-navbar" aria-controls="mosh-navbar" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

                        <div class="collapse navbar-collapse justify-content-end" id="mosh-navbar">
                            <ul class="navbar-nav animated" id="nav">
                                <li class="nav-item active"><a class="nav-link" href="/">Home</a></li>
                                <li class="nav-item"><a class="nav-link" href="/faculty">Faculties</a></li>
                                <security:authorize access="hasAuthority('ENROLLEE')">
                                    <li class="nav-item"><a class="nav-link" href="/grades">Grades list</a></li>
                                </security:authorize>
                                <security:authorize access="hasAuthority('ADMIN')">
                                    <li class="nav-item"><a class="nav-link" href="/user">User list</a></li>
                                    <li class="nav-item"><a class="nav-link" href="/requests">Request list</a></li>
                                </security:authorize>
                            </ul>
                            <div class="search-form-area animated">
                                <form action="#" method="post">
                                    <input type="search" name="search" id="search" placeholder="Type keywords &amp; hit enter">
                                    <button type="submit" class="d-none"><img src="${pageContext.request.contextPath}/img/core-img/search-icon.png" alt="Search"></button>
                                </form>
                            </div>
                            <div class="search-button">
                                <a href="#" id="search-btn"><img src="${pageContext.request.contextPath}/img/core-img/search-icon.png" alt="Search"></a>
                            </div>
                            <security:authorize access="isAnonymous()">
                                <div class="login-register-btn">
                                    <a href="/login">Login</a>
                                    <a href="/registration">/ Register</a>
                                </div>
                            </security:authorize>
                            <security:authorize access="isAuthenticated()">
                                <div class="dropdown" id="user-img-container">
                                    <img class="btn dropdown-toggle" src="" alt="dropdown image" data-toggle="dropdown" id="user-img" aria-expanded="false">
                                    <input type="hidden" id="user-img-src" value="">
                                    <input type="hidden" value="0" id="click-listener">
                                    <ul class="dropdown-menu dropdown-menu-right" id="user-panel">
                                        <li><a class="dropdown-item" href="/cabinet">Cabinet</a></li>
                                        <div class="dropdown-divider"></div>
                                        <li>
                                            <form action="/logout" method="post" id="logout-form">
                                                <a class="dropdown-item" href="#" onclick="document.getElementById('logout-form').submit()">Log Out</a>
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </security:authorize>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/header.js"></script>
</body>
</html>
