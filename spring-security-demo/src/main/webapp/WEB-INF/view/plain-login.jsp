<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>Login Page</title>
	<style>
	    .failed{
	        color:red;
	    }
	</style>
</head>

<body>
    <h3>Custom Login Form</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
	                method="POST">
        <c:if test="${param.error!=null}">
            <i class="failed"> Sorry , you entered wrong login details !</i>
        </c:if>
        <p>
            Username:<input name="username" type="text" />
        </p>
        <p>
            Password:<input name="password" type="password" />
        </p>
        <input type="submit" value="Login" />
	</form:form>

</body>

</html>