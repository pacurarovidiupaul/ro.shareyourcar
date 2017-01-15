<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="<spring:url value="css/app.css" />" rel="stylesheet" type="text/css">	
	<title>Share your car!</title>
</head>

<body class="home">

 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    
                </button>
                <a class="navbar-brand" href="#" style="color: #FEEA58">ShareYourCar </a>
            </div>
            
         <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#about">About</a>
                    </li>
                    <li>
                        <a href="#services">Services</a>
                    </li>
                    <li>
                        <a href="#contact">Join</a>
                    </li>
                    
                    <li>
                    	<div class="dropdown">
                    	<div class= "topright" >	    			
                   			<button type="button" class="btn btn-warning" aria-haspopup="true" aria-expanded="false">
    							Sign up
							</button>
  							<ul class="dropdown-menu ">
    							<li><a class="dropdown-item" href="/owner/add">as Owner</a></li>
    							<li><a class="dropdown-item" href="/client/add">as Client</a></li>
  								</ul>
						</div>
                   		</div>	
                   	</li>	
 							
                </ul>
			</div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
<!-- Header image -->
<header class="image">
        <div class="headline">
            <div class="container">
                <h1>Share your car</h1>
                <h2>The best carsharing site ever</h2>
			</div>	
        </div>
</header>

  <div class="container">
  <div class="dropdown">
  <div class="btn-group dropup" style = "position:fixed; right:0; ">
        <a href="/login"><button type="button" class="btn btn-warning btn-lg" aria-haspopup="true" aria-expanded="false" style = "margin:-2px">
    	Sign in
		</button></a>
			<ul class="dropdown-menu dropup">
    			<li><a class="dropdown-item" href="/owner">as Owner</a></li>
    			<li><a class="dropdown-item" href="/client">as Client</a></li>
  			</ul>	
         </div>
      </div>
        <hr class="featurette-divider">

        <!-- First Featurette -->
        <div class="featurette" id="about">
            <img class="featurette-image img-circle img-responsive pull-right" src="/images/featurette1.jpg">
            <h2 class="featurette-heading">Be smart.
                <span class="text-muted">Get there smarter!</span>
            </h2>
            <p class="lead">Carsharing should make it easy for you to get there and back. Wide variety of cars. With the latest technologies. And the best prices. With ShareYourCar that’s what you get.</p>
        </div>
        
        <hr class="featurette-divider">

        <!-- Second Featurette -->
        <div class="featurette" id="services">
            <img class="featurette-image img-circle img-responsive pull-left" src="/images/featurette2.jpg">
            <h2 class="featurette-heading">New concept of carsharing
                <span class="text-muted">gives you freedom!</span>
            </h2>
            <p class="lead">You can use a car just as much as you need. Fuel costs are also included even the road taxes. No hidden costs, this means the new carsharing service.</p>
        </div>
        
        <hr class="featurette-divider">

        <!-- Third Featurette -->
        <div class="featurette" id="contact">
            <img class="featurette-image img-circle img-responsive pull-right" src="/images/driving.jpg">
            <h2 class="featurette-heading">Are you ready?
                <span class="text-muted">Let's dive!</span>
            </h2>
            <p class="lead">Membership is free for unlimited time. So sign up and get ready to hit the road. It’s fast. It’s fun. And there’s nothing else like it.</p>
        </div>

        <hr class="featurette-divider">
       
   <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; TeamProject 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

	<!-- jQuery -->
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	
	 <!-- Bootstrap Core JavaScript -->
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
       
</body>
</html>