package be.groept.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String orderId;
	private String customerId;
	private List<Product> products;
	private boolean delivered;
	private final int deliveryDays;
	private BigDecimal totalOrderPrice;

	public Order(Long id, String orderId, String customerId, boolean delivered,
			int deliveryDays, Product... products) {
		this.id = id;
		this.orderId = orderId;
		this.customerId = customerId;
		this.delivered = delivered;
		this.deliveryDays = deliveryDays;
		this.products = Arrays.asList(products);

		calculateTotalOrderPrice();
	}

	private void calculateTotalOrderPrice() {
		BigDecimal temp = BigDecimal.ZERO;

		if (CollectionUtils.isNotEmpty(products)) {
			for (Product product : products) {
				temp = temp.add(product.getProductPrice());
			}
		}
		this.totalOrderPrice = temp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	public void setProducts(List<Product> products) {
		this.products = products;
		calculateTotalOrderPrice();
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public int getDeliveryDays() {
		return deliveryDays;
	}

	public BigDecimal getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(BigDecimal totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}
}
