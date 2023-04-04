package com.andreitoledo.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andreitoledo.erudio.exceptions.ResourceNotFoundException;
import com.andreitoledo.erudio.model.Person;
import com.andreitoledo.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Finding one person!");

		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));
	}

	public Person create(Person person) {
		logger.info("Creating one person!");
		
		return repository.save(person);
	}

	public Person update(Person person) {

		logger.info("Updating one person!");

		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	public void delete(Long id) {
		logger.info("Deleting one person!");

		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found this ID!"));

		repository.delete(entity);

	}

}
