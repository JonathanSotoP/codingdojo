<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/mostrarTarea.css">
	<title>${tarea.nombre}</title>
	</head>
	<body>
		<div class="container">
			<div class="namePage">
				<h1>Tutti-Task</h1>
				<img class="spinning" src="/css/LogoTuttiTask.png" alt="logo" width="100px">
			</div>
		<h2> Nombre:  <c:out value="${tarea.nombre}"/> </h2>
		<h2> Descripción:  <c:out value="${tarea.descripcion}"/> </h2>
		<h2> Tiempo Estimado:  <c:out value="${tarea.tiempo}"/></h2>
		<table class="table">
				<thead>
					<tr>
						<th >Nombre </th>
						<th >apellido </th>
						<th >Registro </th> 
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tarea.usuarios}" var="user">
					<tr>
						<td scope="col"><c:out value="${user.name}"/> </td>
						<td > <c:out value="${user.lastName}"/> </td>
						<td ><c:out value="${user.createdAt}"/></td>

						</tr>
						</c:forEach>
				</tbody>
		</table >
		</div>
		
	
	</body>
</html>