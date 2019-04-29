<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Ville</title>
</head>
<body>
		<form method="post" action="AjouterVilleServlet">
			
			Code Commune INSEE :     <input type="text" value="" name="nouveauCodeCommuneINSEE" id="nouveauCodeCommuneINSEE"><br>
			Nom :                    <input type="text" value="" name="nomCommune" id="nomCommune"><br>
			Code Postal :            <input type="text" value="" name="codePostal" id="codePostal"><br>
			Libelle d'acheminement : <input type="text" value="" name="libelleAcheminement" id="libelleAcheminement"><br>
			Ligne 5 :                <input type="text" value="" name="ligne5" id="ligne5"><br>
			Latitude :               <input type="text" value="" name="latitude" id="latitude"><br>
			Longitude :              <input type="text" value="" name="longitude" id="longitude"><br>
			<input type="submit" value="Confirm" name="submitButton" id="submitButton">
		</form>
</body>
</html>