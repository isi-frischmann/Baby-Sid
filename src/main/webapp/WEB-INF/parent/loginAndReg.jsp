<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registration Page</title>
	<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<div class="leftSide">    
	<h1>You have Kids?</h1> <br> 
    <h3>And you need someone - <br>
    who takes care of them?</h3>
   
    <br>
    <h3>Register!</h3>
    
    <p><form:errors path="user.*"/></p>
    
   <form:form method="POST" action="/parent/registration" modelAttribute="parent">
        <p>
            <form:label path="fname">First Name:</form:label>
            <form:input type="text" path="fname"/>
        </p>
        
        <p>
            <form:label path="lname">Last Name:</form:label>
            <form:input type="text" path="lname"/>
        </p>
        
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        
        <p>
            <form:label path="phone">Phone:</form:label>
            <form:input type="number" path="phone"/>
        </p>
        
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
    
    <br>
    <h3>Login</h3>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/parent/login">
        <p>
            <label type="email" for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form> 
	</div>
	
	<!--  NANNY REGISTER -->
	
	<div class="rightSide">    
	<h1>Become a Nanny</h1> <br> 
    <h3>Or Login as an Nanny to take care!</h3>
   
    <br>
    <h3>Register!</h3>
    
    <p><form:errors path="nanny.*"/></p>
    
    <form:form method="POST" action="/nanny/registration" modelAttribute="nanny">
        <p>
            <form:label path="fname">First Name:</form:label>
            <form:input type="text" path="fname"/>
        </p>
        
        <p>
            <form:label path="lname">Last Name:</form:label>
            <form:input type="text" path="lname"/>
        </p>
        
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
        </p>
        
        <p>
            <form:label path="phone">Phone:</form:label>
            <form:input type="number" path="phone"/>
        </p>
        
        <p>
            <form:label path="zipCode">Zip code:</form:label>
            <form:input type="text" path="zipCode"/>
        </p>
        
        <p>
            <form:label path="address">City:</form:label>
			<form:input type="text" path="address"/>        
		</p>
        
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
    
    <br>
    <h3>Login</h3>
    <p><c:out value="${error}" /></p>
    <form method="post" action="/nanny/login">
        <p>
            <label type="email" for="email">Email</label>
            <input type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="submit" value="Login"/>
    </form> 
	</div>
	
	
</body>
</html>