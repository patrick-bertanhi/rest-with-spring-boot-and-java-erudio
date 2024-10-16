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

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.services.PersonServices;

@RequestMapping("/api/person/v1")
@RestController
public class PersonController {
	
	@Autowired
	TratativaNumeroController tratativaNumeroController;
	
	@Autowired
	private PersonServices service;
	
	@Autowired
	NumberController numberController;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<PersonVO> findAll() throws Exception { 
		
		return service.findAll();
	 }
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	 public PersonVO findById(
			 @PathVariable(value = "id" ) Long id) throws Exception { 
		
		return service.findById(id);
	 }
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public PersonVO create(
			 @RequestBody PersonVO person) { 
		
		return service.create(person);
	 }
	
	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public PersonVOV2 createv2(
			 @RequestBody PersonVOV2 person) { 
		
		return service.createV2(person);
	 }
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	 public PersonVO update(
			 @RequestBody PersonVO person) { 
		
		return service.update(person);
	 }
	
	@DeleteMapping(value = "/{id}")
	 public ResponseEntity<?> delete( @PathVariable(value = "id" ) Long id) { 
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	 }

}
