[#ftl]
[#import "/spring.ftl" as spring /]
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Share your car!</title>
    
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


<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Client Main</div>
 
  <table class="table">
	<tr>
	    <th>Name</td>
		<th>Your Wallet</th>
		<th>List available cars</th>
		<th>Edit your profile</th>
		<th></th>
		
	</tr>
	<!-- begin iteration -->
	[#if clients??]
		[#list clients as client] 
			<tr>
			    <td>${client.lastName}</td>
				<td>${client.wallet}</td>
				<td><a href="/car/available">
				<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
				</a></td>
				<td><a href="/client/edit">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				</a></td>
		
			</tr>
		[/#list]
	[/#if]
	
	<!-- end iteration -->		

</table>
</div>

<form action="/car/booked" method="post"> 
			<input type="submit" class="button red big" value="View your Booked Cars!"/> 		
		</form>	

<form action="/logout" method="post"> 
			<input type="submit" value="Sign out!" class="btn btn-primary btn-lg" aria-expanded="false"/> 		
		</form>	

	
</body>
[/#escape]
