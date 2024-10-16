package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() { 
		
		logger.info("find all peaple");
		
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("find person");
		 var entity = repository.findById(id)
				 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
		 return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		logger.info("create one person");
		 var entity = DozerMapper.parseObject(person, Person.class);
		var VO =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return VO;
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) {
		logger.info("create one person");
		 var entity = mapper.convertVoTOEntity(person);
		var vo =  mapper.convertEntityToVo(repository.save(entity));
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		logger.info("update one person");
		var entity = repository.findById(person.getId())
		 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var VO =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
		return VO;
	}
	
	public void delete(Long id) {
		var entity = repository.findById(id)
				 .orElseThrow(() -> new UnsupportedMathOperationException("No records found for this ID!"));
		repository.delete(entity);
	}
	
	
}
