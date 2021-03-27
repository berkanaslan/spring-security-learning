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

<!-- Add a link to point to /leaders this is for managers -->
<security:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for Manager peeps)
    </p>
</security:authorize>

<!-- Add a link to point to /leaders this is for admins -->
<security:authorize access="hasRole('ADMIN')">

    <p>
        <a href="${pageContext.request.contextPath}/systems">IT Systems</a>
        (Only for Admin peeps)
    </p>
</security:authorize>
<hr>

</body>
</html>