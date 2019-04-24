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
 * Servlet implementation class CalculDistanceServlet
 */
@WebServlet("/CalculDistanceServlet")
public class CalculDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculDistanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String idVille1=request.getParameter("ville1");
		String idVille2=request.getParameter("ville2");
		System.out.println("#ville1 : "+idVille1);
		System.out.println("#ville2 : "+idVille2);
		String villeName1=idVille1.split("-")[1].trim();
		String villeName2=idVille2.split("-")[1].trim();
		System.out.println("#ville1 : "+villeName1);
		System.out.println("#ville2 : "+villeName2);
		DTOVille dto = new DTOVille();
		Ville ville1 = dto.getAvecFiltre(2, villeName1)[0];
		Ville ville2 = dto.getAvecFiltre(2, villeName2)[0];
		System.out.println("#ville1 latitude: "+ville1.getLatitude());
		System.out.println("#ville1 longitude: "+ville1.getLongitude());
		System.out.println("#ville2 latitude: "+ville2.getLatitude());
		System.out.println("#ville2 longitude: "+ville2.getLongitude());
		double ville1Latitude= Double.parseDouble(ville1.getLatitude());
		double ville1Longitude= Double.parseDouble(ville1.getLongitude());
		double ville2Latitude= Double.parseDouble(ville2.getLatitude());
		double ville2Longitude= Double.parseDouble(ville2.getLongitude());
		double result=(6378.137)*Math.acos(Math.sin(Math.toRadians(ville1Latitude))*Math.sin(Math.toRadians(ville2Latitude))+Math.cos(Math.toRadians(ville1Latitude))*Math.cos(Math.toRadians(ville2Latitude))*Math.cos(Math.toRadians(ville2Longitude-ville1Longitude)));
		System.out.println(result);
		request.setAttribute("distance", result);
		request.getRequestDispatcher("affichageDistance.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
