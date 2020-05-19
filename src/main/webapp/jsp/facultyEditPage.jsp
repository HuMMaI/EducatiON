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
                    <h2>Edit faculty</h2>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="/">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Fill all fields</li>
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
                    <h2>Edit faculty</h2>
                    <form action="">
                        <div class="row">
                            <div class="col-12 col-md-6">
                                <input type="text" class="form-control field-create" placeholder="Name" name="facultyName" id="faculty-name" value="">
                                <div class="invalid-feedback error-hidden" id="name-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <input type="number" class="form-control field-create" placeholder="Number of seats" name="numberOfSeats" id="number-of-seats" value="">
                                <div class="invalid-feedback error-hidden" id="number-of-seats-error">

                                </div>
                            </div>
                            <div class="col-12" id="faculty-specialization">
                                <select class="form-control field-create" id="specialization-name" required>
                                    <option value="" disabled selected hidden>Select specialization</option>
                                </select>
                                <div class="invalid-feedback error-hidden" id="specialization-error">

                                </div>
                            </div>
                            <div class="col-12" id="faculty-subjects">

                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn mosh-btn mt-50" id="save-btn" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>


<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/faculty_edit.js"></script>
</body>
</html>
