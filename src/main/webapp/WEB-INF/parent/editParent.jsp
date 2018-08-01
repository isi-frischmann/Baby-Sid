<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page isErrorPage="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous"> 
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit your profile</title>
	<link rel="stylesheet" href="/css/style.css">
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
                <h2 class="mt-4">Edit your Profile</h2>
            </div>
        </div>
        <!-- /.row -->
        
        
        <!-- Edit the profile information from the parent -->
        
		<form:form action="/parent/update/${parentId}" method="post" modelAttribute="updateParent">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label path="fname">First name: </form:label>
			<form:errors path="fname"/>
			<form:input path="fname"/>
		</p> 
		
		<p>
			<form:label path="lname">Last name: </form:label>
			<form:errors path="lname"/>
			<form:input path="lname"/>
		</p>
		
		<p>
			<form:label path="email">Email: </form:label>
			<form:errors path="email"/>
			<form:input path="email"/>
		</p>
		
		<p>
			<form:label path="phone">Phone: </form:label>
			<form:errors path="phone"/>
			<form:input path="phone"/>
		</p>
		
		<p>
			<form:label path="amountKid">How many Kids do you have: </form:label>
			<form:errors path="amountKid"/>
			<form:input path="amountKid"/>
		</p>
			
		<input type="submit" value="Submit"/>
		
		</form:form>
  
        
        
<hr>
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