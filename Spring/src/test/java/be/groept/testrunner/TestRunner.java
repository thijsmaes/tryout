package be.groept.testrunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

import be.groept.spring.facade.AnotherServiceFacade;
import be.groept.spring.facade.ServiceFacade;

@Test
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestRunner extends AbstractTestNGSpringContextTests {

//	ServiceFacade serviceFacade;
	
	@Autowired
	private ServiceFacade serviceFacade;
	@Autowired
	private AnotherServiceFacade anotherServiceFacade;
	
	public void testControlInterface() 
	{
//		ServiceFacade serviceFacade = (ServiceFacade) this.applicationContext.getBean("serviceFacade");
//		anotherServiceFacade =  (AnotherServiceFacade) this.applicationContext.getBean("anotherServiceFacade");
		Assert.notNull(anotherServiceFacade);
	  
	}
	
}
