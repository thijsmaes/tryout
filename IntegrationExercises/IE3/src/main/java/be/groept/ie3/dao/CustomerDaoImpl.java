package be.groept.ie3.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import be.groept.ie3.entities.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findCustomers(String name, String firstName,
			String username) {
		List<Customer> allCustomers = findAllCustomers();
		List<Customer> selected = new ArrayList<Customer>();
		
		if (name != null || firstName != null || username!=null){
			if(name != null && firstName == null && username==null){
				for(Customer cust : allCustomers){
					if(cust.getName().equals(name)){
						selected.add(cust);
					}
				}
			}if(name != null && firstName != null && username==null){
				for(Customer cust : allCustomers){
					if(cust.getName().equals(name) && cust.getFirstName().equals(firstName)){
						selected.add(cust);
					}
				}
			}if(name != null && firstName == null && username!=null){
				for(Customer cust : allCustomers){
					if(cust.getName().equals(name) && cust.getUserName().equals(username)){
						selected.add(cust);
					}
				}
			}if(name == null && firstName != null && username==null){
				for(Customer cust : allCustomers){
					if(cust.getFirstName().equals(firstName)){
						selected.add(cust);
					}
				}
			}if(name == null && firstName != null && username!=null){
				for(Customer cust : allCustomers){
					if(cust.getFirstName().equals(firstName) && cust.getUserName().equals(username)){
						selected.add(cust);
					}
				}
			}if(name == null && firstName == null && username!=null){
				for(Customer cust : allCustomers){
					if(cust.getUserName().equals(username)){
						selected.add(cust);
					}
				}
			}if(name != null && firstName != null && username!=null){
				for(Customer cust : allCustomers){
					if(cust.getName().equals(name) && cust.getFirstName().equals(firstName) && cust.getUserName().equals(username)){
						selected.add(cust);
					}
				}
			}			
		}
		
		return selected;
	}

	private List<Customer> findAllCustomers() {
		return sessionFactory.openSession().createQuery("from Customer").list();
	}

}
