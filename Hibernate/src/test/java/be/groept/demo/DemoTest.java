package be.groept.demo;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class DemoTest extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	private SessionFactory sessionFactory;

	@Rollback(false)
	public void testDemo() {
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setProperty("testing");
		sessionFactory.getCurrentSession().save(demoEntity);
		sessionFactory.getCurrentSession().flush();
	}
}
