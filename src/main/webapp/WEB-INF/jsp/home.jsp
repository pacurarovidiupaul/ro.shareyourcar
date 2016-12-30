<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="<spring:url value="css/app.css" />" rel="stylesheet"
	type="text/css">
<title>Share your car!</title>
</head>
<body class="bmw">
       <div class="details">
			<a href="/owner/" class="button green small">Login IN as Owner</a>
			<a href="/client/" class="button red small">Login IN as Client</a>
		
		</div>
	<div class="details">
		<a href="/owner/add" class="button green small">Sign UP for Owner</a> 
		<a href="/client/add" class="button red small">Sign UP for Client </a>
	</div>

	</div>
</body>
</html>