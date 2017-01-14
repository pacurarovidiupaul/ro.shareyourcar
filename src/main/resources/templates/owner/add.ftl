[#ftl]
[#import "/spring.ftl" as spring /]


<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Owner</title>
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
    <link href="[@spring.url '/css/signup.css' /]" rel="stylesheet" type="text/css">
    
    <!-- jQuery -->
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>	
    <!-- Bootstrap Core JavaScript -->
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
</head>
[#escape x as x?html]


<body class="add">
 
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
                <a class="navbar-brand" href="/home" style="color: #FEEA58">ShareYourCar </a>
            </div>
            
         <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">                 
                    <li>            	
                    	<div class= "topright" >	    			
                   			<button type="button" class="btn btn-warning" aria-haspopup="true" aria-expanded="false">
    							Sign in
							</button>		
                   		</div>	
                   	</li>	
 							
                </ul>
			</div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

 <div class="panel panel-default" style="width:100%; margin:0 auto;">
  <div class="panel-heading">
    <h3 class="panel-title">Add Owner</h3>
  </div>
  <div class="panel-body">
  
    [#if errors??]
    <div>
        <ul>
            [#list errors as error]
            <br>
                <b style="color:red">
                [#if error.field??]${error.field}: [/#if]${error.defaultMessage}
                </b>
            [/#list]
        </ul>
    </div>
	[/#if]

    <form action="/owner/save" method="POST">
			<div class="input-group" style="width:80%">
		  		<input type="text" name="firstName" type="input" value="${owner.firstName!''}" class="form-control" placeholder="First Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="lastName" type="input" value="${owner.lastName!''}" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="emailAddress" type="input" value="${owner.emailAddress!''}" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="phoneNumber" type="input" value="${owner.phoneNumber!''}" class="form-control" placeholder="Phone Number" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="userName" type="input" value="${owner.userName!''}" class="form-control" placeholder="User Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="password" name="password" type="input" value="${owner.password!''}" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
			</div>
			
			<input type="hidden" name="id" value="[#if owner.id??]${owner.id?c}[/#if]">
			<input type="submit" value="Save">
		</form>
  </div>
</div>




[/#escape]