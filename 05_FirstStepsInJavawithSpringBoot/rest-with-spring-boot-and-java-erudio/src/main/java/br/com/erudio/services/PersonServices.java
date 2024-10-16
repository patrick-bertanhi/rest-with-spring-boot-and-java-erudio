package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() { 
		
		logger.info("find all peaple");
		
		return repository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("create one person");
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("update one person");
		Person entity = repository.findById(person.getId())
		 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLasttName(person.getLasttName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
		repository.delete(entity);
	}

	public Person findById(Long id) {
		
		logger.info("find person");
		 return repository.findById(id)
				 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
	}
	
	
}
