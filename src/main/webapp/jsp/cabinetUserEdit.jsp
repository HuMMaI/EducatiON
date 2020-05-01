<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="/cabinet" method="post">
    <input type="text" name="firstName" value="${user.firstName}"> <br>
    <input type="text" name="lastName" value="${user.lastName}"> <br>
    <input type="email" name="email" value="${user.email}"> <br>
    <input type="hidden" name="id" value="${user.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Edit">
</form>

</body>
</html>
