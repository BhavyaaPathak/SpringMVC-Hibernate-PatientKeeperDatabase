<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Patient Record Manager - Admin</title>
</head>

<body>

<div class="container">

	<h3>Doctor/Patient Directory</h3>
	<hr>
	
	<!-- Add a button -->
	<input type="button" value="Add Doctor/Patient"
				   onclick="window.location.href='showFormForAdd'; return false;"
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
			
		<c:forEach var = "person" items="${person}">
			
			<c:url var="updateLink" value="/admin/showFormForUpdate">
						<c:param name="personId" value="${person.id}" />
					</c:url>
			<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/admin/delete">
						<c:param name="personId" value="${person.id}" />
					</c:url>					
				<tr>	
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
				<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
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
				</c:forEach>
			</tbody>
		</table>
	
</div>
	
</body>
</html>



