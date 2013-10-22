package be.groept.jsf.model;

import java.util.List;

public interface OrderService {

	List<String> getMatchingProductNamesWithinAllOrders(String productName);

	List<Order> searchOrders(OrderSearchCriteria orderSearchCriteria);

	List<Order> getAllOrdersForCustomer();

}
