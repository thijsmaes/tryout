package be.groept.hibernate.exercise1.dao;

import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class PersonDaoHibernateTest extends
		AbstractTransactionalTestNGSpringContextTests {

	// TODO wire the dao
	private PersonDao personDao;

	private Person johnDoe, steveWilson;

	public void testFindByName() {
		List<Person> persons = personDao.findByName("doe");
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "John");
		Assert.assertEquals(persons.iterator().next().getName(), "Doe");
	}

	public void testFindByAddressCriteria() {
		AddressSearchCriteria addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("antwerp");
		List<Person> persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "Steve");
		Assert.assertEquals(persons.iterator().next().getName(), "Wilson");

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("brussels");
		persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "John");
		Assert.assertEquals(persons.iterator().next().getName(), "Doe");

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 2);
	}

	public void testDelete() {
		personDao.removePerson(johnDoe);
		personDao.removePerson(steveWilson);
		Assert.assertEquals(personDao.findByName("Wilson").size(), 0);
		Assert.assertEquals(personDao.findByName("Doe").size(), 0);
	}

	@BeforeMethod
	@SuppressWarnings("unused")
	private void dataSetup() {

		// Maybe you can use the build pattern to easily create Person entities?
		// I already made one for you 'PersonBuilder....' see PersonDaoJdbcTest
		// on howto use
	}
}
