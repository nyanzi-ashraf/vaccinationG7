<!DOCTYPE html>
<%@page language="java" import="java.util.*" %>
<%@ taglib uri="WEB-INF/tld/booking/vaccine.tld" prefix="vaccination" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
</head>
<body>

<div class="container-fluid p-0">
	<div class="bg-light pl-5 pt-5" style="height: 50vh;">VACCINATE</div>
</div>
<div class="d-flex justify-content-end p-2">
	<a href="register_patients" class="text-decoration-none"><button class="btn btn-primary">add patient</button></a>
</div>


<div class="text-center">
	<h3 class="text-danger">PATIENTS</h3>
</div>


<div class="container d-flex justify-content-center">
	<vaccination:select table="patients"/>
</div>

<script src="bootstrap/js/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
