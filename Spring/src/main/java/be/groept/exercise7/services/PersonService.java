package be.groept.exercise7.services;

import be.groept.exercise7.Person;

public interface PersonService {

	Person findPerson(String firstName, String lastName);
}
