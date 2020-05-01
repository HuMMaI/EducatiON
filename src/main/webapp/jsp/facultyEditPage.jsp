<%--
  Created by IntelliJ IDEA.
  User: HuMMaI
  Date: 4/30/2020
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="/faculty" method="post">
    <input type="text" name="name" value="${faculty.name}">
    <input type="number" name="numberOfSeats" value="${faculty.numberOfSeats}">
    <input type="hidden" value="${faculty.id}" name="id">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Edit</button>
</form>

</body>
</html>
