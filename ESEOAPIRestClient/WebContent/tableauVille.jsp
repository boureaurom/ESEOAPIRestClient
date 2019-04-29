<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.ESEOAPIRest.blo.*"%>
<%@page import="com.ESEOAPIRestClient.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Affichage Villes</title>
</head>
<body>
		<a href="Client.jsp">Calcul Distance</a>
		<%
		DTOVille dto = new DTOVille();
		Ville[] toutesVille = dto.getTouteVilles();
		%>
		<form type="post" action="ajouter.jsp">
				<input type="submit" value="New" name="submitButton"/>
    			</form>
		<table id="table">
		
		<tr>
    		<td >Code Commune Insee</td>
			<td >Nom Commune</td>
			<td >Code Postal</td>
			<td >Libelle Acheminement</td>
			<td >Ligne 5</td>
			<td >Latitude</td>
			<td >Longitude</td>
			<td ><button id="previous1"><</button></td>
			<td ><button id="next1">></button></td>
    		
    	</tr>
		<%
		int index;
		if(request.getParameter("index")!=null){
			
		
		index=Integer.valueOf(request.getParameter("index"));
		}else{
			index=0;
		}
    	if(index>toutesVille.length-50){
    		index=toutesVille.length-50;
    	}else if(index<0){
    		index=0;
    	}
		
		
    	for(int i=0; i<50;i++){
    		
    		%>
    		<tr>
    		<td id="row<%=i%>column1"><%= toutesVille[i+index].getCodeCommuneINSEE() %></td>
			<td id="row<%=i%>column2"><%= toutesVille[i+index].getNomCommune() %></td>
			<td id="row<%=i%>column3"><%= toutesVille[i+index].getCodePostal() %></td>
			<td id="row<%=i%>column4"><%= toutesVille[i+index].getLibelleAcheminement() %></td>
			<td id="row<%=i%>column5"><%= toutesVille[i+index].getLigne5() %></td>
			<td id="row<%=i%>column6"><%= toutesVille[i+index].getLatitude() %></td>
			<td id="row<%=i%>column7"><%= toutesVille[i+index].getLongitude() %></td>
			<td id="row<%=i%>column8">
				<form type="post" action="ModifierRedirectionServlet">
				<input type="hidden" value=<%= toutesVille[i+index].getCodeCommuneINSEE() %> name="CodeCommuneINSEE" id="CodeCommuneINSEE">
				<input type="submit" value="Modify" name="submitButton"/>
    			</form>
			
			</td>
			<td id="row<%=i%>column9">
				<form type="post" action="SupprimerVilleServlet">
				<input type="hidden" value=<%= toutesVille[i+index].getCodeCommuneINSEE() %> name="CodeCommuneINSEE" id="CodeCommuneINSEE">
				<input type="submit" value="Delete" name="submitButton"/>
    			</form>
			</td>
			
    		
    		</tr>
    		<% 
    	}
    
    %>
		
		</table>
		<button id="previous2"> < </button>
		<button id="next2">></button>
		
		
		<script type="text/javascript">
		
		function nextButton(){
			var index = <%= index %>+50;
			changeUrl(index);
		}
		function previousButton(){
			var index = <%= index %>-50;
			changeUrl(index);
		}
		function changeUrl(index){
			
			console.log(window.location);
			window.location = "http://"+window.location.hostname+":"+window.location.port + window.location.pathname+"?index=" + index;
		}
		document.getElementById("previous1").onclick = function(){previousButton()};
		document.getElementById("next1").onclick = function(){nextButton()};
		document.getElementById("previous2").onclick = function(){previousButton()};
		document.getElementById("next2").onclick = function(){nextButton()};
		</script>
		
</body>
</html>