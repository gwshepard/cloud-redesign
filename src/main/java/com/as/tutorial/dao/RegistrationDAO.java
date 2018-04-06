package com.as.tutorial.dao;

import com.as.tutorial.model.Registration;


public interface RegistrationDAO {
	
	public void insert(Registration registration);
	public void update(Registration registration);
	public Registration findByEmailAddress(String emailAddress);
	public Registration findByEmailAddressAndPassword(String emailAddress, 
			String password);

}
