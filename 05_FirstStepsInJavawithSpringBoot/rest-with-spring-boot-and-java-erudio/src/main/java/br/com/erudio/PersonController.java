package br.com.erudio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RequestMapping("/person")
@RestController
public class PersonController {
	
	@Autowired
	TratativaNumeroController tratativaNumeroController;
	
	@Autowired
	private PersonServices service;
	
	@Autowired
	NumberController numberController;
	
	@RequestMapping()
	 public List<Person> findAll() throws Exception { 
		
		return service.findAll();
	 }
	
	@RequestMapping(value = "/{id}",
			method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public Person findById(
			 @PathVariable(value = "id" ) String id) throws Exception { 
		
		return service.findById(id);
	 }
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public Person create(
			 @RequestBody Person person) { 
		
		return service.create(person);
	 }

}
