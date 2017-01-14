[#ftl]
[#import "/spring.ftl" as spring /]
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Car ADD</title>
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>
	
</head>
[#escape x as x?html]


<div class="panel panel-default" style="width:50%; margin:0 auto;">
  <div class="panel-heading">
    <h3 class="panel-title">Add car</h3>
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
	

    <form action="/car/save" method="POST">
			<div class="input-group" style="width:80%">
		  		<input type="text" name="licensePlate" type="input" value="${car.licensePlate!''}" class="form-control" placeholder="License Plate" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="producer" type="input" value="${car.producer!''}" class="form-control" placeholder="Producer" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="model" type="input" value="${car.model!''}" class="form-control" placeholder="Car Model" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="type" type="input" value="${car.type!''}" class="form-control" placeholder="Car Type" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="integer" name="yearOfProduction" type="input" value="${car.yearOfProduction!''}" class="form-control" placeholder="Year of production" aria-describedby="basic-addon1">
			</div>
			
			
			
			<div class="input-group" style="width:80%">
		  		<input type="integer" name="nrOfSeats" type="input" value="${car.nrOfSeats!''}" class="form-control" placeholder="Nr of seats" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="double" name="fuelTankCap" type="input" value="${car.fuelTankCap!''}" class="form-control" placeholder="Fuel Tank" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="double" name="consumption" type="input" value="${car.consumption!''}" class="form-control" placeholder="Consumption" aria-describedby="basic-addon1">
			</div>
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="startPositionLat" type="input" value="${car.startPositionLat!''}" class="form-control" placeholder="Start Position Latitude" aria-describedby="basic-addon1">
			</div>
			
			
			<div class="input-group" style="width:80%">
		  		<input type="text" name="startPositionLong" type="input" value="${car.startPositionLong!''}" class="form-control" placeholder="Start Position Longitude" aria-describedby="basic-addon1">
			</div>
									
			<div class="input-group" style="width:80%">
		  		<input type="double" name="price" type="input" value="${car.price!''}" class="form-control" placeholder="Price/day" aria-describedby="basic-addon1">
			</div>
			
			<input type="hidden" name="id" value="[#if car.id??]${car.id?c}[/#if]">
			<input type="submit" value="Save">
			<a href="/owner">Cancel</a>
		</form>
  </div>
</div>




[/#escape]