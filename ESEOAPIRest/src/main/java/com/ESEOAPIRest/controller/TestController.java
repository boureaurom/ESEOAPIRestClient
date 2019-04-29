package com.ESEOAPIRest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ESEOAPIRest.blo.Ville;
import com.ESEOAPIRest.dao.ListeVilleDAO;

@RestController
public class TestController {
	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public Ville[] get(@RequestParam(required = false, value="filter") String filter, @RequestParam(required = false, value="value") String value) {
		System.out.println("Appel GET");
		System.out.println("value : "+value);
		
		Ville[] result=null;
		if(value==null && filter ==null) {
			ListeVilleDAO villes = new ListeVilleDAO();
			result=villes.listeVilles();
		}else if(value!=null && filter!=null) {
			int filterint =Integer.parseInt(filter);
			ListeVilleDAO villes = new ListeVilleDAO();
			result=villes.listeVillesAvecFiltre(filterint, value);
		}else {
			result=null;
		}
		return result;
	}
	
//String 
//	@RequestMapping(value="/get", method=RequestMethod.GET)
//	@ResponseBody
//	public String get(@RequestParam(required = false, value="filter") String filter, @RequestParam(required = false, value="value") String value) {
//		System.out.println("Appel GET");
//		System.out.println("value : "+value);
//		String type;
//		String result="";
//		if(value==null && filter ==null) {
//			type= "Sans filtre : ";
//			ListeVilleDAO villes = new ListeVilleDAO();
//			Ville[] touteVilles=villes.listeVilles();
//			for(int x=0; x<touteVilles.length;x++) {
//				result+=touteVilles[x].toString()+"<br>";
//			}
//		}else if(value!=null && filter!=null){
//			type= "Avec filtre : ";
//			int filterint =Integer.parseInt(filter);
//			ListeVilleDAO villes = new ListeVilleDAO();
//			Ville[] villesFiltre=villes.listeVillesAvecFiltre(filterint, value);
//			for(int x=0; x<villesFiltre.length;x++) {
//				result+=villesFiltre[x].toString()+"<br>";
//			}
//		}else {
//			type= "Dummy ! :";
//			result="No result";
//		}
//		return type+value+filter+result;
//	}
	
	@RequestMapping(value="/post", method=RequestMethod.POST)
	@ResponseBody
	public boolean post(
			@RequestBody(required = true) Ville ville) {
		System.out.println("Appel POST");
		ListeVilleDAO villes = new ListeVilleDAO();
		boolean result=villes.creationVille(ville);
		return result;
	}
	
	@PutMapping(value="/put/{codeCommuneInsee}")
	@ResponseBody
	public boolean put(@PathVariable String codeCommuneInsee, 
			@RequestBody(required = true) Ville ville) {
		System.out.println("Appel PUT");
		ListeVilleDAO villes = new ListeVilleDAO();
		boolean result=villes.modifier(codeCommuneInsee, ville);
		
		   
		return result;
	}
	
	@DeleteMapping(value="/delete/{codeCommuneInsee}")
	@ResponseBody
	public boolean delete(@PathVariable String codeCommuneInsee) {
		ListeVilleDAO villes = new ListeVilleDAO();
		boolean result=villes.suppressionVille(codeCommuneInsee);
		System.out.println("Appel DELETE");
		return result;
	}
}
