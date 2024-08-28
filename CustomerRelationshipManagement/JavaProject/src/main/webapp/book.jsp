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
<title>Book now</title>
<style>
	
</style>
</head>
<body style="background-color: white;color:black;">
    <%@ include file="header.jsp" %> 
	<div class="container-fluid">
		<img src="carImages/c.jfif" style="width:100%;height:500px">
	</div>
	<br>
	<div class="container" style="width:500px">
		<form action="book" method="get" style="margin: 0 auto; border: 2px solid red; padding: 40px;">
		<div class="form-group">
			<label for="start">Start Date: </label>
			<input type="date" name="start" id="start" class="form-control">
		</div>
		<div class="form-group">
			<label for="send">Return Date: </label>
			<input type="date" name="end" id="end" class="form-control">
		</div>
		<div class="form-group">
			<input type="submit" name="check" id="check" class="form-control btn btn-info">
		</div>
		</form>
	</div>
	<br>
	<%@ include file="footer.jsp" %> 
</body>
</html>