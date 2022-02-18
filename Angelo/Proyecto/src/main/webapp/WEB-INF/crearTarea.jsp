<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html style="background-color:black;">
	<head >
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<link rel=stylesheet type="text/css" href="CSS/index.css">
		<title>Nuevo Curso</title>
	</head>
	<body class="container">
		<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="/dashboard">Dashboard</a>
		  </li>
		 </ul>
		<h1>Crear Tarea!</h1>
    
    <p><form:errors path="tarea.*"/></p>
    
    <form:form  style="width:35rem;" method="POST" action="/admin/crearTarea" modelAttribute="tarea">
	         <p class="form-group">
	            <form:label class="form-label" path="nombre">Nombre :</form:label>
	            <form:input type="name" class="form-control"  path="nombre"/>
	        </p>
	          <p class="form-group">
	            <form:label class="form-label" path="descripcion">Descripcion :</form:label>
	            <form:input type="text" class="form-control" path="descripcion"/>
	        </p>
	        <p  class="form-group" >
	            <form:label class="form-label" path="tiempo">Tiempo Estimado :</form:label>
	            <form:input type="text" class="form-control" path="tiempo"/>
	        </p>  	
	       
	       <form:input type="hidden" path="usuarioCreador.id"  value="${usuario}"/> 
	        <input class="btn-primary" type="submit" value="Crear!"/>
    </form:form>
	
	</body>
</html>