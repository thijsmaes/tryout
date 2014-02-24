package be.groept.ie3.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie3.entities.Product;

public interface ProductDao {
	
	List<Product> findAllProducts();
	List<Product> findProducts(String productName);
}
