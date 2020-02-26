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
	
	protected boolean singleton;
	
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
	
	// With


	/**
	 * Set the value of property {@code restTemplate}.
	 *
	 * @param restTemplate the value of property restTemplate
	 * @return this {@code ClientContext}
	 */
	public ClientContext withRestTemplate(OAuth2RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
		return this;
	}

	/**
	 * Set the value of property {@code admin}.
	 *
	 * @param admin the value of property admin
	 * @return this {@code ClientContext}
	 */
	public ClientContext withAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}

	/**
	 * Set the value of property {@code runAs}.
	 *
	 * @param runAs the value of property runAs
	 * @return this {@code ClientContext}
	 */
	public ClientContext withRunAs(String runAs) {
		this.runAs = runAs;
		return this;
	}
	
	/**
	 * Set the value of property {@code singleton}.
	 *
	 * @param singleton the value of property singleton
	 * @return this {@code ClientContext}
	 */
	public ClientContext withSingleton(boolean singleton) {
		this.singleton = singleton;
		return this;
	}


	/**
	 * Set the value of property {@code result}.
	 *
	 * @param result the value of property result
	 * @return this {@code ClientContext}
	 */
	public ClientContext withResult(Object result) {
		this.result = result;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("admin", admin)
			.append("runAs", runAs)
			;
	}
}
