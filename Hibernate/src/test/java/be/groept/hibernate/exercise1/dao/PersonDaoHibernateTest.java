package be.groept.hibernate.exercise1.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("hibernate")
public class PersonDaoHibernateTest extends
		AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private PersonDao personDao;

	private Person johnDoe, steveWilson;

	public void testFindByName() {
		List<Person> persons = personDao.findByName("doe");
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "John");
		Assert.assertEquals(persons.iterator().next().getName(), "Doe");
	}

	public void testFindByAddressCriteria() {
		// sessionFactory.getCurrentSession().flush();
		AddressSearchCriteria addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("antwerp");
		List<Person> persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "Steve");
		Assert.assertEquals(persons.iterator().next().getName(), "Wilson");
		Assert.assertEquals(persons.iterator().next().getAddresses().size(), 1);

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("brussels");
		persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "John");
		Assert.assertEquals(persons.iterator().next().getName(), "Doe");
		Assert.assertEquals(persons.iterator().next().getAddresses().size(), 1);

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
	private void dataSetup() {

		johnDoe = new PersonBuilder() {
			{
				firstName("John").name("Doe");
				{
					addAddress();
					country("belgium").municipality("brussels").postalCode(
							"1000");
					street("nieuwstraat").houseNumber("1").box("A");
				}
			}
		}.retrieve();

		steveWilson = new PersonBuilder() {
			{
				firstName("Steve").name("Wilson");
				{
					addAddress();
					country("belgium").municipality("antwerp").postalCode(
							"2000");
					street("meir").houseNumber("10");
				}
			}
		}.retrieve();

		personDao.savePerson(johnDoe);
		personDao.savePerson(steveWilson);
	}
}
