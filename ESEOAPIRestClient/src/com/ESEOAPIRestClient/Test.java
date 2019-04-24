package com.ESEOAPIRestClient;

import org.springframework.web.client.RestTemplate;

import com.ESEOAPIRest.blo.Ville;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Ville ville = new Ville();
		ville.setCodeCommuneINSEE("01003");
		ville.setCodePostal("53800");
		ville.setLatitude("test");
		ville.setLibelleAcheminement("test");
		ville.setLigne5("test");
		ville.setLongitude("test");
		ville.setNomCommune("Congrier");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForLocation("http://localhost:8181/post", ville);
	}

}
