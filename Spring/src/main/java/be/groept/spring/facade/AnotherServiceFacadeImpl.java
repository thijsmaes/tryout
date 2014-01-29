package be.groept.spring.facade;

import be.groept.spring.repository.OrderRepository;

public class AnotherServiceFacadeImpl implements AnotherServiceFacade {

	private OrderRepository orderRepository;

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
