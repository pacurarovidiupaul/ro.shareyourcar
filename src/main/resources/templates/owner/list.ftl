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
  <div class="panel-heading">Owner Main</div>
 
  <table class="table">
	<tr>
		<th>Your Profit</th>
		<th></th>
		
	</tr>
	<!-- begin iteration -->
	[#if owners??]
		[#list owners as owner] 
			<tr>
				<td>${owner.profit}</td>
				<td><a href="/owner/edit?id=${owner.id?c}">
				<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
				</a></td>
				<td><a href="/car/add">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> CAR
				</a></td>
			</tr>
		[/#list]
	[/#if]
	
	<!-- end iteration -->
		

</table>
</div>
<form action="/home" method="post">
			<input type="submit" class="button red big" value="Sign OUT" /> 
		</form>	

[/#escape]
