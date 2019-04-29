<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Distance</title>
</head>
<body>
		La distance est de : <%= request.getAttribute("distance") %> km
		
		
		<br>
		
		<form type="post" action="Client.jsp">
				<input type="submit" value="Retour à la sélection des villes" name="submitButton"/>
    			</form>
</body>
</html>