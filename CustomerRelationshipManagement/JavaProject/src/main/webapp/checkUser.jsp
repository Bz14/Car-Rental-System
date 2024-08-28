<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
%>  
<!DOCTYPE html>
<html>
<head>
<style>
.container{
position:relative;
top:100px;
height:200px;
padding:30px;
}

</style>
<meta charset="ISO-8859-1">
<title>Check Detail</title>
</head>
<body>
 <%@ include file="header.jsp" %>
 <div class="container-fluid">
		<img src="carImages/c.jfif" style="width:100%;height:500px">
	</div>
 <div class="container col-md-offset-4" style="border:2px solid black;width:500px;">
 	<form action="check" method="post">
 	 <div class="form-group">
 	 <label for="id">Your Customer Id: </label>
 	 <input type="text" name="id" id="" class="form-control">
 	 </div>
 	 <div class="form-group">
 	 <input type="submit" value="Check Detail" class="form-control btn btn-primary">
 	 </div>
 	</form>
 </div><br><br><br><br><br><br>
 <%@ include file="footer.jsp" %> 
</body>
</html>