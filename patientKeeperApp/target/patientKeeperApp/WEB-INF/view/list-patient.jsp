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

		<!-- Add a button -->
		<%-- <a th:object="${person}" th:href="@{/doctor/showFormForAddRecord}"
			class="btn btn-primary btn-sm mb-3"> Add Record </a> --%>
		<input type="button" value="Add Record"
				   onclick="window.location.href='showFormForAddRecord'; return false;"
				   class="btn btn-primary btn-sm mb-3"/> 

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
			
			<c:url var="updateLink" value="/doctor/showFormForUpdate">
						<c:param name="id" value="${person.id}" />
					</c:url>					
					
				<td> ${person.firstName} </td>
				<td> ${person.lastName} </td>
				<td> ${person.email} </td>
				<td> ${person.SSN} </td>
				<td> ${person.dob} </td>
				<td> ${person.gender} </td>
				<td> ${person.role} </td>
				<%-- <td> ${person.lastName} </td> --%>
				<td>
				
				<a class="btn btn-info btn-sm ml-3 mr-1" href="${updateLink}">Update</a>
					<!-- <div class="row">

							<div class="col-small">
								Add "update" button/link
								<form action="showFormForUpdate" method="POST">

									<button type="submit" class="btn btn-info btn-sm ml-3 mr-1">Update</button>

								</form>
							</div>
						</div> -->
						</td>
						</tr>
				
			</tbody>
		</table>
		<table class="table table-bordered table-striped">
			<thead class="thead-dark">
				<tr>
					<th>Id</th>
					<th>Issue</th>
					<th>Status</th>
					<th>Doctor</th>
					
				</tr>
			</thead>

			<tbody>
			
				<c:forEach var="tempPatient" items="${patientRecord}">
				<tr>
					<td>${tempPatient.id}</td>
					<td>${tempPatient.issue}</td>
					<td>${tempPatient.status}</td>
					<td>${tempPatient.doctorName}</td>
					<td>
						<div class="row">

							<div class="col-small">
								<!-- Add "update" button/link -->
								<form action="/showFormForUpdateRecord" method="POST">

									<button type="submit" class="btn btn-info btn-sm ml-3 mr-1">Update</button>

								</form>
							</div>
						</div>
					</td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<a href="/patientKeeperApp/doctor/">Find another Patient</a>
	</div>
</body>
</html>