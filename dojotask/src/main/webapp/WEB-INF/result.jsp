<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey Results</title>
</head>
<body>
	<h2>Summited info</h2>
	<h3>Name :                   <c:out value="${name}"></c:out></h3>
	<h3>Dojo Location :          <c:out value="${city}"></c:out></h3>
	<h3>Favorite Language :      <c:out value="${favorite}"></c:out></h3>
	<h3>Coments                  <c:out value="${coment}"></c:out></h3>
	<button><a href="http://localhost:8080/"></a> go back</button>

</body>
</html>