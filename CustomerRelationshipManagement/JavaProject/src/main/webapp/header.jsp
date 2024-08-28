<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.nav
	{
		position: fixed;
		top: 10px;
		height: 70px;
		background-color: black;
		color:white;
		width: 100%;
		z-index:1;
}
li
	{
		list-style-type: none;
		display: inline-block;
		margin-right: 60px;
		margin-top:20px;
		margin-bottom:20px;
		margin-left:20px;
}
</style>
<body>
	<div class="row container-fluid nav">
			<div class="col-md-12">
				<ul>
					<li><a class="btn btn-acive" href="index.jsp">Home</a></li>
					<li><a class="btn" href="index.jsp#about">About us</a></li>
					<li><a class="btn" href="index.jsp#contact">Contact us</a></li>
					<li><a class="btn" href="loginUser.jsp">Login</a></li>
					<li><a class="btn" href="signin.jsp">Sign in</a>
					<li><a class="btn" href="loginUser.jsp">Book Now</a>
					<li><a href="checkUser.jsp">Check Reservation</a>
					<li style="float:right;"><img src="carImages/new.jpg" style="width:150px;height:50px;"></li>
				</ul>
			</div>
		</div>
</body>
</html>