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

    <title>Faculties</title>
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
                    <h2>Faculties</h2>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">See Our Faculties</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="mosh-aboutUs-area section_padding_100_0">
    <div class="container">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="mosh-projects-menu">
                        <div class="faculty-filter-menu d-flex flex-row">
                            <p class="active" data-filter="*">All</p>
                            <p data-filter=".it">IT</p>
                            <security:authorize access="hasAuthority('ADMIN')">
                                <p class="ml-auto"><a href="/faculty/add">Add new faculty</a></p>
                            </security:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="d-flex flex-wrap">
            <c:forEach items="${faculties}" var="faculty">
                <div class="card text-center w-100 mb-3">
                    <h5 class="card-header">IT</h5>
                    <div class="card-body">
                        <h5 class="card-title">${faculty.name}</h5>
                        <p class="card-text">
                            Number of seats: ${faculty.numberOfSeats}<br>
                            Compulsory subjects:<br>
                            <c:forEach items="${faculty.subjects}" var="subject">
                                &mdash;${subject.toString()}<br>
                            </c:forEach>
                        </p>
                        <form action="/faculty/apply" method="post">
                            <input type="hidden" value="${userId}" name="user">
                            <input type="hidden" value="${faculty.id}" name="faculty">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="d-flex justify-content-center">
                                <security:authorize access="hasAuthority('ENROLLEE')">
                                    <button class="btn mosh-btn mt-50" type="submit">Apply</button>
                                </security:authorize>
                                <security:authorize access="hasAuthority('ADMIN')">
                                    <a class="btn mosh-btn mt-50 ml-4" href="/faculty/${faculty.id}">Edit</a>
                                </security:authorize>
                            </div>
                        </form>
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