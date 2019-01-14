package org.einnovator.util.config;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * {@code ConnectionConfiguration}.
 *
 */
public class ConnectionConfiguration {

	private Integer requestTimeout;

	private Integer timeout;
	
	private Integer readTimeout;
	
	
	/**
	 * Create instance of {@code ConnectionConfiguration}.
	 *
	 */
	public ConnectionConfiguration() {
	}

	/**
	 * Get the value of property {@code requestTimeout}.
	 *
	 * @return the requestTimeout
	 */
	public Integer getRequestTimeout() {
		return requestTimeout;
	}

	/**
	 * Set the value of property {@code requestTimeout}.
	 *
	 * @param requestTimeout the requestTimeout to set
	 */
	public void setRequestTimeout(Integer requestTimeout) {
		this.requestTimeout = requestTimeout;
	}

	/**
	 * Get the value of property {@code timeout}.
	 *
	 * @return the timeout
	 */
	public Integer getTimeout() {
		return timeout;
	}

	/**
	 * Set the value of property {@code timeout}.
	 *
	 * @param timeout the timeout to set
	 */
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	/**
	 * Get the value of property {@code readTimeout}.
	 *
	 * @return the readTimeout
	 */
	public Integer getReadTimeout() {
		return readTimeout;
	}

	/**
	 * Set the value of property {@code readTimeout}.
	 *
	 * @param readTimeout the readTimeout to set
	 */
	public void setReadTimeout(Integer readTimeout) {
		this.readTimeout = readTimeout;
	}
	
	/**
	 * Make instance of {@code ClientHttpRequestFactory}.
	 * 
	 * @return the {@code ClientHttpRequestFactory}
	 */
	public ClientHttpRequestFactory makeClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		
		if (timeout!=null) {
			clientHttpRequestFactory.setConnectTimeout(timeout);
		}
		
		if (requestTimeout!=null) {
			clientHttpRequestFactory.setConnectionRequestTimeout(requestTimeout);
		}
		
		if (readTimeout!=null) {
			clientHttpRequestFactory.setReadTimeout(readTimeout);
		}
		
		return clientHttpRequestFactory;
	}



	
}
