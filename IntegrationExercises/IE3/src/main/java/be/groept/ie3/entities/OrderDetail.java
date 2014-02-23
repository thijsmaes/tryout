package be.groept.ie3.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderDetail")
public class OrderDetail {

	@Id
	@GeneratedValue
	private Long orderDetailsID;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
}
