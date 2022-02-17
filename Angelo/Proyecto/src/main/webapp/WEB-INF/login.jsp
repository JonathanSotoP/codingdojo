<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login TuttiTask</title>
</head>
<body>
	    <div style="display:inline-block; width:25rem;margin: 13rem;">
	    <h1>Login</h1>
    	 <c:if test="${error != null}">
   			 <c:out value="${error}"></c:out>
    	</c:if>
	        <c:out value="${errorMessage}"></c:out>
			<form method="POST" action="/login">
				<p>
				    <label for="email">Email</label>
				    <input type="email" id="email" name="username"/>
				</p>
				<p>
				    <label for="password">Password</label>
				    <input type="password" id="password" name="password"/>
				</p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input class="btn-primary" type="submit" value="Login!"/>
			</form>
    </div>

</body>
</html>