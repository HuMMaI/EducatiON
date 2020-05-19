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
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <title>Rating list</title>
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
                    <h2>Rating list</h2>
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
                    <security:authorize access="hasAuthority('ADMIN')">
                        <form action="">
                            <input type="hidden" id="statement-id" value=""/>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn mosh-btn mt-50 ml-4" id="close-set" type="submit">Close set</button>
                        </form>
                    </security:authorize>
                    <table class="table table-striped table-dark">
                        <thead>
                            <tr>
                                <th scope="col">No.</th>
                                <th scope="col">First name</th>
                                <th scope="col">Last name</th>
                                <th scope="col">User id</th>
                                <th scope="col">Average grade of subjects</th>
                                <th scope="col">Average grade of certificate</th>
                                <th scope="col">Grade</th>
                            </tr>
                        </thead>
                        <tbody id="rating-table-body">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/rating_list.js"></script>

</body>
</html>
