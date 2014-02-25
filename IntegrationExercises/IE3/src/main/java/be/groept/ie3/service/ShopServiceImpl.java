package be.groept.ie3.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.groept.ie3.dao.CustomerDao;
import be.groept.ie3.dao.ShopDao;
import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Eshop;
import be.groept.ie3.entities.Order;
import be.groept.ie3.entities.Product;

@Service
@Transactional
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;

	@Autowired
	private CustomerDao customerDao;
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Eshop> listEshops() {
		return shopDao.listAllShops();
	}

	@Override
	public Eshop loadShop(Long shopId) {
		// TODO complete me
		return null;
	}

	@Override
	public Customer loadCustomer(String username) {
		Customer customer = (Customer) customerDao.findCustomers(null, null, username);
		return customer;
	}

	@Override
	public void createOrder(List<Product> products) {
		// TODO complete me
	}

	@Override
	public List<Product> listProducts(String name) {
		// TODO complete me
		return null;
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		// TODO complete me
		return null;
	}
}