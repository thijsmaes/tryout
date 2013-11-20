package be.groept.hibernate.exercise1.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Profile("hibernate")
@Transactional
@Repository
public class PersonDaoImpl extends HibernateTemplate implements PersonDao {

	public List<Person> findAll() {
		// TODO make me work
		return null;
	}

	public List<Person> findByName(String name) {
		// TODO make me work
		return null;
	}

	public void removePerson(Person person) {
		// TODO make me work
	}

	public void savePerson(Person person) {
		// TODO make me work
	}

	public List<Person> findByAddress(AddressSearchCriteria addressSearchCriteria) {
		// TODO make me work
		return null;
	}
}
