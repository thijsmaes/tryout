package be.groept.hibernate.exercise1.dao;

import java.util.List;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;


public interface PersonDao {

	public List<Person> findAll();

	public List<Person> findByName(String name);

	public void savePerson(Person person);

	public void removePerson(Person person);

	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria);

}
