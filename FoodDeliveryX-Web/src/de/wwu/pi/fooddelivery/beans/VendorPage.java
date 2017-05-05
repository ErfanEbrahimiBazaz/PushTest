package de.wwu.pi.fooddelivery.beans;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;

import de.wwu.pi.fooddelivery.ejb.ProductService;
import de.wwu.pi.fooddelivery.ejb.VendorService;
import de.wwu.pi.fooddelivery.jpa.Product;
import de.wwu.pi.fooddelivery.jpa.Vendor;
import de.wwu.pi.fooddelivery.web.Util;

@ManagedBean
public class VendorPage {

	private int vendorId;
	private Vendor vendor;

	@EJB
	VendorService vendorEjb;
	
	@EJB
	ProductService productEjb;
	
	public void ensureInitialized() {
		try{
			if(getVendor() != null)
				return; // Success
		} catch(EJBException e) {
			e.printStackTrace();
		}
		Util.redirectToRoot();
	}
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
		vendor = null;
	}

	public Vendor getVendor() {
		if(vendor == null)
			vendor = vendorEjb.getVendor(getVendorId());
		return vendor;
	}
	
	public Collection<Product> getProducts(){
		return getVendor().getProducts();
	}
}
