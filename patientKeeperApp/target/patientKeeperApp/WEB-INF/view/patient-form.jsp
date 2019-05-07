<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

	<title>Save Person</title>
</head>

<body>

	<div class="container">
	
		<h3>Person Directory</h3>
		<hr>
		
		<p class="h4 mb-4">Save Person</p>
	
		<form:form action="savePatient" modelAttribute="person" method="POST">
		
			<!-- Add hidden form field to handle update -->
			<form:input path="id" type="hidden" />
			
			<form:input class="form-control mb-4 col-4" path="firstName" placeholder="First name" />

			<form:input class="form-control mb-4 col-4" path="lastName" placeholder="Last name" />

			<form:input class="form-control mb-4 col-4" path="email" placeholder="Email" />
					
			<form:input class="form-control mb-4 col-4" path="SSN" placeholder="SSN" />
					
			<form:input class="form-control mb-4 col-4" path="dob" placeholder="Date of birth" />
					
			<!-- <input type="text" th:field="*{role}"
					class="form-control mb-4 col-4" placeholder="Role"> -->
			<form:select class="form-control mb-4 col-4" path="role">
    				<form:option value = "NONE" label = "Select"/>
  					<form:options items = "${role}" />
			</form:select> 
			
			<form:radiobutton path = "gender" value = "M" label = "Male" /> <br>
            <form:radiobutton path = "gender" value = "F" label = "Female" /> <br>
                  
              
				
			<button type="submit" class="btn btn-info col-2">Save</button>
						
		</form:form>
	
		<hr>
		<a href="/doctor">Back</a>
		
	</div>
</body>

</html>










