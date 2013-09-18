package be.groept.tests;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

import be.groept.equalshashcode.EmployeeRecord;

@Test
public class FixMeSecond {

	public void testEqualsHashcode() {

		Set<EmployeeRecord> set = new HashSet<EmployeeRecord>();
		EmployeeRecord john = new EmployeeRecord("John", "Doe");
		EmployeeRecord jim = new EmployeeRecord("Jim", "Jannsens");

		set.add(john);
		set.add(jim);

		//TODO Instead of system err, use Asserts to test if this is working
		System.err.println("Checking if everyone exists in the set:");
		System.err.println(set.contains(new EmployeeRecord("John", "Doe")));
		System.err.println(set.contains(new EmployeeRecord("Jim", "Jannsens")));
		System.err.println();

		System.err.println("Iterating over the set:");
		for (EmployeeRecord employeeRecord : set) {
			System.err.println(employeeRecord.getEmployeeFirstName());
		}
		System.err.println();

		//TODO Instead of system err, use Asserts to test if this is working
		System.err.println("Checking again if everyone exists in the set:");
		System.err.println(set.contains(new EmployeeRecord("John", "Doe")));
		System.err.println(set.contains(new EmployeeRecord("Jim", "Jannsens")));
	}
}
