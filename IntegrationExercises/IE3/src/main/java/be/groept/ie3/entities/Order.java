package be.groept.ie3.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_")
public class Order {
	
	@Id
	@GeneratedValue
	private Long orderID;
	
	String paymentMethod;
	BigDecimal orderTotal;
	
	@OneToMany
	@JoinColumn(name="orderId")
	Set<OrderDetail>orderDetails;
	
	
	//TODO BEWARE do NOT name your table ORDER since this is a RESERVED keyword in SQL!
}
