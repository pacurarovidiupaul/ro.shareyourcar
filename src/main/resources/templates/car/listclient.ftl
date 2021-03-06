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

<body class="addcar">
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
  <div class="panel-heading">Car Main</div>
 
  <table class="table">
	<tr>
	    	<th>License plate</th>
			<th>Producer</th>	
			<th>Model</th>
			<th>Type</th>
			<th>Year Of Production</th>
			<th>Number Of Seats</th>
			<th>Fuel Tank (litres)</th>
			<th>Consumption (l/km)</th>
			<th>Show position</th>
			<th>Price / day</th>
			<th>Book</th>
				
	</tr>
	<!-- begin iteration -->
	[#if cars??]
		[#list cars as car] 
			<tr>
			    <td>${car.licensePlate}</td>
				<td>${car.producer}</td>
				<td>${car.model}</td>
				<td>${car.type}</td>
				<td>${car.yearOfProduction}</td>
				<td>${car.nrOfSeats}</td>
				<td>${car.fuelTankCap}</td>
				<td>${car.consumption}</td>
				<td><a href="/car/showpos?id=${car.id?c}&param1=${car.startPositionLat}&param2=${car.startPositionLong}">
				<span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>
				</a></td>
				<td>${car.price}</td>	
				<td><form action="/car/book" method="POST">
				<div class="input-group" style="width:60%">
		  		<input type="number" min="1" max="30" name="days" type="input" class="form-control" placeholder="Nr. of days" aria-describedby="basic-addon1" required/	>
			    </div>
			    <input type="hidden" name="id" value="${car.id?c}">
				<input type="submit" value="Book car!" class="btn btn-primary" aria-expanded="false">
				</a></td>
			    </form>
			</tr>
		[/#list]
	[/#if]
	
	<!-- end iteration -->
		

</table>
</div>


				
<form action="/client" method="post"> 
			<input type="submit" class="btn btn-primary btn-lg" aria-expanded="false" value="Back to Client Main"  /> 			
		</form>	

	

[/#escape]
