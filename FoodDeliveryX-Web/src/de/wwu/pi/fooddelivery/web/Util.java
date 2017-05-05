package de.wwu.pi.fooddelivery.web;

import java.io.IOException;
import java.util.Set;

import javax.ejb.EJBException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class Util {

	public static String getConstraintMessage(EJBException e) {
		String message = "";
		if(e.getCausedByException() instanceof ConstraintViolationException){
			message += getConstraintMessage((ConstraintViolationException) e.getCausedByException());
		}
		else
			message += e.getMessage();
		return message;
	}
	
	public static String getConstraintMessage(ConstraintViolationException cve) {
		String message = "";
		
		message += constructViolationMessage(cve.getConstraintViolations());
		if(message.length() == 0) {
			message += cve.getMessage();
		}
		return message;
	}
	
	public static String constructViolationMessage(Set<ConstraintViolation<?>> violations) {
		String message = "";
		if (violations != null) {
			for (ConstraintViolation<?> cur : violations) {
				message += cur.getMessage() + " ";
			}
		}
		return message;
	}

	public static void redirectToRoot() {
		try {
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			ctx.redirect("/" + ctx.getContextName() + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
