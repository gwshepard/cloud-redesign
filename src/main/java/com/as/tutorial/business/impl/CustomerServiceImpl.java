package com.as.tutorial.business.impl;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.as.tutorial.business.CustomerService;
import com.as.tutorial.dao.RegistrationDAO;
import com.as.tutorial.model.Registration;
import com.as.tutorial.model.RegistrationTO;

public class CustomerServiceImpl implements CustomerService{
	private RegistrationDAO registrationDAO = null;

	private static final Log LOG = LogFactory.getLog(RegistrationServiceImpl.class);
	
	
	/**
	 * Creates an instance of RegistrationServiceImpl.
	 */
	public CustomerServiceImpl() {
		super();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Created an instance of RegistrationServiceImpl");
		}
	}

	/**
	 * Inserts an instance of Registration into the database.
	 * 
	 * @param registrationTO instance of RegistrationTO
	 */
	public void insert(RegistrationTO registrationTO) {
		Registration registration = this.populateRegistration(registrationTO);
		registration.setCreateTimestamp(new Date());
		registrationDAO.insert(registration);
	}

	/**
	 * Updates an instance of Registration in the database.
	 * 
	 * @param registrationTO instance of RegistrationTO
	 */
	public void update(RegistrationTO registrationTO) {
		Registration registration = this.populateRegistration(registrationTO);
		registrationDAO.update(registration);
	}

	/**
	 * Finds an instance of Registration in the database by the Registration
	 * emailAddress, and copies the Registration properties to an instance of
	 * RegistrationTO.
	 * 
	 * @param emailAddress emailAddress of the Registration
	 * 
	 * @return instance of RegistrationTO, or null if a Registration cannot be
	 *         found
	 */
	public RegistrationTO findByEmailAddress(String emailAddress) {

		RegistrationTO registrationTO = null;
		if (emailAddress != null) {
			try {
				Registration registration = registrationDAO.findByEmailAddress(emailAddress.trim().toLowerCase());
				if (registration != null) {
					registrationTO = this.populateRegistrationTO(registration);
				}
			} catch (Exception exception) {
				LOG.debug("Cannot find Registration by email address " + emailAddress);
			}
		}
		return registrationTO;
	}

	/**
	 * Finds an instance of Registration in the database by the Registration
	 * emailAddress and password, and copies the Registration properties to an
	 * instance of RegistrationTO.
	 * 
	 * @param emailAddress emailAddress of the Registration
	 * @param password password of the Registration
	 * 
	 * @return instance of RegistrationTO, or null if a Registration cannot be
	 *         found
	 */
	public RegistrationTO findByEmailAddressAndPassword(String emailAddress, String password) {

		RegistrationTO registrationTO = null;
		if (emailAddress != null && password != null) {
			try {
				Registration registration = registrationDAO.findByEmailAddressAndPassword(emailAddress.trim()
						.toLowerCase(), password);
				if (registration != null) {
					registrationTO = this.populateRegistrationTO(registration);
				}
			} catch (Exception exception) {
				LOG.debug("Cannot find Registration by email address " + emailAddress + " and password " + password);
			}
		}
		return registrationTO;
	}

	/**
	 * Determines if an email address has already been used.
	 * 
	 * @param oldEmail The previous email address, or null if this method is
	 *            being called for a new email address
	 * 
	 * @param newEmail The email address that is being checked
	 * 
	 * @return true if the newEmail has already been used, and false otherwise
	 */
	public boolean hasEmailAddressBeenUsed(String oldEmail, String newEmail) {

		boolean emailUsed = false;
		boolean checkEmail = true;

		if (newEmail != null) {

			if (oldEmail != null) {
				/*
				 * We do not want to check if an email address has been used if
				 * the user is updating an existing registration and has not
				 * changed the emailAddress.
				 */
				checkEmail = !newEmail.trim().equalsIgnoreCase(oldEmail.trim());
			}

			if (checkEmail) {
				RegistrationTO registrationTO = this.findByEmailAddress(newEmail.trim().toLowerCase());
				if (registrationTO != null) {
					emailUsed = true;
				}
			}
		}
		return emailUsed;
	}

	/**
	 * Sets a private member variable with an instance of an implementation of
	 * RegistrationDAO. This method is called by the Spring framework at run
	 * time.
	 * 
	 * @param registrationDAO implementation of RegistrationDAO
	 * @see RegistrationDAO
	 */
	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}

	/**
	 * Copies the properties of an instance of RegistrationTO to an instance of
	 * Registration.
	 * 
	 * @param registrationTO instance of RegistrationTO
	 * @return instance of Registration
	 */
	private Registration populateRegistration(RegistrationTO registrationTO) {
		Registration registration = registrationTO.getDomainObject();
		if (registration == null) {
			registration = new Registration();
			registrationTO.setDomainObject(registration);
		}
		try {
			registrationTO.setEmailAddress(registrationTO.getEmailAddress().trim().toLowerCase());
			registrationTO.setConfirmEmailAddress(registrationTO.getConfirmEmailAddress().trim().toLowerCase());
			registrationTO.setCreateTimestamp(registration.getCreateTimestamp());
			registrationTO.setUpdateTimestamp(registration.getUpdateTimestamp());
			registrationTO.setRegistrationId(registration.getRegistrationId());
			BeanUtils.copyProperties(registration, registrationTO);
		} catch (Exception exception) {
			LOG.error("Error copying RegistrationTO to Registration.");
		}
		return registration;
	}

	/**
	 * Copies the properties of an instance of Registration to an instance of
	 * RegistrationTO.
	 * 
	 * @param registration instance of Registration
	 * @return instance of RegistrationTO
	 */
	private RegistrationTO populateRegistrationTO(Registration registration) {
		RegistrationTO registrationTO = new RegistrationTO();
		try {
			BeanUtils.copyProperties(registrationTO, registration);
			registrationTO.setConfirmEmailAddress(registration.getEmailAddress());
			registrationTO.setConfirmPassword(registration.getPassword());
			registrationTO.setDomainObject(registration);
		} catch (Exception exception) {
			LOG.error("Error copying Registration to RegistrationTO.");
		}
		return registrationTO;
	}


}
