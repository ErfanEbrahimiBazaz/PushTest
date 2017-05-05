package de.wwu.pi.fooddelivery.jpa;

import java.util.ArrayList;
import java.util.Collection;

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
public class Product implements java.io.Serializable {
	private static final long serialVersionUID = 4965400399083190632L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int productId;
	
	@NotNull(message="Name required")
	@Size(min=1, message="Name required")
	protected String name;
	
	@NotNull(message="Price required")
	@Min(0)
	protected int priceInCent;

	@ManyToMany(mappedBy="products", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	protected Collection<Vendor> vendors;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Vendor> getVendors() {
		if(vendors == null) vendors = new ArrayList<Vendor>();
		
		return vendors;
	}

	public void setVendors(Collection<Vendor> vendors) {
		this.vendors = vendors;
	}
	
	public void addVendor(Vendor vendor){
		this.getVendors().add(vendor);
	}
	
	public void removeVendor(Vendor vendor){
		this.getVendors().remove(vendor);
	}

	public int getPriceInCent() {
		return priceInCent;
	}

	public void setPriceInCent(int priceInCent) {
		this.priceInCent = priceInCent;
	}
	
	@Override
	public String toString() {
		return name + " [productId=" + productId + "]";
	}
}
