package be.groept.ie3.entities;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue
	Long productId;
	String shortName;
	String name;
	BigDecimal price;
	int numbersInStock;
	
	@OneToMany
	@JoinColumn(name="productId")
	Set<OrderDetail>orderDetails; 
	
	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getNumbersInStock() {
		return numbersInStock;
	}
	public void setNumbersInStock(int numbersInStock) {
		this.numbersInStock = numbersInStock;
	}
	
	@Override
	public String toString(){
		return getName();
	}
}
