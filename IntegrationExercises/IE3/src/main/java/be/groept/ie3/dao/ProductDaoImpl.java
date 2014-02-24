package be.groept.ie3.dao;

import java.util.List;







import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionTemplate;

import be.groept.ie3.entities.Product;

public class ProductDaoImpl implements ProductDao{
	
	@Autowired
	TransactionTemplate transactionTemplate;
	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(TransactionTemplate transactionTemplate,
			SessionFactory sessionFactory) {
		this.transactionTemplate = transactionTemplate;
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Product> findAllProducts(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

	@Override
	public List<Product> findProducts(String productName) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product where name like :productName");
		query.setString("productName", "%" + productName + "%");
		List<Product> products = query.list();
		return products;
	}
	
}
