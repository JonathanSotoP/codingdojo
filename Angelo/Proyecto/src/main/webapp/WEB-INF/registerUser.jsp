<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registro administrador</title>
        <link rel="stylesheet" type="text/css" href="/css/login.css">
	</head>
	<body>
		<div class="namePage">
			<h1>Tutti-Task</h1>
			<img class="spinning" src="/css/LogoTuttiTask.png" alt="logo" width="100px">
		</div>
		<p><form:errors path="user.*"/></p>
		<div class="container" >
            <h1 class="registro">Registro</h1>
			<form:form  method="POST" action="/registrarUsuario" modelAttribute="user">
				<form:label class="form-label" path="name">Nombre :</form:label>
	            <form:input class="l" placeholder="Nombres" type="text" id="nombre" name="username" path="name"/>

				<form:label class="form-label" path="lastName">Apellido :</form:label>
	            <form:input class="l" placeholder="Apellidos" type="Apellidos" id="Apellidos" name="username" path="lastName"/>
	    
				<form:label class="form-label" path="email">Email:</form:label>
	            <form:input class="l" placeholder="Ingrese su correo Electronico" type="email" id="email" name="username" path="email"/>
	    
				<form:label path="password">Contraseña :</form:label>
	            <form:password  class="l"  id="password"   path="password"/>


				<form:label path="passwordConfirm"> Confirme su Contraseña :</form:label>
                <form:password  class="l" id="password confirm"  path="passwordConfirm"/>
	        
	    
	       
	        <input class="btn" type="submit" value="Registrarse"/>
		</form:form>
	    </div>
		
	
	</body>
</html>