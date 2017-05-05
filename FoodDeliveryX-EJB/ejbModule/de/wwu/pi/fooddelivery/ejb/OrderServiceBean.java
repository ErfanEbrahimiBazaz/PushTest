package de.wwu.pi.fooddelivery.ejb;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import de.wwu.pi.fooddelivery.jpa.Order;
import de.wwu.pi.fooddelivery.jpa.Product;

@Stateless
public class OrderServiceBean implements OrderService {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private ValidatorFactory validatorFactory;

    @Resource
    private Validator validator;
	
	@Override
	public Order createOrder(Order order) {
		em.merge(order);
		return order;
	}

	@Override
	public Order getOrder(int orderId) {
		Order order = em.find(Order.class, orderId);

		if (order == null)
			throw new IllegalArgumentException(String.format("Order with ID %s not found", orderId));
		return order;
	}
	
	@Override
	public void validate(Order order) throws ConstraintViolationException {
		Set<ConstraintViolation<Order>> violations = validator.validate(order);
		if(!violations.isEmpty()) 
			throw new ConstraintViolationException(
				    new HashSet<ConstraintViolation<?>>(violations));
			//new ConstraintViolationException(violation);
	}

}
