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
                            <div class="col-12">
                                <img src="" id="user-cover" width="200px">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">Upload</span>
                                    </div>
                                    <div class="custom-file">
                                        <input type="file" id="cover-file" name="file">
                                        <label class="custom-file-label" for="cover-file">Choose file</label>
                                    </div>
                                </div>
                                <input type="hidden" value="" class="form-control" id="cover-id" name="coverId">
                            </div>
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
                            <div class="col-12 col-md-6">
                                <input type="number" class="form-control field-create" placeholder="Age" name="age" id="age" value="">
                                <div class="invalid-feedback error-hidden" id="age-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <select class="form-control field-create" id="gender" required>
                                    <option value="" disabled selected hidden>Select gender</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <div class="invalid-feedback error-hidden" id="gender-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <select class="form-control field-create" id="country" required>
                                    <option value="" disabled selected hidden>Select country</option>
                                    <option value="Ukraine">Ukraine</option>
                                </select>
                                <div class="invalid-feedback error-hidden" id="country-error">

                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <input type="text" class="form-control field-create" placeholder="City" name="city" id="city" value="">
                                <div class="invalid-feedback error-hidden" id="city-error">

                                </div>
                            </div>
                            <div class="col-12">
                                <input type="email" class="form-control field-create" placeholder="Email" name="email" id="email" value="">
                                <div class="invalid-feedback error-hidden" id="email-error">

                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="hidden" name="user-id" id="user-id" value=""/>
                            <button class="btn mosh-btn mt-50" id="save-btn" type="submit">Save</button>
                        </div>
                    </form>
                </div>
            </div>
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
<script src="${pageContext.request.contextPath}/js/cabinet_user_edit.js"></script>
<script src="${pageContext.request.contextPath}/js/user_cover_file.js"></script>

</body>
</html>


