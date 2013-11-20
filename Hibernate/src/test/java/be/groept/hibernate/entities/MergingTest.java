package be.groept.hibernate.entities;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import be.groept.hibernate.entities.concurency.Employee;
import be.groept.hibernate.entities.concurency.Organization;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class MergingTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("all")
	public void testMerging() {
		// -BEGIN DATA SETUP
		Organization organization = new Organization();
		Employee employee = new Employee();
		employee.setFirstName("John");
		employee.setName("Doe");
		employee.setEmployeeNumber("12345678");
		organization.getEmployees().add(employee);
		Session session = sessionFactory.getCurrentSession();
		session.save(organization);
		session.flush();
		session.clear();
		// -END DATA SETUP

		sessionFactory.getCurrentSession().clear();
		organization = (Organization) session.createQuery("from Organization")
				.list().iterator().next();
		Hibernate.initialize(organization.getEmployees());
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();

		organization.setAddress("test street");
		organization.getEmployees().iterator().next().setEmployeeNumber("1");
		sessionFactory.getCurrentSession().flush();
		
		organization = (Organization) sessionFactory.getCurrentSession().merge(
				organization);
		sessionFactory.getCurrentSession().flush();
	}
}
