<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Task</title>
</head>
	<body>
		<form method="POST" action="/results">         
           <label style="width: 130px" for="nombre">Name:</label>
                <input type="text" id="nombre" name="nombre" style="width: 130px">
           <br>
            <label for="city" style="width: 130px">
            	<span>Dojo Location :</span>
            </label>
            <select id="cities" name="city" style="width: 130px">
                <option value="sanj">San Jose</option>
                <option value="santiago">santiago</option>
                <option value="temuco">temuco</option>
            </select>
	        <br>
	        <label for="Lenguaje" style="width: 130px">
	           <span>Favorite Lenguage :</span>
	       </label>
			<select id="Lenguaje" name="favorite" style="width: 130px">
                <option value="HTML">HTML</option>
                <option value="javascript">javascript</option>
                <option value="CSS">CSS</option>
                <option value="Phyton">Phyton</option>
                <option value="PHP">PHP</option>
                <option value="Java">Java</option>
                <option value="CC">CC</option>
                <option value="C">C</option>
             </select>
	             
	        <br>  
               <p>Coments (optional)</p>
                    <textarea name="coment" style="height: 100px; width: 250px; resize: none;" maxlength="200"></textarea>
           <br>
            <input type="submit" value="Sent" style="display: block;"/>
		</form>
	
	</body>
</html>