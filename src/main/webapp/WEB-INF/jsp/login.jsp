<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	<link href="<spring:url value="css/login.css" />" rel="stylesheet" type="text/css">
	<!-- jQuery -->
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
    <!-- Bootstrap Core JavaScript -->
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<title>Log in</title>
</head>

<body class="add">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/home" style="color: #FEEA58">ShareYourCar </a>
            </div>
            
         <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
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
</body>

<header>
	<div class="headline">
		<div class="container">
		 	<div class="panel panel-default" style="width:25%; margin:0 auto; background: rgba(255,255,255,0.8);">
		  		<div class="panel-heading">
		    		<h3 class="panel-title">Sign in</h3>
		  		</div>
		  		
		  		<div class="panel-body">
				<form action="/login" method="post">
			
					<div class="lc-block">
						<div>
							<input type="text" class="style-4" name="username"
								placeholder="User Name" />
						</div>
						<div>
							<input type="password" class="style-4" name="password"
								placeholder="Password" />
						</div>
						<div>
							<input type="submit" value="Sign In" class="button red small" />
						</div>
						<c:if test="${param.error ne null}">
							<div class="alert-danger">Invalid username and password.</div>
						</c:if>
						<c:if test="${param.logout ne null}">
							<script language="javascript">
			                var page = "/home"
			                top.location = page;
			            </script> 
						</c:if>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				</div>
			</div>
        </div>
</header>
</html>