package be.groept.ie3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Order;

public class OrderDaoImpl implements OrderDao{

	@Autowired
	TransactionTemplate transactionTemplate;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Order> findOrdersFromCustomer(Customer customer) {
		List<Order> orders = sessionFactory.openSession().createQuery("from Order where customer = " + customer).list();
		return orders;
	}

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	
}
