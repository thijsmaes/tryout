package be.groept.hibernate.entities.concurency;

import java.util.ArrayList;
import java.util.List;

public class Organization {

	private Long id;

	private Integer version;

	private String address;
	private List<Employee> employees = new ArrayList<Employee>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
