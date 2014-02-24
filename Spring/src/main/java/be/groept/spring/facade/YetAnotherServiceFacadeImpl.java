package be.groept.spring.facade;

import be.groept.spring.repository.OrderRepository;

public class YetAnotherServiceFacadeImpl implements YetAnotherServiceFacade {

//	private final OrderRepository orderRepository;

	public YetAnotherServiceFacadeImpl(){}
	public YetAnotherServiceFacadeImpl(OrderRepository orderRepository) {
//		this.orderRepository = orderRepository;
	}

//	public OrderRepository getOrderRepository() {
//		return orderRepository;
//	}
}
