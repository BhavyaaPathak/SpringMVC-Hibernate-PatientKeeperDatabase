<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	

</head>

<title>Patient Record Manager - Doctor</title>
</head>
<body>

<br><br>
	<div class="container">
		<!-- Add a button -->


			
		  <form:form action="find" modelAttribute="person" method="GET">
			<form:input path="id" class="form-control mb-4 col-4"></form:input>
			<input type="submit" class="btn btn-info col-2" value="Find"></button>

		</form:form>

		<!-- <hr>
		<a th:href="@{/doctor/}">Back to Search</a> -->
	</div>
</body>
</html>