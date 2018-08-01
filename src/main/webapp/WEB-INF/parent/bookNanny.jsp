<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book Nanny</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- Include jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	
</head>
<body>

	   <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">BabySid</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="/parent/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Header with Background Image -->
    <div class="imgHeader">
      <img src="/img/header.png" width="100%"/>
         </div><br>
         
         
  <div class="container">

<!-- Contaict information about the nanny -->

<h2 class="mt-4">Details from your choosen Nanny: <c:out value="${ showNanny.fname } ${ showNanny.lname }"/></h2>

<div class="leftSide">
  <div class="row">
      <div class="col-sm-8">
          <p>Address: <c:out value="${ showNanny.address }"/></p><br>
          <p>Phone: <c:out value="${ showNanny.phone }"/></p><br>
          <p>E-Mail: <c:out value="${ showNanny.email }"/></p><br>
          <p>Review: </p>
  </div>
</div>
</div>
<!-- Professional experience about the Nanny -->
<div class="rightSide">
      <div class="col-sm-8">
          <br><p>Experience:</p><br>
          <p>Average Rating:</p><br>
          <p>Maximal Kids:</p><br>
          <p>Age range:</p>
          <p>Pets:</p>
          <p>Pick Up (with range):</p>
  </div>
</div>

<div class="bootstrap-iso">
 <div class="container-fluid">
  <div class="row">
   <div class="col-md-6 col-sm-6 col-xs-12">
   
   <!-- start from the form when you want to book a nanny -->
    <form method="post" action="/parent/bookNanny/${nannyId}">
     <div class="form-group ">
      <label class="control-label requiredField" for="date">
       Date
       <span class="asteriskField">
        *
       </span>
      </label>
      <div class="input-group">
       <div class="input-group-addon">
        <i class="fa fa-calendar">
        </i>
       </div>
       <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text"/>
      </div>
     </div>
     <div class="form-group">
      <div>
       <button class="btn btn-dark" name="submit" type="submit">
        Book Nanny
       </button>
      </div>
     </div>
    </form>
   </div>
  </div>
 </div>
</div>



<script>
    $(document).ready(function(){
        var date_input=$('input[name="date"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        })
    })
</script>
</body>
</html>