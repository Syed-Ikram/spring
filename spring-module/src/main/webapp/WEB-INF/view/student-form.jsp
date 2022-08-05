<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">

		First name: <form:input path="firstName" />

		<br><br>

		Last name: <form:input path="lastName" />

		<br><br>
		<form:select path="country">
		    <form:options items="${student.countryOptions}"/>

		</form:select>
		<br><br>
	    Favourite Language:
	    <br>
	    Java <form:radiobutton path="favouriteLanguage" value="Java"/>
	    Python <form:radiobutton path="favouriteLanguage" value="Python"/>
	    C++ <form:radiobutton path="favouriteLanguage" value="C++"/>
	    Javascript <form:radiobutton path="favouriteLanguage" value="Javascript"/>
	    <br><br>
	    Operating Systems:
        <br>
        Linux <form:checkbox path="operatingSystems" value="Linux"/>
        Windows <form:checkbox path="operatingSystems" value="Windows"/>
        MacOS <form:checkbox path="operatingSystems" value="MacOS"/>


	    <br><br>
		<input type="submit" value="Submit" />

	</form:form>


</body>

</html>
