<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<title>Add Customer</title>
	</head>
	<body>
	<div class="container" style="margin-top: 20px;">
		<h2 class="mb-3">Customer Details</h2>		
		<form:form method="post" modelAttribute="customer">
			<form:input type="hidden" path="id" />
		<div class="row mb-3">
        	<div class="col">
			<form:input type="text" path="firstName" class="form-control" placeholder="First Name" required="required"/>
			</div>
			<div class="col">
			<form:input type="text" path="lastName" class="form-control" placeholder="Last Name" required="required"/>
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
			<form:input type="text" path="address" class="form-control" placeholder="Address" />
			</div>
			<div class="col">
			<form:input type="text" path="city" class="form-control" placeholder="City" />
			</div>
		</div>
		<div class="row mb-3">
			<div class="col">
			<form:input type="text" path="state" class="form-control" placeholder="State" />
			</div>
			<div class="col">
			<form:input type="text" path="email" class="form-control" placeholder="Email" />
			</div>
		</div>
		<div class="row mb-3">
			<div class="col-md-6">
			<form:input type="text" path="phone" maxlength="10" class="form-control" placeholder="Phone" />
			</div>	
		</div>					
			<input type="submit" class="btn btn-primary" />
		</form:form>		
	</div>
		<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>