package de.wwu.pi.fooddelivery.beans;

import java.util.Collection;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import de.wwu.pi.fooddelivery.ejb.VendorService;
import de.wwu.pi.fooddelivery.jpa.Vendor;

@ManagedBean
public class ListVendors {
	
	@EJB
	VendorService vendorEjb;

	private Collection<Vendor> vendors;
	
	public Collection<Vendor> getVendors(){
		if(vendors == null)
			vendors = vendorEjb.getAllVendors();
		return vendors;
	}
}
