package be.groept.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.beans.factory.annotation.Autowired;

import be.groept.model.orders.Order;
import be.groept.model.orders.OrderSearchCriteria;
import be.groept.model.orders.OrderService;

public class SearchBackingAction implements Serializable {

	@Autowired
	private transient OrderService orderService;

	private List<Order> searchResults;
	private Order selectedOrder;

	public void clear(OrderSearchCriteria searchCriteria) {
		searchResults = null;
		searchCriteria.clear();
	}

	public void search(OrderSearchCriteria orderSearchCriteria) {
		searchResults = orderService.getAllOrdersForCustomer("user");
	}

	public void selectOrder(Order order) {
		this.selectedOrder = order;
	}

	public List<Order> getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(List<Order> searchResults) {
		this.searchResults = searchResults;
	}

	public Order getSelectedOrder() {
		return selectedOrder;
	}

	public void setSelectedOrder(Order selectedOrder) {
		this.selectedOrder = selectedOrder;
	}
}
