package com.ESEOAPIRest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
	public static Connection connexion;
	public static Connection getInstance() {
		if(connexion!=null) {
			return connexion;
		}else {
			try {
				connexion = DriverManager.getConnection(null, null, null );
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connexion;
		}
	}
	public void disconnect() {
		try {
			Connexion.getInstance().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
