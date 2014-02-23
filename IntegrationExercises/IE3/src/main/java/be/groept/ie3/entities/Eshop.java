package be.groept.ie3.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Eshop")
public class Eshop {
	
	@Id
	@GeneratedValue
	private Long eshopId;
	private String name;
	private Address address;
	private Set<Order> orders;
	
	@OneToMany
	@JoinColumn(name="eshopId")
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getEshopId() {
		return eshopId;
	}

	public void setId(Long eshopId) {
		this.eshopId = eshopId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
