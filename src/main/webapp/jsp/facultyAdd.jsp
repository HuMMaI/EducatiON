<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="/faculty/add" method="post">
    <input type="text" name="name" value="${faculty.name}">
    <input type="number" name="numberOfSeats" value="${faculty.numberOfSeats}">
    <c:forEach items="${subjects}" var="subject">
        <div>
            <label>
                <input type="checkbox" name="${subject}">
                    ${subject}
            </label>
        </div>
    </c:forEach>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Create</button>
</form>

</body>
</html>
