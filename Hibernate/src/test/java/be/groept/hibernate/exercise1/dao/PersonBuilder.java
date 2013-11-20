package be.groept.hibernate.exercise1.dao;

import be.groept.hibernate.exercise1.entities.Address;
import be.groept.hibernate.exercise1.entities.Person;

public class PersonBuilder {

	private Person person = new Person();
	private Address address;

	public Person retrieve() {
		try {
			return person;
		} finally {
			this.person = new Person();
		}
	}

	PersonBuilder id(Long id) {
		person.setId(id);
		return this;
	}

	PersonBuilder name(String name) {
		person.setName(name);
		return this;
	}

	PersonBuilder firstName(String firstName) {
		person.setFirstName(firstName);
		return this;
	}

	PersonBuilder addAddress() {
		address = new Address();
		person.getAddresses().add(address);
		return this;
	}

	PersonBuilder municipality(String municipality) {
		address.setMunicipality(municipality);
		return this;
	}

	PersonBuilder country(String country) {
		address.setCountry(country);
		return this;
	}

	PersonBuilder postalCode(String postalCode) {
		address.setPostalCode(postalCode);
		return this;
	}

	PersonBuilder street(String street) {
		address.setStreet(street);
		return this;
	}

	PersonBuilder houseNumber(String houseNumber) {
		address.setHouseNumber(houseNumber);
		return this;
	}

	PersonBuilder box(String box) {
		address.setBox(box);
		return this;
	}
}
