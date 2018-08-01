<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rate a Nanny</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css"> 	 
</head>
<body>
	
	   <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">   
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
    </nav>

    <!-- Header with Background Image -->
    <div class="imgHeader">
      <img src="/img/header.png" width="100%"/>
         </div>
            

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-sm-8">
                <h2 class="mt-4">All your previous booked Nanny's!<br>
                You can also rate them</h2>
            </div>
        </div>
        <!-- /.row -->
<hr>


		<table class="table table-dark">
		  <thead>
		    <tr>
		      <th scope="col">Nanny</th>
		      <th scope="col">Location</th>
		      <th scope="col">Booked</th>
		      <th scope="col">Rate</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${showSpecNanny}" var="n">
		    <tr>
		      <td><c:out value="${ n.getFname }" /></td>
		      <td><c:out value="${ n.address }" /></td>
		      <td><c:out value="${ n.date }" /></td>
		    </tr>
		    </c:forEach>
		  </tbody>
		</table>

    </div>
    
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
        <div class="container">
            <p class="m-0 text-center text-white">© babySid 2018</p>
        </div>
        <!-- /.container -->
    </footer>
</body>
</html>