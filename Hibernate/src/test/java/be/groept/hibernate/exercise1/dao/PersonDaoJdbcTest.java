package be.groept.hibernate.exercise1.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import be.groept.hibernate.exercise1.AddressSearchCriteria;
import be.groept.hibernate.exercise1.entities.Person;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("jdbc")
public class PersonDaoJdbcTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private DataSource dataSource;
	@Autowired
	private PersonDao personDao;

	private Person johnDoe, steveWilson;

	@BeforeMethod
	private void dataSetup() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate
				.execute("create table person (id bigint generated by default as identity, name varchar(255), firstname varchar(255), box varchar(255), country varchar(255), housenumber varchar(255), municipality varchar(255), postalcode varchar(255), street varchar(255))");

		johnDoe = new PersonBuilder() {
			{
				firstName("John").name("Doe");
				{
					addAddress();
					country("belgium").municipality("brussels").postalCode("1000");
					street("nieuwstraat").houseNumber("1").box("A");
				}
			}
		}.retrieve();

		steveWilson = new PersonBuilder() {
			{
				firstName("Steve").name("Wilson");
				{
					addAddress();
					country("belgium").municipality("antwerp").postalCode("2000");
					street("meir").houseNumber("10");
				}
			}
		}.retrieve();

		personDao.savePerson(johnDoe);
		personDao.savePerson(steveWilson);
	}

	@AfterMethod
	private void tearDown() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("drop table person");
	}

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
		Assert.assertEquals(persons.iterator().next().getAddresses().size(), 0);

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		addressSearchCriteria.setMunicipality("brussels");
		persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 1);
		Assert.assertEquals(persons.iterator().next().getFirstName(), "John");
		Assert.assertEquals(persons.iterator().next().getName(), "Doe");
		Assert.assertEquals(persons.iterator().next().getAddresses().size(), 0);

		addressSearchCriteria = new AddressSearchCriteria();
		addressSearchCriteria.setCountry("belgium");
		persons = personDao.findByAddress(addressSearchCriteria);
		Assert.assertEquals(persons.size(), 2);
	}

	public void testDelete() {
		personDao.removePerson(personDao.findByName("Doe").iterator().next());
		personDao.removePerson(personDao.findByName("Wilson").iterator().next());
		Assert.assertEquals(personDao.findByName("Wilson").size(), 0);
		Assert.assertEquals(personDao.findByName("Doe").size(), 0);
	}
}