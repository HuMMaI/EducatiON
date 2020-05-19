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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

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
                    <h2><spring:message code="faculties_menu"/></h2>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/"><spring:message code="home_menu"/></a></li>
                            <li class="breadcrumb-item active" aria-current="page"><spring:message code="faculty_list_title"/></li>
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
                                <p class="ml-auto"><a href="/faculty/add"><spring:message code="faculty_list_add"/></a></p>
                            </security:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="d-flex flex-wrap">
            <c:forEach items="${faculties}" var="faculty">
                <div class="alert alert-danger error-hidden d-flex flex-row w-100" id="card-${faculty.id}" role="alert">
                    <span class="message" id="alertMessage-${faculty.id}"></span>
                    <span class="alert-link ml-auto alert-close"><i class="fas fa-times"></i></span>
                </div>
                <div class="card text-center w-100 mb-3">
                    <h5 class="card-header">${faculty.specialization}</h5>
                    <div class="card-body">
                        <h5 class="card-title">${faculty.name}</h5>
                        <p class="card-text">
                            <spring:message code="faculty_list_number_of_seats"/> ${faculty.numberOfSeats}<br>
                            <spring:message code="faculty_list_subjects"/><br>
                            <c:forEach items="${faculty.subjects}" var="subject">
                                &mdash;${subject.toString()}<br>
                            </c:forEach>
                        </p>
                        <form action="">
                            <input type="hidden" value="${userId}" name="userId">
                            <input type="hidden" value="${faculty.id}" name="facultyId">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <div class="d-flex justify-content-center">
                                <security:authorize access="hasAuthority('ENROLLEE')">
                                    <a class="btn mosh-btn mt-50" href="/statement/rating-list?id=${faculty.id}"><spring:message code="faculty_list_show_rating"/></a>
                                    <button class="btn mosh-btn mt-50 apply-btn ml-4" id="${faculty.id}" type="submit"><spring:message code="faculty_list_apply"/></button>
                                </security:authorize>
                                <security:authorize access="hasAuthority('ADMIN')">
                                    <a class="btn mosh-btn mt-50 ml-4" href="/faculty/edit?id=${faculty.id}"><spring:message code="faculty_list_edit"/></a>
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

<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/faculty_list.js"></script>
</body>
</html>