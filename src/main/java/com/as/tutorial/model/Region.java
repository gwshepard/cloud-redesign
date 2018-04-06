package com.as.tutorial.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Region implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer regionId;
	private String regiondescription;
	private Date createTimestamp;
	private Date updateTimestamp;
	/**
	 * Creates an instance of Region.
	 */
	public Region() {
		super();
	}

    public Integer getRegionId() {
		return regionId;
	}


	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegiondescription() {
		return regiondescription;
	}

	public void setRegiondescription(String regiondescription) {
		this.regiondescription = regiondescription;
	}


	public Date getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}


	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public String toString() {
        return new ToStringBuilder(this)
            .append("regionId", getRegionId())
            .append("regiondescription", getRegiondescription())
            .toString();
    }

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( !(other instanceof Region) ) return false;
        Region castOther = (Region) other;
        return new EqualsBuilder()
            .append(this.getRegionId(), castOther.getRegionId())
            .append(this.getRegiondescription(), castOther.getRegiondescription())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getRegionId())
            .append(getRegiondescription())
            .toHashCode();
    }

}
