package be.groept.spring.facade;

import org.springframework.stereotype.Component;

import be.groept.spring.repository.OrderRepository;


@Component
public class AnotherServiceFacadeImpl implements AnotherServiceFacade {

	private OrderRepository orderRepository;

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
