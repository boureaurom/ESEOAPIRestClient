<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ESEOAPIRest.blo.*"%>
<%@page import="com.ESEOAPIRestClient.dto.*"%>
<%@page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Villes</title>
</head>
<body>

	<a href="tableauVille.jsp">Liste des Villes</a>
	<%
		DTOVille dto = new DTOVille();
		Ville[] toutesVille = dto.getTouteVilles();
// 		Ville[] villes = dto.getAvecFiltre(3, "01400");
		
// 		for(int i=0;i<villes.length;i++){ 
 			%>	 
		
<%-- 			Ville : <%= villes[i].toString() %> --%>
<%-- 			<% } %> --%>

	

    <form type="post" action="CalculDistanceServlet">
    <SELECT name="ville1" size="1">
    <%
    	
    	
    	for(int i=0; i<toutesVille.length;i++){
    		%>
    		<OPTION name=<%= toutesVille[i].getCodeCommuneINSEE() %>> <%= toutesVille[i].getCodePostal() %> - <%= toutesVille[i].getNomCommune() %>
    		<% 
    	}
    
    %>
    </SELECT>
    <SELECT name="ville2" size="1">
    <%
    	
    	
    	for(int i=0; i<toutesVille.length;i++){
    		%>
    		<OPTION name=<%= toutesVille[i].getCodeCommuneINSEE() %>> <%= toutesVille[i].getCodePostal() %> - <%= toutesVille[i].getNomCommune() %>
    		<% 
    	}
    
    %>
    </SELECT>
    <input type="submit" value="Confirm" name="submitButton"/>
    </form>
	
</body>
</html>