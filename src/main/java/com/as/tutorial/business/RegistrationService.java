package com.as.tutorial.business;

import com.as.tutorial.dao.RegistrationDAO;
import com.as.tutorial.model.RegistrationTO;


public interface RegistrationService {
	
	public void setRegistrationDAO(RegistrationDAO registrationDAO);
	public void insert(RegistrationTO registration);
	public void update(RegistrationTO registration);
	public RegistrationTO findByEmailAddress(String emailAddress);
	public RegistrationTO findByEmailAddressAndPassword(String emailAddress, String password);
	public boolean hasEmailAddressBeenUsed(String oldEmail, String newEmail);

}

