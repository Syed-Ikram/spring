<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
        Student confirmation
        </title>
    </head>
    <body>
        <h2> </h2>
        <hr>
        The student is : ${student.firstName} ${student.lastName}
        <br>
        Country: ${student.country}
        <br>
        Favourite Language: ${student.favouriteLanguage}
        <br>
        <c:forEach var="temp" items="${student.operatingSystems}">
            <li>${temp}</li>
        </c:forEach>
    </body>
</html>