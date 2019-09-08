package org.einnovator.util.model;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityOptions<T> extends ObjectBase implements Options<T> {

	private String runAs;
	
	private Boolean admin;

	public EntityOptions() {
	}


	/**
	 * Create instance of {@code EntityOptions}.
	 *
	 * @param obj a prototype
	 */
	public EntityOptions(Object obj) {
		super(obj);
	}

	/**
	 * Get the value of property {@code runAs}.
	 *
	 * @return the runAs
	 */
	public String getRunAs() {
		return runAs;
	}

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to set
	 */
	public void setRunAs(String runAs) {
		this.runAs = runAs;
	}
	

	/**
	 * Get the value of property {@code admin}.
	 *
	 * @return the admin
	 */
	public Boolean getAdmin() {
		return admin;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	/* (non-Javadoc)
	 * @see org.einnovator.util.model.ObjectBase#toString(org.einnovator.util.model.ToStringCreator)
	 */
	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return creator
				.append("runAs", runAs)
				.append("admin", admin)
				;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((runAs == null) ? 0 : runAs.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		EntityOptions other = (EntityOptions) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (runAs == null) {
			if (other.runAs != null)
				return false;
		} else if (!runAs.equals(other.runAs))
			return false;
		return true;
	}
	
	
	
}
