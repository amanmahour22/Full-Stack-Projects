<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	<title>Login Page</title>
	</head>
	<body>
	<div class="container">
		<h1>Login Page</h1>	
		Welcome to the login page!<br><br>
		
		<pre>${errorMessage}</pre>		
		<form method="post">
			Name : <input type="text" name="name"><br><br>
			Password : <input type="password" name="password"><br><br>
			<input type="submit" name="Submit">
		</form>
	</div>
		<script href="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script href="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>
