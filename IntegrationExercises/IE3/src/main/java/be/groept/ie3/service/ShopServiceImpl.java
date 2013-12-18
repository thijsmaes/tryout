package be.groept.ie3.service;

import java.util.List;

import be.groept.ie3.entities.Customer;
import be.groept.ie3.entities.Eshop;
import be.groept.ie3.entities.Order;
import be.groept.ie3.entities.Product;

public class ShopServiceImpl implements ShopService {

	@Override
	public List<Eshop> listEshops() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eshop loadShop(Long shopId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer loadCustomer(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(List<Product> products) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> listProducts(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> listOrders(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
