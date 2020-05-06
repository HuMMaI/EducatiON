<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<security:authorize access="hasAuthority('ADMIN')">
    <a href="/faculty/add">Add new faculty</a>
</security:authorize>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Faculty name</th>
        <th>Number of seats</th>
        <th>View info about faculty</th>
        <security:authorize access="hasAuthority('ADMIN')">
            <th>Action</th>
        </security:authorize>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${faculties}" var="faculty">
        <tr>
            <td>${faculty.id}</td>
            <td>${faculty.name}</td>
            <td>${faculty.numberOfSeats}</td>
            <td><a href="/faculty/info?id=${faculty.id}">View</a></td>
            <security:authorize access="hasAuthority('ADMIN')">
                <td><a href="/faculty/${faculty.id}">Edit</a></td>
            </security:authorize>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
