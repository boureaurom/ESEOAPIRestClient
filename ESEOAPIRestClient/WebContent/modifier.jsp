<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ESEOAPIRest.blo.*"%>
<%@page import="com.ESEOAPIRestClient.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier Ville</title>
</head>
<body>
		<%
		DTOVille dto = new DTOVille();
		Ville[] villeSelectionne = dto.getAvecFiltre(1, String.valueOf(request.getAttribute("CodeCommuneINSEE")) );
		System.out.println(villeSelectionne[0].toString());
		%>
		<form method="post" action="ModifierVilleServlet">
			
			Code Commune INSEE :     <input type="text" value="<%= villeSelectionne[0].getCodeCommuneINSEE() %>" name="nouveauCodeCommuneINSEE" id="nouveauCodeCommuneINSEE"><br>
			Nom :                    <input type="text" value="<%= villeSelectionne[0].getNomCommune() %>" name="nomCommune" id="nomCommune"><br>
			Code Postal :            <input type="text" value="<%= villeSelectionne[0].getCodePostal() %>" name="codePostal" id="codePostal"><br>
			Libelle d'acheminement : <input type="text" value="<%= villeSelectionne[0].getLibelleAcheminement() %>" name="libelleAcheminement" id="libelleAcheminement"><br>
			Ligne 5 :                <input type="text" value="<%= villeSelectionne[0].getLigne5() %>" name="ligne5" id="ligne5"><br>
			Latitude :               <input type="text" value="<%= villeSelectionne[0].getLatitude() %>" name="latitude" id="latitude"><br>
			Longitude :              <input type="text" value="<%= villeSelectionne[0].getLongitude() %>" name="longitude" id="longitude"><br>
			<input type="hidden" value=<%= request.getAttribute("CodeCommuneINSEE") %> name="ancienCodeCommuneINSEE" id="ancienCodeCommuneINSEE">
			<input type="submit" value="Confirm" name="submitButton" id="submitButton">
		</form>
</body>
</html>