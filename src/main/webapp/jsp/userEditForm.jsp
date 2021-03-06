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

    <title>Edit user</title>
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
                    <h2>Edit user</h2>
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
                    <h2>Edit user</h2>
                    <form action="">
                        <div class="row">
                            <div class="col-12 col-md-6">
                                <input type="text" class="form-control field-create" placeholder="First name" name="firstName" id="first-name" value="">
                                <div class="invalid-feedback error-hidden" id="first-name-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <input type="text" class="form-control field-create" placeholder="Last name" name="lastName" id="last-name" value="">
                                <div class="invalid-feedback error-hidden" id="last-name-error">

                                </div>
                            </div>
                            <div class="col-12">
                                <input type="email" class="form-control field-create" placeholder="Email" name="email" id="email" value="">
                                <div class="invalid-feedback error-hidden" id="email-error">

                                </div>
                            </div>
                            <div class="col-12" id="user-roles">

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
<script src="${pageContext.request.contextPath}/js/user_edit.js"></script>

</body>
</html>

