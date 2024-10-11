package br.com.erudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MathController {

	
	@Autowired
	TratativaNumeroController tratativaNumeroController;
	
	@Autowired
	NumberController numberController;
	
	@RequestMapping(value = "/sum/{n1}/{n2}", 
			method=RequestMethod.GET)
	 public Double sum(
			 @PathVariable(value = "n1" ) String n1,
			 @PathVariable(value = "n2" ) String n2) throws Exception { 
		
		return numberController.sum(n1, n2);
	 }

	
	@RequestMapping(value = "/sub/{n1}/{n2}", 
			method=RequestMethod.GET)
	 public Double subtration(
			 @PathVariable(value = "n1" ) String n1,
			 @PathVariable(value = "n2" ) String n2) throws Exception { 
		
		
		return numberController.subtration(n1, n2);
	 }
	
	@RequestMapping(value = "/div/{n1}/{n2}", 
			method=RequestMethod.GET)
	 public Double division(
			 @PathVariable(value = "n1" ) String n1,
			 @PathVariable(value = "n2" ) String n2) throws Exception { 
		
		return numberController.division(n1, n2);
	 }
	
	@RequestMapping(value = "/mult/{n1}/{n2}", 
			method=RequestMethod.GET)
	 public Double multiplication(
			 @PathVariable(value = "n1" ) String n1,
			 @PathVariable(value = "n2" ) String n2) throws Exception { 
		
		return numberController.multiplication(n1, n2);
	 }
	
	@RequestMapping(value = "/r2/{n1}", 
			method=RequestMethod.GET)
	 public Double raizQuadrada(
			 @PathVariable(value = "n1" ) String n1) throws Exception { 
		
		return numberController.raizQuadrada(n1);
	 }
	
	@RequestMapping(value = "/media/{n1}/{n2}", 
			method=RequestMethod.GET)
	 public Double media(
			 @PathVariable(value = "n1" ) String n1,
			 @PathVariable(value = "n2" ) String n2) throws Exception { 
		
		return numberController.media(n1, n2);
	 }
}
