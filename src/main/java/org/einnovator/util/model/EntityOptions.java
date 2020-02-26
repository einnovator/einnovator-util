package org.einnovator.util.model;

import org.einnovator.util.web.RequestOptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntityOptions<T> extends RequestOptions implements Options<T> {

	@JsonIgnore
	private boolean fetch;

	/**
	 * Create instance of {@code EntityOptions}.
	 *
	 */
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
	 * Get the value of property {@code fetch}.
	 *
	 * @return the fetch
	 */
	public boolean isFetch() {
		return fetch;
	}

	/**
	 * Set the value of property {@code fetch}.
	 *
	 * @param fetch the value of property fetch
	 */
	public void setFetch(boolean fetch) {
		this.fetch = fetch;
	}
	
	//
	// With
	//
	
	/**
	 * Set the value of property {@code fetch}.
	 *
	 * @param fetch the value of property fetch
	 * @return this {@code EntityOptions}
	 */
	public EntityOptions<T> withFetch(boolean fetch) {
		this.fetch = fetch;
		return this;
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("fetch", fetch);
	}


}
