<!DOCTYPE html>
<html>
  <head>
    <style>
		html, body {
          height: 100%;
          margin: 0;
          padding: 0;
      }
      #map-canvas {
          height: 100%;
          width: 100%;
      }
	   
    </style>
  </head>
  <body>
  
  <form action="/client" method="post"> 
			<input type="submit" class="button red big" value="Back to Client Main"  /> 			
		</form>	
  
    <h3>Route to your car</h3>
    <div id="map-canvas"></div>
	<p id="demo"></p>

    <script>
	
	  


	
      
	  function getQueryVariable(variable) {
  var query = window.location.search.substring(1);
  var vars = query.split("&");
  for (var i=0;i<vars.length;i++) {
    var pair = vars[i].split("=");
    if (pair[0] == variable) {
      return pair[1];
	  
    }
  } 
  alert('Query Variable ' + variable + ' not found');
}
	  
function initMap() {
	var startLat = Number(getQueryVariable('param1'));
	var startLong = Number(getQueryVariable('param2'));
	var endLat = Number(getQueryVariable('param3'));
	var endLong = Number(getQueryVariable('param4'));
  var pointA = new google.maps.LatLng(startLat, startLong),
    pointB = new google.maps.LatLng(endLat, endLong),
    myOptions = {
      zoom: 7,
      center: pointA
    },
    map = new google.maps.Map(document.getElementById('map-canvas'), myOptions),
    // Instantiate a directions service.
    directionsService = new google.maps.DirectionsService,
    directionsDisplay = new google.maps.DirectionsRenderer({
      map: map
    }),
    markerA = new google.maps.Marker({
      position: pointA,
      title: "point A",
      label: "A",
      map: map
    }),
    markerB = new google.maps.Marker({
      position: pointB,
      title: "point B",
      label: "B",
      map: map
    });
	

  // get route from A to B
  calculateAndDisplayRoute(directionsService, directionsDisplay, pointA, pointB);
  getDistance();
  var x = int;
	x=7;
	document.write(x.value);
	document.getElementById("demo").innerHTML = getDistance(startLat, startLong, endLat,  endLong);
    document.write(getDistance(startLat, startLong, endLat,  endLong));
	

}




function calculateAndDisplayRoute(directionsService, directionsDisplay, pointA, pointB) {
  directionsService.route({
    origin: pointA,
    destination: pointB,
    travelMode: google.maps.TravelMode.WALKING
  }, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    } else {
      window.alert('Directions request failed due to ' + status);
    }
  });
}

	


    </script>
     
    <script src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAF7BBR6bYKCFpBcGLQEWcYqXBjlWTlLLM&callback=initMap">
    </script>
	

  </body>
</html>