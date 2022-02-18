<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="src/main/resources/static/css/tuttitask.css">
		<title>TuttiTask</title>
	</head>
	<body>
		<div class= "container">
			<div class="namePage">
				<h1>Tutti-Task</h1>
				<img class="spinning" src="src/main/resources/static/css/LogoTuttiTask.png" alt="logo" width="100px">
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
					<a href="#">Facebook</a>
					<a href="#">Instagram</a>
					<a href="#">Twitter</a>
				</div>
			</footer>
		</div>
	</body>
</html>