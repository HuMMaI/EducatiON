<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<span>Photo: </span> <br>
<span>First name: ${user.firstName}</span> <br>
<span>Last name: ${user.lastName}</span> <br>
<span>Email name: ${user.email}</span> <br>

<a href="/cabinet/${user.id}">Edit</a>

</body>
</html>
