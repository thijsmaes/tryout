package be.groept.exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.AssertJUnit;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
//import org.junit.Assert;

import be.groept.exercise7.Person;
import be.groept.exercise7.services.PersonService;

@Test
@ContextConfiguration(locations = "/applicationContext.xml")

public class Exercise7test extends AbstractTestNGSpringContextTests{

	@Autowired
	private PersonService personService;
	
	public void testControlInterface() 
	{
		Person thijsmaes = personService.findPerson("thijs", "maes");
		AssertJUnit.assertEquals(thijsmaes.getFirstName(),"thijs");
		AssertJUnit.assertEquals(thijsmaes.getLastName(),"maes");
	}
	
	
}
