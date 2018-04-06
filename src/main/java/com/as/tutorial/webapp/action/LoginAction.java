package com.as.tutorial.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.as.tutorial.business.RegistrationService;
import com.as.tutorial.model.RegistrationTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginAction
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
public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2098999038209751340L;
	private String emailAddress;
	private String password;
	private RegistrationService registrationService;
	private Map session;
	
	/**
	 * Creates an instance of LoginAction.
	 */
	public LoginAction() {
		super();
	}
	
	/**
	 * Validates a user's login request.
	 */
	@SuppressWarnings("unchecked")
	public void validate() {
		if (!hasErrors()) {
			RegistrationTO registration = this.getRegistrationService()
				.findByEmailAddressAndPassword(getEmailAddress(), getPassword());
			if (registration != null) {
				this.getSession().put("registration", registration);
			} else {
				this.addActionError(this.getText("error.login.incorrect"));
			}
		}
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * The ParametersInterceptor calls this method to set the login emailAddress.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * The ParametersInterceptor calls this method to set the login password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public RegistrationService getRegistrationService() {
		return registrationService;
	}

	/**
	 * The ObjectFactory calls this method with a reference to
	 * an implementation of RegistrationService.
	 */
	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public Map getSession() {
		return session;
	}

	/**
	 * The ServletConfigInterceptor calls this method with a Map of the session attributes.
	 */
	public void setSession(Map session) {
		this.session = session;
	}

}
