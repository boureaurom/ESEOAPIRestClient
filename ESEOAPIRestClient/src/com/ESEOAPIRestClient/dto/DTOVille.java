package com.ESEOAPIRestClient.dto;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.ESEOAPIRest.blo.Ville;

public class DTOVille {
	
	public Ville[]getTouteVilles(){
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes= restTemplate.getForObject("http://localhost:8181/get", Ville[].class);
		return villes;
	}
	public Ville[]getAvecFiltre(int filter, String value){
		RestTemplate restTemplate = new RestTemplate();
		Ville[] villes= restTemplate.getForObject("http://localhost:8181/get?filter={filter}&value={value}", Ville[].class, filter, value);
		return villes;
	}
	public void postVille(Ville ville){
		RestTemplate restTemplate = new RestTemplate();
		URI villes= restTemplate.postForLocation("http://localhost:8181/post", ville);
		
	}
	public void modifierVille(String codeCommuneInsee, String filter, String newValue) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8181/put?codeCommuneInsee={codeCommuneInsee}&filter={filter}&newValue={newValue}", null, codeCommuneInsee, filter, newValue);
	}
	
	public void deleteVille(String codeCommuneInsee) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8181/delete?codeCommuneInsee={codeCommuneInsee}", codeCommuneInsee);
	}
}
