<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Tarea</title>
		 <link rel="stylesheet" type="text/css" href="/css/crearTarea.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body class="container">
		<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
		  </li>
		 </ul>
         <div class="namePage">
            <img class="spinning"src="/css/LogoTuttiTask.png" alt="logo" width="100px">
            <h1 class="logo">Tutti-Task</h1>
            <h3 class="tarea">Crear Tarea</h3>
		
		</div>

	    <p><form:errors path="tarea.*"/></p>
    
  	<form:form action="/admin/${tarea.id}" method="POST" modelAttribute="tarea">
    	<input type="hidden" name="_method" value="PUT">
	         <p class="form-group">
	            <form:label class="form-label" path="nombre">Nombre :</form:label>
	            <form:errors path="nombre"/>
	            <form:input type="name" class="form-control"  path="nombre"/>
	        </p>
	          <p class="form-group">
	            <form:label class="form-label" path="descripcion">Descripcion :</form:label>
	             <form:errors path="descripcion"/>
	            <form:input type="text" class="form-control" path="descripcion"/>
	        </p>
	        <p  class="form-group" >
	            <form:label class="form-label" path="tiempo">Tiempo Estimado :</form:label>
	             <form:errors path="tiempo"/>
	            <form:input type="text" class="form-control" path="tiempo"/>
	        </p>  	
	       
	       <input class="btn" style="background-color: #a81f91" type="submit" value="Guardar Cambios"/>
    </form:form>
	

</body>
</html>