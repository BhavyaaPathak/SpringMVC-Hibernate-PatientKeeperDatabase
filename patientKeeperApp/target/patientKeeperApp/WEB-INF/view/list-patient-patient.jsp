<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<title>Patient Record Manager - Doctor</title>
</head>
<body>
	<div class="container">

		<h3>Patient Record</h3>
		<hr>


		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>SSN</th>
					<th>Date of birth</th>
					<th>Gender</th>
					<th>Role</th>
					<!-- <th>Address</th> -->
				</tr>
			</thead>

			<tbody>
			
			<tr>
			
					
					
				<td> ${person.firstName} </td>
				<td> ${person.lastName} </td>
				<td> ${person.email} </td>
				<td> ${person.SSN} </td>
				<td> ${person.dob} </td>
				<td> ${person.gender} </td>
				<td> ${person.role} </td>
				<%-- <td> ${person.lastName} </td> --%>
						</tr>
				
			</tbody>
		</table>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Issue</th>
					<th>Status</th>
					
				</tr>
			</thead>

			<tbody>
			
				<c:forEach var="tempPatient" items="${patientRecord}">
				<tr>
					<td>${tempPatient.id}</td>
					<td>${tempPatient.issue}</td>
					<td>${tempPatient.status}</td>
					
					
				</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<a href="/">Find another Patient</a>
	</div>
</body>
</html>