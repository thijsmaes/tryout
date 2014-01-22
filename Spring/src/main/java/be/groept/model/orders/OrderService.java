package be.groept.model.orders;

import java.util.List;

public interface OrderService {

	public List<String> getProductNamesWithinOrder(String productName,
			String customerId);

	public List<Order> getOrders(OrderSearchCriteria orderSearchCriteria,
			String customerId);

	public List<Order> getAllOrdersForCustomer(String customerId);

}
