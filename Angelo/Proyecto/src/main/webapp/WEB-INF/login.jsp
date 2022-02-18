<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
	<head>
		<html lang="es"></html>
		<meta charset="UTF-8">
		<title>Login TuttiTask</title>
		<link rel="stylesheet" type="text/css" href="/css/login.css">
	</head>
	<body>
		<div class="namePage">
			<h1>Tutti-Task</h1>
			<img class="spinning"src="/css/LogoTuttiTask.png" alt="logo" width="100px">
		</div>
		
		<div class="sesion">
			<h1 class="login"> Login</h1>
			<c:if test="${error != null}">
				<c:out value="${error}"></c:out>
			</c:if>
				<c:out value="${errorMessage}"></c:out>
				<form method="POST" action="/login">
					<p>
						<input class="l" placeholder="Email" type="email" id="email" name="username"/>
					</p>
					<p>
						<input class="l"placeholder="Password" type="password" id="password" name="password"/>
					</p>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<input class="btn-primary" type="submit" value="Login"/>
				</form>
		</div>

	</body>
</html>