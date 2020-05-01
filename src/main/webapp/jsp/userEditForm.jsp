<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<form action="/user" method="post">
    <input type="email" name="email" value="${user.email}">
    <input type="text" name="firstName" value="${user.firstName}">
    <input type="text" name="lastName" value="${user.lastName}">
    <c:forEach items="${roles}" var="role">
        <div>
            <label>
                <input type="checkbox" name="${role}" <c:if test="${user.roles.contains(role)}">checked=checked</c:if>}>
                ${role}
            </label>
        </div>
    </c:forEach>
    <input type="hidden" value="${user.id}" name="id">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Edit</button>
</form>

</body>
</html>
