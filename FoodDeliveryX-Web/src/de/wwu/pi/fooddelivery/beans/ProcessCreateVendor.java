package de.wwu.pi.fooddelivery.beans;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.ConstraintViolationException;

import de.wwu.pi.fooddelivery.ejb.VendorService;
import de.wwu.pi.fooddelivery.jpa.Vendor;
import de.wwu.pi.fooddelivery.web.Util;

/**
 * Backing bean for the create vendor page.
 */

@ManagedBean
@SessionScoped
public class ProcessCreateVendor {
	private Vendor vendor;
	private String errorMessage;

	@EJB
	private VendorService vendorEjb;

	public Vendor getVendor() {
		if (vendor == null)
			vendor = new Vendor();
		return vendor;
	}

	public String submit() {
		// Action
		try {
			vendorEjb.validate(getVendor());
			vendorEjb.createVendor(getVendor());
			
			reset();
		} catch (EJBException e) {
			errorMessage = "Vendor not created: " + Util.getConstraintMessage(e);
		} catch (ConstraintViolationException e) {
			errorMessage = "Vendor not created: " + Util.getConstraintMessage(e);
		}

		// Navigation
		if (errorMessage != null)
			return null;
		else
			return "listVendors";
	}
	
	public void cancel() {
		reset();
		
		Util.redirectToRoot();
	}
	
	public void reset() {
		vendor = null;
		errorMessage = null;
	}
	
	
	public String getError() {
		return errorMessage != null ? errorMessage : "";
	}
}
