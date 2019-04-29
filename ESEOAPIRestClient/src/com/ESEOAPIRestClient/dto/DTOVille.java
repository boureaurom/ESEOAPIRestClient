package com.ESEOAPIRestClient.dto;


import java.applet.Applet;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.web.client.RestTemplate;


import com.ESEOAPIRest.blo.Ville;

public class DTOVille {
	
	public Ville[]getTouteVilles() throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		String filename="../resources/application.properties";
		
		input = DTOVille.class.getResourceAsStream(filename);
		if(input!=null){
		prop.load(input);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("#properties : "+prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port"));
		Ville[] villes= restTemplate.getForObject(prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port")+"/get", Ville[].class);
		return villes;
		}else {
			return null;
		}
	}
	public Ville[]getAvecFiltre(int filter, String value) throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		String filename="../resources/application.properties";
		
		input = DTOVille.class.getResourceAsStream(filename);
		if(input!=null){
			prop.load(input);
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("#properties : "+prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port"));
		Ville[] villes= restTemplate.getForObject(prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port")+"/get?filter={filter}&value={value}", Ville[].class, filter, value);
		return villes;
		}else {
			return null;
		}
	}
	public void postVille(Ville ville) throws IOException{
		Properties prop = new Properties();
		InputStream input = null;
		String filename="../resources/application.properties";
		
		input = DTOVille.class.getResourceAsStream(filename);
		if(input!=null){
			prop.load(input);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("#properties : "+prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port"));
		URI villes= restTemplate.postForLocation(prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port")+"/post", ville);
		}
	}
	public void modifierVille(String codeCommuneInsee, Ville ville) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		String filename="../resources/application.properties";
		
		input = DTOVille.class.getResourceAsStream(filename);
		if(input!=null){
			prop.load(input);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("#properties : "+prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port"));
		restTemplate.put(prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port")+"/put/"+ codeCommuneInsee, ville);
		}
	}
	
	public void deleteVille(String codeCommuneInsee) throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		String filename="../resources/application.properties";
		
		input = DTOVille.class.getResourceAsStream(filename);
		if(input!=null){
			prop.load(input);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("#properties : "+prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port"));
		restTemplate.delete(prop.getProperty("APIRest.domain")+":"+prop.getProperty("APIRest.port")+"/delete/" + codeCommuneInsee);
		}
	}
}
