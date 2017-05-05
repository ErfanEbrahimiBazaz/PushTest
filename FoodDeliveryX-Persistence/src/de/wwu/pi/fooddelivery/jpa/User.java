package de.wwu.pi.fooddelivery.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User implements java.io.Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -9151444250532968799L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int userId;
	
	@NotNull(message="First Name required")
	@Size(min=1, message="First Name required")
	protected String firstName;
	
	@NotNull(message="Last Name required")
	@Size(min=1, message="Last Name required")
	protected String lastName;
	
	@NotNull(message="Birthdate required")
	@Size(min=1, message="Birthdate required")
	protected Date birthDate;
	
	@NotNull(message="IBAN required")
	@Size(min=1, message="IBAN required")
	protected String iban;
	
	@NotNull(message="BIC required")
	@Size(min=1, message="BIC required")
	protected String bic;
	
	//TODO: address...
	
	public int getUserId() {
		return userId;
	} 
	
	public void setUserId(int userId) {
		this.userId = userId;		
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public Date getBirthDate(){
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate){
		this.birthDate = birthDate;
	}
	
	public String getBic(){
		return bic;
	}
	
	public void setBic(String bic){
		this.bic = bic;
	}
	
	public String getIban(){
		return iban;
	}
	
	public void setIban(String iban){
		this.iban = iban;
	}
	
	//TODO: get,set for address

}
