[#ftl]
[#import "/spring.ftl" as spring /]
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Car</title>
    <link  href="[@spring.url '/css/bootstrap.min.css' /]" rel="stylesheet">
     <link href="[@spring.url '/css/signup.css' /]" rel="stylesheet" type="text/css">
     
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="[@spring.url '/js/bootstrap.min.js' /] "></script>
    <style>
       #map {
        height: 400px;
        width: 50%;
       }
    </style>
  </head>

<body>

<form action="/owner" method="post"> 
			<input type="submit" class="btn btn-primary" value="Back to Owner Main"  /> 			
		</form>	

<h3>Car location</h3>
    <div id="map"></div>
	
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
	    var lats = Number(getQueryVariable('param1'));
		var longs = Number(getQueryVariable('param2'));
        var uluru = {lat: lats , lng: longs};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 18,
          mapTypeId:google.maps.MapTypeId.HYBRID,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
          
        });
        var infowindow = new google.maps.InfoWindow({
  		  content: "lat= " + getQueryVariable('param1') + " long= " + getQueryVariable('param2')
  		});
  		infowindow.open(map,marker);
      }
        map.setTilt(30);
      
      
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key= AIzaSyAF7BBR6bYKCFpBcGLQEWcYqXBjlWTlLLM&callback=initMap">
    </script>
</body>
