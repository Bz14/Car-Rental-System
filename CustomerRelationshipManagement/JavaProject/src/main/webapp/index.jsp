<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<link rel="stylesheet" href="index.css">
<link rel="icon" href="carImages/icon.jpg">
<script type="text/javascript" src="bootstrap-4.0.0-dist"></script>
<link rel="stylesheet" href="index.css">
<title>Car rental</title>
<style>
.footer-dark {
  padding:50px 0;
  color:#f0f9ff;
  background-color:#282d32;
}

.footer-dark h3 {
  margin-top:0;
  margin-bottom:12px;
  font-weight:bold;
  font-size:16px;
}

.footer-dark ul {
  padding:0;
  list-style:none;
  line-height:1.6;
  font-size:14px;
  margin-bottom:0;
}

.footer-dark ul a {
  color:inherit;
  text-decoration:none;
  opacity:0.6;
}

.footer-dark ul a:hover {
  opacity:0.8;
}

.footer-dark .item.text {
  margin-bottom:36px;
}

.footer-dark .item.text p {
  opacity:0.6;
  margin-bottom:0;
}

.footer-dark .item.social {
  text-align:center;
}

.footer-dark .item.social > a {
  font-size:20px;
  width:36px;
  height:36px;
  line-height:36px;
  display:inline-block;
  text-align:center;
  border-radius:50%;
  box-shadow:0 0 0 1px rgba(255,255,255,0.4);
  margin:0 8px;
  color:#fff;
  opacity:0.75;
}

.footer-dark .item.social > a:hover {
  opacity:0.9;
}

.footer-dark .copyright {
  text-align:center;
  padding-top:24px;
  opacity:0.3;
  font-size:13px;
  margin-bottom:0;
}
.zoom
{
	transition: width .2s;
}
.zoom:hover {
  width: 300px;
}
</style>
</head>
<body>
	<header>
		<div class="row container-fluid nav">
			<div class="col-md-12">
				<ul>
					<li><a class="btn btn-acive" href="#">Home</a></li>
					<li><a class="btn" href="#about">About us</a></li>
					<li><a class="btn" href="#contact">Contact us</a></li>
					<li><a class=btn   href="loginUser.jsp">Login</a>
					<li><a class="btn" href="signin.jsp">Sign in</a>
					<li><a href="loginUser.jsp">Book Now</a>
					<li><a href="checkUser.jsp">Check Reservation</a>
					<li style="float:right;"><img src="carImages/new.jpg" style="width:150px;height:50px;"></li>
				</ul>
			</div>
		</div>
		<div class="row container-fluid">
			<div class="col-md-12">
				<div class="slideshow-container">
		 			<div class="mySlides fade">
            			<img src="carImages/b.jfif" style="width:100%; height: 750px">
       				 </div>
         			<div class="mySlides fade">
          			   <img src="carImages/a.jfif" style="width:100%; height: 750px">
       				 </div>
        			<div class="mySlides fade">
           				 <img src="carImages/c.jfif" style="width:100%; height: 750px">
        			</div>
        			<div class="mySlides fade">
          				  <img src="carImages/g.jpg" style="width:100%; height: 750px">
       				 </div><br>
       	 	<div class="circle" style="text-align:center">
        		<span class="dot"></span>
        		<span class="dot"></span>
        		<span class="dot"></span>
        		<span class="dot"></span>
        	</div>
		</div>
	</div>
	</div>
	</header>
	<main>
		<div class="container col-md-6 col-offset-md-3 service jumbotron">
				<h2 class="page-header">Our Sevices</h2>
				<p style="text-align:justify;">Our aim is to provide customers with quality car rental services with affordable price
				and with better saftey and satisfaction.Our agency allow rent for some period of time and by checking 
				our site you can book your car before the date and take your car at the day you assumed until your car
				will be waiting for you.
				</p>
		</div>
		<div class="container img col-md-10 col-offset-md-2">
			<div>
			 <img src="carImages/s.jpg" style="height:500px;width:650px" class="zoom">
			 <img src="carImages/vc.jpeg" style="height:500px;width:650px" class="zoom">
			</div>
		</div>
		<div class="container img col-md-10 col-offset-md-2">
			<div>
			 <img src="carImages/c.jfif" style="height:500px;width:650px" class="zoom">
			 <img src="carImages/ford.jpg" style="height:500px;width:650px" class="zoom">
			</div>
		</div>
		<div class="container img col-md-10 col-offset-md-2">
			<div >
			 <img src="carImages/g.jpg" style="height:500px;width:650px" class="zoom">
			 <img src="carImages/h.jpg" style="height:500px;width:650px" class="zoom">
			</div>
		</div>
		<div class="container img col-md-10 col-offset-md-2">
			<div>
			 <img src="carImages/a.jfif" style="height:500px;width:650px" class="zoom">
			 <img src="carImages/i.jpg" style="height:500px;width:650px" class="zoom">
			</div>
		</div>
		<div class="container col-md-4 col-offset-md-4">
			<a href="loginUser.jsp"><input type="submit" name="book" value="Book Now" class="btn btn-primary btn-block bookBtn"></a>
		</div>
	</main>
	<div class="footer container-fluid">
	<div class="footer-dark">
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-3 item">
                        <h3>Services</h3>
                        <ul>
                            <li><a href="#">Car Rental</a></li>
                            <li><a href="#">Car tour</a></li>
                            <li><a href="#">Visit us</a></li>
                        </ul>
                    </div>
                    <div class="col-sm-6 col-md-3 item">
                        <h3>About</h3>
                        <ul id="contact">
                        	<li><a href="#">Tel: 0978665544</a></li>
                            <li><a href="#">Facebook: unique@carrent</a></li>
                            <li><a href="#">Instagram:beUnique_rent</a></li>
                        </ul>
                    </div>
                    <div class="col-md-6 item text" id="about">
                        <h3>Unique Car rental</h3>
                        <p>Our company is planning to meet every customer's car need by providing a variet of cars for rent with affordable price.
                        As our name indictes 
                        providing unique services is our moto. Widh you to Drive throughh the peace.</p>
                    </div>
                    <div class="col item social"><a href="#"><i class="icon ion-social-facebook"></i></a><a href="#"><i class="icon ion-social-twitter"></i></a><a href="#"><i class="icon ion-social-snapchat"></i></a><a href="#"><i class="icon ion-social-instagram"></i></a></div>
                </div>
                <p class="copyright">Company Name © 2018</p>
            </div>
        </footer>
    </div>
	</div>
		
	</footer>
	<script>
	let slideIndex = 0;
	showSlides();

	function showSlides() 
	{
	  let i;
	  let slides = document.getElementsByClassName("mySlides");
	  let dots = document.getElementsByClassName("dot");
	  for (i = 0; i < slides.length; i++) {
	    slides[i].style.display = "none";  
	  }
	  slideIndex++;
	  if (slideIndex >= slides.length) 
	  {
	    slideIndex = 1
	  }    
	  for (i = 0; i < dots.length; i++) 
	  {
	    dots[i].className = dots[i].className.replace(" active", "");
	  }
	  slides[slideIndex-1].style.display = "block";  
	  dots[slideIndex-1].className += " active";
	  setTimeout(showSlides, 1000);	
}
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>