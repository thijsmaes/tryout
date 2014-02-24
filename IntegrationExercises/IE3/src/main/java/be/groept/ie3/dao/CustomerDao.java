package be.groept.ie3.dao;

import java.util.List;

import be.groept.ie3.entities.Customer;

public interface CustomerDao {
		
	List<Customer> findCustomers(String name, String firstName, String username);
}
