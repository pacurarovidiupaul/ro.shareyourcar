[#ftl]
[#import "/spring.ftl" as spring /]
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Client List</title>
    
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
	 <link href="[@spring.url '/css/signup.css' /]" rel="stylesheet" type="text/css">
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>
</head>
[#escape x as x?html]

 <body class="addclient">
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
          </div>
        <!-- /.container -->
    </nav>
<p></p>
</body>



<div class="panel panel-default" style="width:50%; margin:0 auto;">
  <div class="panel-heading">
    <h3 class="panel-title">Edit Client</h3>
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

    <form action="/client/update" method="POST">
			<div class="input-group" style="width:80%">
		  		<input type="text" name="firstName" type="input" value="${client.firstName!''}" class="form-control" placeholder="First Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="lastName" type="input" value="${client.lastName!''}" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="emailAddress" type="input" value="${client.emailAddress!''}" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="phoneNumber" type="input" value="${client.phoneNumber!''}" class="form-control" placeholder="Phone Number" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="userName" type="input" value="${client.userName!''}" class="form-control" placeholder="User Name" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="password" name="password" type="input" value="${client.password!''}" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="integer" name="age" type="input" value="${client.age!''}" class="form-control" placeholder="Age" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="double" name="wallet" type="input" value="${client.wallet!''}" class="form-control" placeholder="Wallet" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="currentLocation" type="input" value="${client.currentLocation!''}" class="form-control" placeholder="Current location latitude" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="currentLocationLong" type="input" value="${client.currentLocationLong!''}" class="form-control" placeholder="Current location longitude" aria-describedby="basic-addon1">
			</div>
					
			
			<input type="hidden" name="id" value="[#if client.id??]${client.id?c}[/#if]">
			<input type="submit" value="Update">
			<a href="/client">Cancel</a>
		</form>
  </div>
</div>




[/#escape]