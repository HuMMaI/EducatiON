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

    <title>Create faculty</title>
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
                    <h2>Grades list</h2>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Add grades</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="contact-area section_padding_100">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="contact-form-area">
                    <h2>Subjects</h2>
                    <form action="/grades/add-subject" method="post">
                        <div class="row">
                            <div class="col-12 col-md-5">
                                <input type="text" class="form-control field-create" placeholder="Subject name" name="name">
                            </div>
                            <div class="col-12 col-md-5">
                                <input type="number" class="form-control field-create" placeholder="Subject grade" name="grade">
                            </div>
                            <div class="col-12 col-md-2">
                                <input type="hidden" value="${userId}" name="user">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn mosh-btn" type="submit">Add subject</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-flex flex-wrap">
            <c:forEach items="${subjects}" var="subject">
                <div class="card mb-3 w-50 mr-auto ml-auto" style="max-width: 540px;">
                    <div class="row no-gutters">
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${subject.name}</h5>
                                <p class="card-text">Grade: ${subject.grade}</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                        </div>
                        <div class="col-md-4 d-flex flex-column justify-content-around">
                            <button class="btn mosh-btn" type="submit">Edit</button>
                            <button class="btn mosh-btn" type="submit">Delete</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="contact-form-area">
                    <h2>Certificate</h2>
                    <form action="/grades/add-certificate" method="post">
                        <div class="row">
                            <div class="col-12 col-md-5">
                                <input type="text" class="form-control field-create" placeholder="Certificate subject name" name="name">
                            </div>
                            <div class="col-12 col-md-5">
                                <input type="number" class="form-control field-create" placeholder="Certificate subject grade" name="grade">
                            </div>
                            <div class="col-12 col-md-2">
                                <input type="hidden" value="${userId}" name="user">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn mosh-btn" type="submit">Add subject</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-flex flex-wrap">
            <c:forEach items="${certificates}" var="certificate">
                <div class="card mb-3 w-50 mr-auto ml-auto" style="max-width: 540px;">
                    <div class="row no-gutters">
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${certificate.name}</h5>
                                <p class="card-text">Grade: ${certificate.grade}</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                        </div>
                        <div class="col-md-4 d-flex flex-column justify-content-around">
                            <button class="btn mosh-btn" type="submit">Edit</button>
                            <button class="btn mosh-btn" type="submit">Delete</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
