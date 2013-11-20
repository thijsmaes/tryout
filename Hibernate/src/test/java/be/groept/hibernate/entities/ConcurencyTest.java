package be.groept.hibernate.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.concurency.Employee;
import be.groept.hibernate.entities.concurency.Organization;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml",
		"/be/groept/hibernate/testBean.xml" })
public class ConcurencyTest extends
		AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SecondColidingUpdateTransaction secondColidingUpdateTransaction;

	@SuppressWarnings("all")
	public void testConcurency() {

		// -BEGIN DATA SETUP
		Organization organization = new Organization();
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setName("Doe");
		employee.setEmployeeNumber("12345678");
		organization.getEmployees().add(employee);
		Session session = sessionFactory.getCurrentSession();
		session.save(organization);
		session.clear();
		// -END DATA SETUP

		// ----------OPTIMISTIC LOCKING---------

		organization = (Organization) session.createQuery("from Organization")
				.list().iterator().next();

		// ===[Start] Do update of the organization we read just before, this
		// update occurs in a new transaction
		secondColidingUpdateTransaction.doWorkForOptimisticTest();
		// ===[End] organization address is now updated by other transaction

		// Updating the address in this transaction, unknowing that another
		// allready updated it (lost update in sight !)
		organization.setAddress("stationstraat");

		// We trigger an early flush to see what happens, you will see that an
		// staleObjectStateException is thrown indicating that someone else
		// already updated the same organization ! We prevented a lost update here.
		try {
			session.flush();
			Assert.fail();
		} catch (StaleObjectStateException staleObjectStateException) {
			System.err.println(staleObjectStateException.getMessage());
			// GOOD ! We know someone else updated the same record
		}
	}

	public static class SecondColidingUpdateTransaction {
		private SessionFactory sessionFactory;

		@Transactional(propagation = Propagation.REQUIRES_NEW)
		public void doWorkForOptimisticTest() {
			Organization organization = (Organization) sessionFactory
					.getCurrentSession().createQuery("from Organization")
					.list().iterator().next();
			organization.setAddress("nieuwstraat");
		}

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	}
}
