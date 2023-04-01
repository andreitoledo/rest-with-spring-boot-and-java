package com.andreitoledo.erudio.services;

import java.util.ArrayList;
import java.util.List;
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

	/*
	 * CRUD findById, findAll, create
	 * */
	// declara uma listagem de pessoas, intera em um array que vai de 0 a 8
	// mocka uma pessoa para cada item dessa lista e adiciona a pessoa a listagem
	public List<Person> findAll() {		
		//logger.info("Finding all people!");		
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);			
		}		
		return persons;
	}
	
	// lista por id - GET
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
	
	// create POST
    public Person create(Person person) {
    //	logger.info("Creating one person!");
        return person;
    }
	
	// update PUT
    public Person update(Person person) {
    // logger.info("Updating one person!");
        return person;
    }   
    
    // DELETE
    public void delete(String id) {
    // logger.info("Deleting one person!");
        
    }
	
	// lista GET
	private Person mockPerson(int i) {
		Person person = new Person();
		// construindo um moc
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Some Address in Brasil " + i);
		person.setGender("Male");
		return person;
	}
}
