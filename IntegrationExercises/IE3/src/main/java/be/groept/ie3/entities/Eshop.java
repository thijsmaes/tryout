package be.groept.ie3.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Eshop")
public class Eshop {
	// TODO: this class is not complete, only here to get you started
	// complete the properties following the IE3 requiremetns

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
