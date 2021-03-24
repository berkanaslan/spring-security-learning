<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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

<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br>
    <br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>

</body>
</html>