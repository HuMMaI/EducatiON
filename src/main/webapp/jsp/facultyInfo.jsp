<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h3>${faculty.name}</h3>
<br>
<span>${faculty.numberOfSeats}</span>
<br>
<c:forEach items="${faculty.subjects}" var="subject" varStatus="status">
    ${subject.toString()}
    <c:if test="${!status.last}">, </c:if>
</c:forEach>

</body>
</html>
