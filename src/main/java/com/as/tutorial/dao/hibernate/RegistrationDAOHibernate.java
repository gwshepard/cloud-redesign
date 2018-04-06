package com.as.tutorial.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.as.tutorial.dao.RegistrationDAO;
import com.as.tutorial.model.Registration;

public class RegistrationDAOHibernate extends HibernateDaoSupport implements
		RegistrationDAO {

	/**
	 * Creates an instance of RegistrationDAOHibernate.
	 */
	public RegistrationDAOHibernate() {
		super();
	}

	/**
	 * Inserts an instance of Registration into the database.
	 * 
	 * @param registration
	 *            instance of Registration
	 */
	public void insert(Registration registration) {

		this.getHibernateTemplate().save(registration);

	}

	/**
	 * Updates an instance of Registration in the database.
	 * 
	 * @param registration
	 *            instance of Registration
	 */
	public void update(Registration registration) {

		this.getHibernateTemplate().update(registration);

	}

	/**
	 * Finds an instance of Registration in the database by the Registration
	 * emailAddress.
	 * 
	 * @param emailAddress
	 *            emailAddress of the Registration
	 * 
	 * @return Registration or null if not found
	 */
	public Registration findByEmailAddress(String emailAddress) {
		String query = "from Registration as registration where registration.emailAddress = ?";
		Registration registration = null;
		Object[] parameters = { emailAddress };
		List list = this.getHibernateTemplate().find(query, parameters);
		if (list.size() > 0) {
			registration = (Registration) list.get(0);
		}
		return registration;
	}

	/**
	 * Finds an instance of Registration in the database by the Registration
	 * emailAddress and password.
	 * 
	 * @param emailAddress
	 *            emailAddress of the Registration
	 * @param password
	 *            password of the Registration
	 * 
	 * @return Registration or null if not found
	 */
	public Registration findByEmailAddressAndPassword(String emailAddress,
			String password) {

		String query = "from Registration as registration where registration.emailAddress = ? and registration.password = ?";
		Registration registration = null;
		Object[] parameters = { emailAddress, password };
		List list = this.getHibernateTemplate().find(query, parameters);
		if (list.size() > 0) {
			registration = (Registration) list.get(0);
		}
		return registration;
	}

}
