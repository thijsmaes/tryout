package be.groept.testrunner;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestRunner extends AbstractTestNGSpringContextTests {

}
