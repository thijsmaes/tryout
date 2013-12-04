package be.groept.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FixMeFirst {

	public void thisStringEquals() {
		Assert.assertEquals("test string", "test string");
	}
}
