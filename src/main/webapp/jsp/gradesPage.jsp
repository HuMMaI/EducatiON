<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h3>Subjects</h3>

<form action="/grades/add-subject" method="post">
    <input type="text" name="name" placeholder="subject name">
    <input type="number" name="grade" placeholder="subject grade">
    <input type="hidden" value="${userId}" name="user">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Add new subject">
</form>

<br>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Subject name</th>
        <th>Subject grade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${subjects}" var="subject">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td>${subject.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

<h3>Certificates</h3>

<form action="/grades/add-certificate" method="post">
    <input type="text" name="name" placeholder="subject name">
    <input type="number" name="grade" placeholder="subject grade">
    <input type="hidden" value="${userId}" name="user">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Add new certificate">
</form>

<br>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Certificate name</th>
        <th>Certificate grade</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${certificates}" var="certificate">
        <tr>
            <td>${certificate.id}</td>
            <td>${certificate.name}</td>
            <td>${certificate.grade}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
