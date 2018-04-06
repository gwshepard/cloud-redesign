package com.as.tutorial.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Registration implements Serializable {

	private static final long serialVersionUID = 5043309903439036383L;
	private Integer registrationId;
	private String emailAddress;
	private String password;
	private String passwordHint;
	private String firstName;
	private String lastName;
	private Boolean emailList;
	private Date createTimestamp;
	private Date updateTimestamp;

	/**
	 * Creates an instance of Registration.
	 */
	public Registration() {
		super();
	}

	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Boolean getEmailList() {
		return emailList;
	}

	public void setEmailList(Boolean emailList) {
		this.emailList = emailList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

    public String toString() {
        return new ToStringBuilder(this)
            .append("registrationId", getRegistrationId())
            .append("emailAddress", getEmailAddress())
            .append("password", getPassword())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Registration) ) return false;
        Registration castOther = (Registration) other;
        return new EqualsBuilder()
            .append(this.getEmailAddress(), castOther.getEmailAddress())
            .append(this.getPassword(), castOther.getPassword())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEmailAddress())
            .append(getPassword())
            .toHashCode();
    }

}
