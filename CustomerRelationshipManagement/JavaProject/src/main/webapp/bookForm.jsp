<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String user=(String)session.getAttribute("userName");
	if(user==null)
	{
		response.sendRedirect("loginUser.jsp");
	}

%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="bootstrap-4.0.0-dist"></script>
<title>Fill the details</title>
<style>
.form
{
	transition: width;
}
.form:hover
{
	width:650px;
}
</style>
</head>
<body>
		<div class="container form" style="width:500px;border:2px solid black">
		<h3 style="text-align:center">Fill the details</h3>
		<form action="form" method="post">
		<div class="form-group">
		<label for="fname">First Name: </label>
		<input type="text" id="fname" name="firstName" class="form-control">
		</div>
		<div class="form-group">
		<label for="lname">Last Name: </label>
		<input type="text" id="lname" name="lastName" class="form-control">
		</div>
		<div class="form-group">
		<label for="age">Age: </label>
		<input type="number" id="age" name="age" class="form-control">
		</div>
		<div class="form-group">
		<label for="email">Email: </label>
		<input type="email" id="age" name="email" class="form-control">
		</div>
		<div class="form-group">
		<label for="phone">Phone: </label>
		<input type="tel" id="phone" name="phone" class="form-control">
		</div>
		<div class="form-group">
		<label for="car">Car-Id: </label>
		<input type="text" id="car" name="car" class="form-control">
		</div>
		<div class="form-group">
		<input type="submit" id="submit" name="submit" class="form-control btn btn-success" value="Register">
		</div>
		</form>
		</div>
		<br><br>
</body>
</html>