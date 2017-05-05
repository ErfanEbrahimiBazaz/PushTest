package de.wwu.pi.fooddelivery.ejb;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.validation.ConstraintViolationException;

import de.wwu.pi.fooddelivery.jpa.Order;
import de.wwu.pi.fooddelivery.jpa.Product;

@Remote
public interface OrderService {

	/**
	 * Create a new order in the database related to the specified <code>order</code>.
	 * @param vendor The order that should be created.
	 * @return The newly created order.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Order createOrder(Order order);
	
	/**
	 * Returns the product with the specified ID.
	 * @param orderId The ID of the product.
	 * @return The order.
	 * @throws IllegalArgumentException If no order exists for the given ID.
	 */
	Order getOrder(int orderID);
	
	/**
	 * Validate the Order entity.
	 * @param Order
	 * @throws ConstraintViolationException
	 */
	void validate(Order order) throws ConstraintViolationException;
}
