[#ftl]
[#import "/spring.ftl" as spring /]
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Share your car!</title>
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>

</head>
[#escape x as x?html]

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
			<th>Nr Of Seats</th>
			<th>Fuel Tank (litres)</th>
			<th>Consumption (l/km)</th>
			<th>Actual Position</th>
			<th>Price / km</th>
			<th>Booked</th>
			<th>Delete Car</th>	
			<th></th>
		
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
				<td>${car.consumption}</td>
				<td>${car.price}</td>
				<td>${car.booked?c}</td>
		
				<td><a href="/car/delete?id=${car.id?c}">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				</a></td>
				
			</tr>
		[/#list]
	[/#if]
	
	<!-- end iteration -->
		

</table>
</div>
<form action="/logout" method="post"> 
			<input type="submit" class="button red big" value="Sign OUT"  /> 
			
			
			
		</form>	

	

[/#escape]