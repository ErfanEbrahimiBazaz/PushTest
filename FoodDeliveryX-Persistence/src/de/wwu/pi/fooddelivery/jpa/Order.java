package de.wwu.pi.fooddelivery.jpa;

//my imports
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
//

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 4965400399083190632L;

	//fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int OrderId;
	
	//@NotNull(message="Date is Required")
	//@Size(min=1, message="Name required")
	protected Date orderDate; //readonly property
	protected Date deliveryTime;
	protected String additionalOrderInformation;
	
	// @OneToMany(mappedBy="OrderPosition", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@OneToMany
	protected Collection<OrderPosition> orderPositions;


	//  OrderPOsition
	
	public Collection<OrderPosition> getOrderPositions() {
		return orderPositions;
	}

	public void setOrderPositions(Collection<OrderPosition> orderPositions) {
		this.orderPositions = orderPositions;
	}

	

	//properties
	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	
	public Date getOrderDate() throws Exception{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentDate = dateFormat.format(date).toString();
		date=new SimpleDateFormat("dd/MM/yyyy").parse(currentDate);
		return date;
	}

	//public void setOrderDate(Date orderDate) {
	//	this.orderDate = orderDate;
	//}
	
	public Date getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAdditionalOrderInformation() {
		return additionalOrderInformation;
	}

	public void setAdditionalOrderInformation(String additionalOrderInformation) {
		this.additionalOrderInformation = additionalOrderInformation;
	}


	
	
	
	
}
