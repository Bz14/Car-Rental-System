<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Login</title>
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
     <form action="login" method="post">
     	<fieldset>
     		<legend style="text-align:center">Login</legend>
     		<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" name="userName" id="userName" class="form-control">
			</div>
			<div class="form-group">
				<label for="pasword">Password: </label>
				<input type="password" name="password" id="password" class="form-control">
			</div>
			<div class="form-group">
			<input type=submit name="login" value="Login" class="form-control btn btn-primary">
			<span><a href="signin.jsp">Don't have an account</a>&nbsp;&nbsp;&nbsp;&nbsp;</span>
			<span><a>Forgot password</a></span>
			</div>
     	</fieldset>
    </form>
    </div>
     </div>
     <div>
     <!--<%@ include file="footer.jsp" %>--> 
     </div>
</body>
</html>