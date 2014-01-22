package be.groept.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import be.groept.model.orders.Order;

public class DetailBackingAction implements Serializable {
 
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
