package br.com.erudio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<Person> findAll() throws Exception { 
		
		return service.findAll();
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public Person findById(
			 @PathVariable(value = "id" ) Long id) throws Exception { 
		
		return service.findById(id);
	 }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public Person create(
			 @RequestBody Person person) { 
		
		return service.create(person);
	 }
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public Person update(
			 @RequestBody Person person) { 
		
		return service.update(person);
	 }
	
	@DeleteMapping(value = "/{id}")
	 public ResponseEntity<?> delete( @PathVariable(value = "id" ) Long id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	 }

}
