package be.groept.exercise7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import be.groept.exercise7.Person;
import be.groept.exercise7.dao.PersonDao;

@Component
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao = new PersonDao();
	
	@Override
	public Person findPerson(String firstName, String lastName) {
		
		return personDao.findPerson(firstName, lastName);
	}

}
