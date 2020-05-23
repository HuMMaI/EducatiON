<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up Page</title>

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card h-auto">
            <div class="card-header">
                <h3>Sign Up</h3>
            </div>
            <div class="card-body">
                <form action="/registration" method="post">
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-address-book"></i></span>
                        </div>
                        <input type="text" class="form-control ${not empty emailError ? 'is-invalid' : ''}" placeholder="email address" name="email">
                        <c:if test="${not empty emailError}">
                            <div class="invalid-feedback">
                                ${emailError}
                            </div>
                        </c:if>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control ${not empty passwordError ? 'is-invalid' : ''}" placeholder="password" name="password">
                        <c:if test="${not empty passwordError}">
                            <div class="invalid-feedback">
                                    ${passwordError}
                            </div>
                        </c:if>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control ${not empty passwordConfirmationError ? 'is-invalid' : ''}" placeholder="password confirmation" name="passwordConfirmation">
                        <c:if test="${not empty passwordConfirmationError}">
                            <div class="invalid-feedback">
                                    ${passwordConfirmationError}
                            </div>
                        </c:if>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control ${not empty firstNameError ? 'is-invalid' : ''}" placeholder="first name" name="firstName" value="<c:if test='${not empty user}'>user.firstName</c:if>">
                        <c:if test="${not empty firstNameError}">
                            <div class="invalid-feedback">
                                    ${firstNameError}
                            </div>
                        </c:if>
                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="far fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control ${not empty lastNameError ? 'is-invalid' : ''}" placeholder="last name" name="lastName">
                        <c:if test="${not empty lastNameError}">
                            <div class="invalid-feedback">
                                    ${lastNameError}
                            </div>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" value="Sign Up" class="btn float-right login_btn">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</html>