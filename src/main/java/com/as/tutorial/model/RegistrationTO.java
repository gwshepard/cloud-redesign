package com.as.tutorial.model;


public class RegistrationTO extends Registration {

	private static final long serialVersionUID = -4879255188029443201L;
	private String confirmEmailAddress;
	private String confirmPassword;
	private Registration domainObject;

	/**
	 * Creates an instance of RegistrationTO.
	 */
	public RegistrationTO() {
		super();
	}

	public String getConfirmEmailAddress() {
		return confirmEmailAddress;
	}

	public void setConfirmEmailAddress(String confirmEmailAddress) {
		this.confirmEmailAddress = confirmEmailAddress;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Registration getDomainObject() {
		return domainObject;
	}

	public void setDomainObject(Registration domainObject) {
		this.domainObject = domainObject;
	}
	
}

