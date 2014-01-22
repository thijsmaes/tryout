package be.groept.model.orders;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderSearchCriteria implements Serializable {

	private BigDecimal minAmount;
	private BigDecimal maxAmount;
	private Integer numberOfProducts;
	private Boolean delivered;
	private String productName;
	private EmailAddress emailAddress = new EmailAddress();

	boolean hasPriceRange() {
		return minAmount != null || maxAmount != null;
	}

	boolean isWithinRange(BigDecimal price) {
		boolean inRange = true;

		if ((minAmount != null ? price.compareTo(minAmount) : 1) < 0) {
			inRange = false;
		}
		if ((maxAmount != null ? price.compareTo(maxAmount) : -1) > 0) {
			inRange = false;
		}
		return inRange;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public BigDecimal getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(BigDecimal maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Integer getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(Integer numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public Boolean getDelivered() {
		return delivered;
	}

	public void setDelivered(Boolean delivered) {
		this.delivered = delivered;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void clear() {
		minAmount = null;
		maxAmount = null;
		numberOfProducts = null;
		delivered = null;
		productName = null;
		emailAddress = new EmailAddress();
	}
}
