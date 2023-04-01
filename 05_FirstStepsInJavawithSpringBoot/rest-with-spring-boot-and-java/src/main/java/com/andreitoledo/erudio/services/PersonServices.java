package com.andreitoledo.erudio.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.andreitoledo.erudio.model.Person;

/*
 * A anotação @Service serve para que o Spring Boot encare essa classe como um objeto
 * que vai ser INJETADO em rumtime em outras classes da aplicação.
 * */
@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {
		
		logger.info("Finding one person!");
		Person person = new Person();
		// construindo um moc
		person.setId(counter.incrementAndGet());
		person.setFirstName("Andrei");
		person.setLastName("Toledo");
		person.setAddress("São Paulo - Capital - Brasil");
		person.setGender("Male");
				
		return person;
	}
}
