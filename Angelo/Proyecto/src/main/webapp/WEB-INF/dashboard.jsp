<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	   <meta charset="UTF-8">
		<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	    <title>Lobby</title>
</head>
<body>
<h1>Bienvenido a Tutti-Task,  <c:out value="${usuario.name}"/> <c:forEach items="${usuario.roles}"> <c:out value="${name}"/></c:forEach>  </h1>
	<a href="/admin/crear">Crear tarea</a>
	<h2>tareas Creadas</h2>
	<table class="table">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Descripcion</th>
					<th>Tiempo Estimado</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tareas}" var="tarea">
				<tr>
					<td scope="col"> <c:out value="${tarea.nombre}"/> </td>
					<td> <c:out value="${tarea.descripcion}"/> </td>
					<td> <c:out value="${tarea.tiempo}"/></td>
					<td style="display: flex;"> <a class="btn btn-primary" href="/admin/editar/<c:out value="${tarea.id}"/>" role="button">Edit</a> 
					     <form:form id="delete" action="/admin/delete/${tarea.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <button  class="btn btn-danger" type="button" onclick="sure()"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
						  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
						  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
						</svg>
					</button>
				</form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<script type="text/javascript">
			function sure() {	
				Swal.fire({
					  title: 'Are you sure you wanna delete this?',
					  text: "You won't be able to revert this!",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Yes, delete it!'
					}).then((result) => {
					  if (result.isConfirmed) {
					    document.getElementById("delete").submit();
					    
					
					      
					    
					  }
					})
			}
		</script>
</body>
</html>