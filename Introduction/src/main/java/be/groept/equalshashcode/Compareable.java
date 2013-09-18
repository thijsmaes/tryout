package be.groept.equalshashcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Compareable {

	public static void main(String args[]) {

		Set<Person> persons = new HashSet<Person>();

		persons.add(new Person("John"));
		persons.add(new Person("John"));
		persons.add(new Person("Doe"));

		for (Person person : persons) {
			System.err.println(person.getName());
		}
		System.err.println("");

		persons = new TreeSet<Person>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		persons.add(new Person("John"));
		persons.add(new Person("John"));
		persons.add(new Person("Doe"));

		for (Person person : persons) {
			System.err.println(person.getName());
		}
	}

	private static class Person {
		private String name;

		public Person(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
