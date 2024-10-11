package br.com.erudio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class NumberController {

	
	@Autowired
	TratativaNumeroController tratativaNumeroController;
	
	
	 public Double sum(
			 String n1,String n2) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1) || !tratativaNumeroController.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return tratativaNumeroController.convertToDouble(n1) + tratativaNumeroController.convertToDouble(n2);
	 }

	
	 public Double subtration(
			 String n1,String n2) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1) || !tratativaNumeroController.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return tratativaNumeroController.convertToDouble(n1) - tratativaNumeroController.convertToDouble(n2);
	 }
	
	 public Double division(
			 String n1,String n2) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1) || !tratativaNumeroController.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return tratativaNumeroController.convertToDouble(n1) / tratativaNumeroController.convertToDouble(n2);
	 }
	
	 public Double multiplication(
			 String n1,String n2) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1) || !tratativaNumeroController.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return tratativaNumeroController.convertToDouble(n1) * tratativaNumeroController.convertToDouble(n2);
	 }
	
	 public Double raizQuadrada(
			 String n1) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return tratativaNumeroController.convertToDouble(n1) * tratativaNumeroController.convertToDouble(n1);
	 }
	
	 public Double media(
			 String n1,String n2) throws Exception { 
		
		if(!tratativaNumeroController.isNumeric(n1) || !tratativaNumeroController.isNumeric(n2)) {
			throw new UnsupportedMathOperationException("Please set a numeric vale"); 
		}
		return (tratativaNumeroController.convertToDouble(n1) + tratativaNumeroController.convertToDouble(n2)) / 2;
	 }
}
