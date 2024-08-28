<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Sign in</title>
</head>
<style>
.container
{
	position: absolute;
	top:130px;
}
</style>
<body>
	<%@ include file="header.jsp" %>  
	<div class="container row">
     	<div class="col-md-6 offset-md-6 ">
     <form action="signin" method="post">
     	<fieldset>
     		<legend style="text-align:center">Sign up</legend>
     		<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" name="userName" id="userName" class="form-control">
			</div>
			<div class="form-group">
				<label for="pasword">Password: </label>
				<input type="password" name="password" id="password" class="form-control">
			</div>
			<div class="form-group">
				<label for="confirm">Repeat Password: </label>
				<input type="password" name="confirmpass" id="confirmpassword" class="form-control">
			</div>
			<div class="form-group">
				<input type="checkbox" name="agree-term" id="agree-term" class="agree-term" /> 
				<label for="agree-term" class="label-agree-term"><span><span></span></span>I
									Agree all statements in <a href="#" class="term-service">Terms of service</a></label>
			</div>
			<div class="form-group">
			<input type=submit name="signup" value="Sign up" class="form-control btn btn-primary">
			<span><a href="loginUser.jsp">Alreay a Member?</a></span>
			</div>
     	</fieldset>
    </form>
    </div>
     </div>
</body>
</html>