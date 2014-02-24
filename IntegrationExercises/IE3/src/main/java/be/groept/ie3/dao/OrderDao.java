package be.groept.ie3.dao;

import java.util.List;

import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Order;

public interface OrderDao {

	List<Order> findOrdersFromCustomer(Customer customer);
	void saveOrder (Order order);
}
