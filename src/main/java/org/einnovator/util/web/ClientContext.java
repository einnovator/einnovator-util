/**
 * 
 */
package org.einnovator.util.web;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

/**
 * A ClientRequestContext.
 * 
 */
public class ClientContext extends ObjectBase {
	
	protected OAuth2RestTemplate restTemplate;

	protected boolean admin;
	
	protected String runAs;
	
	protected Object result;
	
	/**
	 * Create instance of {@code ClientRequestContext}.
	 *
	 */
	public ClientContext() {
	}

	/**
	 * Get the value of property {@code restTemplate}.
	 *
	 * @return the restTemplate
	 */
	public OAuth2RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/**
	 * Set the value of property {@code restTemplate}.
	 *
	 * @param restTemplate the value of property restTemplate
	 */
	public void setRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Get the value of property {@code admin}.
	 *
	 * @return the admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the value of property admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
	 * @param runAs the value of property runAs
	 */
	public void setRunAs(String runAs) {
		this.runAs = runAs;
	}
	
	// With

	/**
	 * Set the value of property {@code restTemplate}.
	 *
	 * @param restTemplate the value of property restTemplate
	 */
	public ClientContext withRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the value of property admin
	 */
	public ClientContext withAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the value of property runAs
	 */
	public ClientContext withRunAs(String runAs) {
		this.runAs = runAs;
		return this;
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
	 * @param creator
	 * @return
	 * @see org.einnovator.util.model.ObjectBase#toString1(org.einnovator.util.model.ToStringCreator)
	 */
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("admin", admin)
			.append("runAs", runAs)
			;
	}
}
