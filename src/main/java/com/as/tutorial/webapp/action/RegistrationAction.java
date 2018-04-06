package com.as.tutorial.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.as.tutorial.business.RegistrationService;
import com.as.tutorial.model.RegistrationTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * RegistrationAction
 * 
 * This source code is included for convenience with tutorial 
 * distributions in PDF form, from which it is more difficult 
 * to accurately copy text than from other document formats.
 * 
 * This source code is included as-is, without warranty or conditions 
 * of any kind, either expressed or implied. We make no guarantee of 
 * the fitness of the source code for any use to which it may be put. 
 * Neither the author(s), nor ArcTech Software LLC, nor any of its agents, 
 * will be held liable for damages, caused or alleged, directly 
 * or indirectly, by any use of this source code.
 * 
 * Terms and Conditions: http://www.arctechsoftware.com/tutorial/termsPage.do
 */
public class RegistrationAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5661505281365406671L;
	private RegistrationTO registration;
	private RegistrationService registrationService;
	private Map session;

	/**
	 * Creates an instance of RegistrationAction.
	 */
	public RegistrationAction() {
		super();
	}

	public RegistrationTO getRegistration() {
		return registration;
	}

	public void setRegistration(RegistrationTO registration) {
		this.registration = registration;
	}

	public RegistrationService getRegistrationService() {
		return registrationService;
	}

	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}
	
	/**
	 * Handles the user's request to submit a new registration.
	 * 
	 * @return result String
	 */
	public String submit() {
		getRegistrationService().insert(this.getRegistration());
		return SUCCESS; // redirect to welcome page.
	}
	
	/**
	 * Overrides the ActionSupport input() method.
	 * 
	 * @return result String
	 */
	public String input() {
		setRegistration(getCurrentRegistration());
		return INPUT;
	}
	
	/**
	 * Handles the user's request to cancel the registration
	 * or the registration update page.
	 * 
	 * @return result String
	 */
	public String cancel() {
		return SUCCESS; // redirect to welcome page.
	}
	
	/**
	 * Handles the user's request to update their registration.
	 * 
	 * @return result String
	 */
	@SuppressWarnings("unchecked")
	public String update() {
		String result = ERROR;
		RegistrationTO registration = getCurrentRegistration();
		if (registration.getUpdateTimestamp() != null) {
			RegistrationTO updatedRegistration = getRegistration();
			updatedRegistration.setDomainObject(registration.getDomainObject());
			getRegistrationService().update(updatedRegistration);
			getSession().put("registration", updatedRegistration);
			registration.setDomainObject(null);
			result = SUCCESS; // redirect to welcome page.
		}
		return result;
	}

	
	/**
	 * Gets the registration from the session.
	 * 
	 * @return instance of RegistrationTO from the session,
	 * or a new instance if the registration is not in the 
	 * session (e.g. the user is not logged in)
	 */
	private RegistrationTO getCurrentRegistration() {
		Object registration = this.getSession().get("registration");
		if (registration != null) {
			return (RegistrationTO)registration;
		}
		else {
			return new RegistrationTO();
		}
	}
	
	/**
	 * Performs additional registration validation.
	 */
	public void validate() {
		if (!hasErrors()) {
			/* Make sure that the email address has not yet been used. */
			if (getRegistrationService()
				.hasEmailAddressBeenUsed(getEmailAddressFromSession(),
				getRegistration().getEmailAddress())) {
				this.addActionError(this.getText("error.registration.email.used"));
			}
		}
	}
	
	/**
	 * Gets the emailAddress from the registration in the session.
	 * 
	 * @return the emailAddress from the registration in the session, 
	 * or null if there is no registration in the session
	 */
	private String getEmailAddressFromSession() {
		return getCurrentRegistration().getEmailAddress();
	}
	
}


