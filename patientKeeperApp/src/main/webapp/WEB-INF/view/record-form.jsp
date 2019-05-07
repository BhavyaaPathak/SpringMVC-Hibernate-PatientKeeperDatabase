<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">


<title>Insert title here</title>
</head>
<body>
<br>
<div class="container">
		<form:form action="saveRecord" modelAttribute="record" method="POST">
		
			<!-- Add hidden form field to handle update -->
			<form:hidden path="id" />
			
			<form:input path="issue" placeholder="Issue" /><br>

			<form:radiobutton path="status" value="Checkup"/> Checkup<br>
		    <form:radiobutton path="status" value="Admitted" /> Admitted<br>
		    <form:radiobutton path="status" value="Discharged" /> Discharged<br>
		    
		    <form:input path="doctorName" placeholder="Doctor" /><br>
					
			<button type="submit" class="btn btn-info col-2">Save</button>
						
		</form:form>
	
		<hr>
</div>

</body>
</html>