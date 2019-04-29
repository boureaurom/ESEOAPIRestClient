package com.ESEOAPIRestClient.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ESEOAPIRest.blo.Ville;
import com.ESEOAPIRestClient.dto.DTOVille;

/**
 * Servlet implementation class ModifierVilleServlet
 */
@WebServlet("/ModifierVilleServlet")
public class ModifierVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Ville ville = new Ville();
		ville.setCodeCommuneINSEE(request.getParameter("nouveauCodeCommuneINSEE"));
		ville.setNomCommune(request.getParameter("nomCommune"));
		ville.setCodePostal(request.getParameter("codePostal"));
		ville.setLibelleAcheminement(request.getParameter("libelleAcheminement"));
		ville.setLigne5(request.getParameter("ligne5"));
		ville.setLatitude(request.getParameter("latitude"));
		ville.setLongitude(request.getParameter("longitude"));
		
		
		DTOVille dto = new DTOVille();
		dto.modifierVille(request.getParameter("ancienCodeCommuneINSEE"), ville);
		
		
		response.sendRedirect("tableauVille.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
