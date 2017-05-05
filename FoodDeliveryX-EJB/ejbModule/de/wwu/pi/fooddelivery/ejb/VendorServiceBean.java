package de.wwu.pi.fooddelivery.ejb;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import de.wwu.pi.fooddelivery.jpa.Vendor;

@Stateless
public class VendorServiceBean implements VendorService {
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private ValidatorFactory validatorFactory;

    @Resource
    private Validator validator;

	@Override
	public Vendor createVendor(Vendor vendor) {
		em.merge(vendor);
		return vendor;
	}

	@Override
	public Vendor createVendor(String name, String zip) {
		Vendor newVendor = new Vendor();
		newVendor.setName(name);
		newVendor.setZip(zip);
		return createVendor(newVendor);
	}

	@Override
	public Vendor getVendor(int vendorId) {
		Vendor vendor = em.find(Vendor.class, vendorId);

		if (vendor == null)
			throw new IllegalArgumentException(String.format("Vendor with ID %s not found", vendorId));
		return vendor;
	}

	@Override
	public Collection<Vendor> getAllVendors() {
		return em.createQuery("FROM Vendor", Vendor.class).getResultList();
	}

	@Override
	public void validate(Vendor vendor) throws ConstraintViolationException {
		Set<ConstraintViolation<Vendor>> violations = validator.validate(vendor);
		if(!violations.isEmpty()) throw
			new ConstraintViolationException(violations);
	}
}
