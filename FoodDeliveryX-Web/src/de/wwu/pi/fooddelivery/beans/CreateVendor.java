package de.wwu.pi.fooddelivery.beans;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import de.wwu.pi.fooddelivery.ejb.VendorService;
import de.wwu.pi.fooddelivery.jpa.Vendor;
import de.wwu.pi.fooddelivery.web.Util;

/**
 * Backing bean for the create vendor page.
 */

@ManagedBean
@ViewScoped
public class CreateVendor {
	private Vendor vendor;
	private Vendor lastVendor;
	// private boolean batch;
	private String errorMessage;

	@EJB
	private VendorService vendorEjb;

	public Vendor getVendor() {
		if (vendor == null)
			vendor = new Vendor();
		return vendor;
	}

	public String persist() {
		// Action
		try {
			lastVendor = vendorEjb.createVendor(getVendor());
			vendor = null;
			errorMessage = null;
		} catch (EJBException e) {
			errorMessage = "Vendor not created: " + Util.getConstraintMessage(e);
		}

		// Navigation
		if (errorMessage != null)
			return null;
		else
			return "listVendors";
	}

	public String getLastResult() {
		if (lastVendor != null) {
			return "Created: " + lastVendor.toString();
		}
		return errorMessage != null ? errorMessage : "";
	}

	public String getSuccess() {
		return errorMessage != null ? "error" : "success";
	}
}
