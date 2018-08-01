<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>homePage</title>
	<link rel="stylesheet" type="text/css" href="../css/style.css">
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
                        <a class="nav-link" href="#">Home</a>
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
      <img src="../img/header.png" width="100%"/>
         </div>
            

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-sm-8">
                <h2 class="mt-4">Welcome <c:out value="${ parent.fname }" /></h2>
                <p>Please choose below what you want to do today.<p>
            </div>
          
        </div>
        <!-- /.row -->
<hr>
        <div class="row">
            <div class="col-sm-4 my-4">
                <div class="card">
                
                
                    <img class="card-img-top" src="../img/nanny.gif">
                    <div class="card-body">
                        <h4 class="card-title">Find a Nanny</h4>
                        <p class="card-text">You need a Nanny? Click here and find available Nannies.</p>
                    </div>
                    <div class="card-footer">
                        <a href="/parent/findNanny" class="btn btn-info">Find a Nanny!</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 my-4">
                <div class="card">
                    <img class="card-img-top" src="../img/review.gif">
                    <div class="card-body">
                        <h4 class="card-title">Review a Nanny</h4>
                        <p class="card-text">Please share your experience with one of your Nanny's you booked previously and help other people!</p>
                    </div>
                    <div class="card-footer">
                        <a href="/parent/review/${parentId}" class="btn btn-info">Review now!</a>
                    </div>
                </div>
            </div>
            <div class="col-sm-4 my-4">
                <div class="card">
                    <img class="card-img-top" src="../img/profile.gif">
                    <div class="card-body">
                        <h4 class="card-title">Edit your profile</h4>
                        <p class="card-text">Click here if you want to update your profile.</p>
                    </div>
                    <div class="card-footer">
                        <a href="/parent/edit/${parentId}" class="btn btn-info">Update your Profile!</a>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.row -->

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