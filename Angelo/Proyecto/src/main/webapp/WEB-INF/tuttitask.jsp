<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="/css/tuttitask.css">
		<title>TuttiTask</title>
	</head>
	<body>
		<div class= "container">
			<div class="namePage">
				<h1>Tutti-Task</h1>
				<img class="spinning" src="/css/LogoTuttiTask.png" alt="logo" width="100px">
			</div>
			
				<hr>
				<a class="registerUser" href="/registerUser">¡Registrarse como Usuario!</a>
				<hr>
				<a class="registerAdmin" href="/registerAdmin">¡Registrarse como Empresa!</a>
				<hr>
				<button class="login"><a href="/login"> Login</a></button>
				<hr>

			<div class="mission">
				<h2>Nuestra misión</h2>
				<p>Tutti-Task es una aplicación pensada para mejorar la productividad asignando y gestionando las tareas de un equipo de trabajo en una microempresa, mantiendo un aspecto de fácil manejo para el usuario, en el cual se genera un
					check-List de las tareas asignadas por un administrador, quien después deberá confirmar una vez éstas estén realizadas.
					</p>
				<hr>
			</div>

			<footer>
				<div class="social">
					<a  target="_blank" href="https://www.facebook.com/profile.php?id=100077987547848">Facebook</a>
					<a href="">Instagram</a>
					<a target="_blank" href="https://twitter.com/TuttiTask">Twitter</a>
				</div>
			</footer>
		</div>
	</body>
</html>