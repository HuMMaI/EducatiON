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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <title>Grades</title>
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
                    <div class="alert alert-danger error-hidden d-flex flex-row" id="subjectExistError" role="alert">
                        <span id="message"></span>
                        <span class="alert-link ml-auto" id="subject-alert-close"><i class="fas fa-times"></i></span>
                    </div>
                    <form action="">
                        <div class="row">
                            <div class="col-12 col-md-5">
                                <select class="form-control field-create" id="subject-name" required>
                                    <option value="" disabled selected hidden>Select subject</option>
                                </select>
                                <div class="invalid-feedback error-hidden" id="subject-name-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-5">
                                <input type="number" class="form-control field-create" placeholder="Subject grade" name="grade" id="subject-grade">
                                <div class="invalid-feedback error-hidden" id="grade-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-2">
                                <input type="hidden" value="subject" name="subject">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn mosh-btn" id="add-btn" type="submit">Add subject</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-flex flex-wrap" id="subject-cards">

        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="contact-form-area">
                    <h2>Certificate</h2>
                    <div class="alert alert-danger error-hidden d-flex flex-row" id="certificateExistError" role="alert">
                        <span id="certificateErrorMessage"></span>
                        <span class="alert-link ml-auto" id="certificate-alert-close"><i class="fas fa-times"></i></span>
                    </div>
                    <form action="">
                        <div class="row">
                            <div class="col-12 col-md-5">
                                <select class="form-control field-create" id="certificate-name" required>
                                    <option value="" disabled selected hidden>Select subject</option>
                                </select>
                                <div class="invalid-feedback error-hidden" id="certificate-name-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-5">
                                <input type="number" class="form-control field-create" placeholder="Certificate subject grade" name="grade" id="certificate-grade">
                                <div class="invalid-feedback error-hidden" id="certificate-grade-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-2">
                                <input type="hidden" value="certificate" name="certificate">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn mosh-btn" id="certificate-add-btn" type="submit">Add subject</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="d-flex flex-wrap" id="certificate-cards">

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
<script src="${pageContext.request.contextPath}/js/grades_page.js"></script>
</body>
</html>
