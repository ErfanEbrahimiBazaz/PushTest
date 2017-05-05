package de.wwu.pi.fooddelivery.ejb;

import java.util.Collection;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.validation.ConstraintViolationException;

import de.wwu.pi.fooddelivery.jpa.Vendor;

@Remote
public interface VendorService {

	/**
	 * Create a new vendor in the database with properties as specified by <code>vendor</code>.
	 * @param vendor The newly created vendor has the same property values as this parameter.
	 * @return The newly created vendor.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Vendor createVendor(Vendor vendor);
	
	/**
	 * Create a new vendor in the database with the specified property values.
	 * @param name The name of the vendor.
	 * @param zip The zipCode of the vendor.
	 * @return The newly created vendor.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Vendor createVendor(String name, String zip);
	
	/**
	 * Returns the vendor with the specified ID.
	 * @param vendorId The ID of the vendor.
	 * @return The vendor.
	 * @throws IllegalArgumentException If no vendor exists for the given ID.
	 */
	Vendor getVendor(int vendorId);
	
	/**
	 * Retrieves all vendors from stored in the system.
	 * @return All vendors.
	 */
	Collection<Vendor> getAllVendors();
	
	/**
	 * Validate the vendor entity.
	 * @param vendor
	 * @throws ConstraintViolationException
	 */
	void validate(Vendor vendor) throws ConstraintViolationException;
}
