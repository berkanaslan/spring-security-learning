<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Spring Security Example Project</title>
</head>
<body>
<h2>X Company Home Page</h2>
<hr>
Welcome to the our company home page!

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout">
</form:form>

</body>
</html>