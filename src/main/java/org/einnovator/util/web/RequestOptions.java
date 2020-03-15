/**
 * 
 */
package org.einnovator.util.web;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.einnovator.util.security.SecurityUtil;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Generic request options.
 * 
 * @author support@einnovator.org
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequestOptions extends ObjectBase {

	protected String runAs;
	
	@JsonIgnore
	protected Boolean admin;

	protected Boolean fullstate;

	protected Boolean publish;
	
	@JsonIgnore
	protected boolean silent;
	
	@JsonIgnore
	protected Object result;
	
	@JsonIgnore
	protected boolean singleton;

	/**
	 * Create instance of {@code RequestOptions}.
	 *
	 */
	public RequestOptions() {
	}


	/**
	 * Create instance of {@code RequestOptions}.
	 *
	 * @param obj a prototype
	 */
	public RequestOptions(Object obj) {
		super(obj);
	}

	//
	// Setters/Getters
	//
	
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

	/**
	 * Get the value of property {@code fullstate}.
	 *
	 * @return the fullstate
	 */
	public Boolean getFullstate() {
		return fullstate;
	}


	/**
	 * Set the value of property {@code fullstate}.
	 *
	 * @param fullstate the value of property fullstate
	 */
	public void setFullstate(Boolean fullstate) {
		this.fullstate = fullstate;
	}


	/**
	 * Get the value of property {@code publish}.
	 *
	 * @return the publish
	 */
	public Boolean getPublish() {
		return publish;
	}


	/**
	 * Set the value of property {@code publish}.
	 *
	 * @param publish the value of property publish
	 */
	public void setPublish(Boolean publish) {
		this.publish = publish;
	}


	/**
	 * Get the value of property {@code silent}.
	 *
	 * @return the silent
	 */
	public boolean isSilent() {
		return silent;
	}


	/**
	 * Set the value of property {@code silent}.
	 *
	 * @param silent the value of property silent
	 */
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	/**
	 * Get the value of property {@code singleton}.
	 *
	 * @return the singleton
	 */
	public boolean isSingleton() {
		return singleton;
	}

	/**
	 * Set the value of property {@code singleton}.
	 *
	 * @param singleton the value of property singleton
	 */
	public void setSingleton(boolean singleton) {
		this.singleton = singleton;
	}
	
	/**
	 * Get the value of property {@code result}.
	 *
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * Set the value of property {@code result}.
	 *
	 * @param result the value of property result
	 */
	public void setResult(Object result) {
		this.result = result;
	}
	
	/**
	 * Get the result unwrapped by unwrapping a {@code Result}..
	 *
	 * @return the unwrapped result if wrapped in {@code Result}, or plain result value if not
	 */
	public Object getResultUnwrapped() {
		return result instanceof Result ? ((Result<?>)result).getResult() : result;
	}
	
	/**
	 * Get exception by unwrapping a {@code Result}.
	 *
	 * @return the result
	 */
	public Exception getResultException() {
		return result instanceof Result ? ((Result<?>)result).getException() : null;
	}
	
	/**
	 * Check if result is error by unwrapping a {@code Result}.
	 *
	 * @return the result
	 */
	public boolean isError() {
		return result instanceof Result ? ((Result<?>)result).isError() : null;
	}
	
	//
	// With
	//
	

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the runAs to with
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withRunAs(String runAs) {
		this.runAs = runAs;
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the admin to with
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withAdmin(Boolean admin) {
		this.admin = admin;
		return this;
	}

	/**
	 * Set the value of property {@code fullstate}.
	 *
	 * @param fullstate the value of property fullstate
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withFullstate(Boolean fullstate) {
		this.fullstate = fullstate;
		return this;
	}
	
	/**
	 * Set the value of property {@code silent}.
	 *
	 * @param silent the value of property silent
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withSilent(boolean silent) {
		this.silent = silent;
		return this;
	}

	/**
	 * Set the value of property {@code publish}.
	 *
	 * @param publish the value of property publish
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withPublish(Boolean publish) {
		this.publish = publish;
		return this;
	}
	
	/**
	 * Set the value of property {@code singleton}.
	 *
	 * @param singleton the value of property singleton
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withSingleton(boolean singleton) {
		this.singleton = singleton;
		return this;
	}


	/**
	 * Set the value of property {@code result}.
	 *
	 * @param result the value of property result
	 * @return this {@code RequestOptions}
	 */
	public RequestOptions withResult(Object result) {
		this.result = result;
		return this;
	}

	//
	// Util
	//

	@JsonIgnore
	public String getRequiredPrincipal() {
		if (StringUtils.hasText(runAs)) {
			return runAs;
		}
		if (SecurityUtil.getPrincipal()==null || SecurityUtil.isAnonymous()) {
			return null;
		}
		return SecurityUtil.getPrincipalName();
	}


	@Override
	public ToStringCreator toString2(ToStringCreator creator) {
		return creator
				.append("runAs", runAs)
				.append("admin", admin)
				.append("fullstate", fullstate)
				.append("publish", publish)
				.append("silent", silent)
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
		RequestOptions other = (RequestOptions) obj;
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
	
	/**
	 * Check if request is for an {@code /admin} endpoint.
	 * 
	 * @param options optional {@code RequestOptions}
	 * @return true if request is for an admin endpoint, false otherwise
	 */
	public static boolean isAdminRequest(RequestOptions options) {
		if (options!=null && options.getAdmin()!=null) {
			return Boolean.TRUE.equals(options.getAdmin());
		}
		return false;
	}

}
