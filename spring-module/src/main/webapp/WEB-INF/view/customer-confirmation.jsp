<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>
        Customer confirmation
        </title>
    </head>
    <body>
        <h2> </h2>
        <hr>
        The customer is : ${customer.firstName} ${customer.lastName}
        <br>
        Free passes:${customer.freePasses}
        <br>
        Postal Code:${customer.postalCode}
        <br>
        Course Code:${customer.courseCode}
        <br>

    </body>
</html>