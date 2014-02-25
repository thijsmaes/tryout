package be.groept.ie3.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_")
public class Order {
	
	@Id
	@GeneratedValue
	private Long id;
	
	String paymentMethod;
	BigDecimal orderTotal;
	
	@OneToMany
	@JoinColumn(name="orderId")
	Set<OrderDetail>orderDetails;
	
	@ManyToOne
	@JoinColumn(name="eshopId")
	Eshop shop = new Eshop();
	
	@ManyToOne
	@JoinColumn(name="customerId")
	Customer customer=new Customer();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long orderID) {
		this.id = orderID;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(BigDecimal orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Eshop getShop() {
		return shop;
	}

	public void setShop(Eshop shop) {
		this.shop = shop;
	}
	
}
