<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<title>Registro administrador</title>
	</head>
	<body>
		<div style="width: 35rem;">
	<h1>Registrarse!</h1>
    
    <p><form:errors path="admin.*"/></p>
    
    <form:form  method="POST" action="/registrar" modelAttribute="admin">
        <div class="row">
	         <p class="col">
	            <form:label class="form-label" path="name">Nombre :</form:label>
	            <form:input type="name"  class="form-control" path="name"/>
	        </p>
	          <p class="col">
	            <form:label class="form-label" path="lastName">Apellido :</form:label>
	            <form:input type="lastName" class="form-control" path="lastName"/>
	        </p>
	     </div>
	     <div class="row">   
	        <p class="col">
	            <form:label class="form-label" path="email">Email:</form:label>
	            <form:input type="email" class="form-control" path="email"/>
	        </p>  
	    </div>
	    <div class="row">    	
	        <p class="col">
	            <form:label path="password">Contraseña :</form:label>
	            <form:password  class="form-control" path="password"/>
	        <p class="col">
	        <p>
	            <form:label path="passwordConfirm">Confirme su Contraseña :</form:label>
	            <form:password  class="form-control" path="passwordConfirm"/>
	        </p>
	    </div>    
	       
	        <input class="btn-primary" type="submit" value="Registrar!"/>
    </form:form>
	</div>
		
	
	</body>
</html>