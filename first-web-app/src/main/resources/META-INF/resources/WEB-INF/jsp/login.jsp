<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="text-center">			
				<h2>Login Page</h2>
				<pre>${errorMessage}</pre>
				<form method="post">
					<input type="text" name="name" placeholder="login id" class="p-2"><br>
					<br> <input type="password" name="password" placeholder="Password" class="p-2"><br><br> 
					<input type="submit" name="Submit" class="btn btn-primary">
				</form>
			</div>
		</div>
	</div>
			<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
