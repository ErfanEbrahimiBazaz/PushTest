package de.wwu.pi.fooddelivery.jpa;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OrderPosition implements java.io.Serializable {
	private static final long serialVersionUID = 4965400399083190632L;

	
	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int orderLine;
	
	@NotNull(message="At least one product is required")
	protected Product product;
	
	@NotNull(message="Price required")
	@Min(1)
	protected int qunatity;
	


	//properties
	public int getOrderLine() {
		return this.orderLine;
	}

	public void setOrderLine(int orderLine) {
		this.orderLine = orderLine;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQunatity() {
		return qunatity;
	}

	public void setQunatity(int qunatity) {
		this.qunatity = qunatity;
	}
//methods	
	
	//constructors
	public OrderPosition(){
		
	}
	public OrderPosition(Product product, int quantity){
		this.setQunatity(quantity);
		this.setProduct(product);
	}
	

	
}
