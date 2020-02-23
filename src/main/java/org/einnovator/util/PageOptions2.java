package org.einnovator.util;

import org.einnovator.util.model.ToStringCreator;
import org.springframework.data.domain.Pageable;

public class PageOptions2 extends PageOptions {

	
	protected String marker;
	
	/**
	 * Create instance of {@code PageOptions}.
	 *
	 */
	public PageOptions2() {
	}
	
	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param options a prototype
	 */
	public PageOptions2(PageOptions2 options) {
		super(options);
		this.marker = options.marker;
	}

	
	/**
	 * Create instance of {@code PageOptions2}.
	 *
	 * @param marker the marker
	 * @param pageSize the pageSize
	 */
	public PageOptions2(String marker, Integer pageSize) {
		this.marker = marker;
		this.pageSize = pageSize;
	}

	/**
	 * Create instance of {@code PageOptions2}.
	 *
	 * @param page the page
	 * @param pageSize the pageSize
	 */
	public PageOptions2(Integer page, Integer pageSize) {
		super(page, pageSize);
	}	

	/**
	 * Create instance of {@code PageOptions2}.
	 *
	 * @param page the page
	 * @param pageSize the pageSize
	 * @param sort the sort
	 */
	public PageOptions2(Integer page, Integer pageSize, String sort) {
		super(page, pageSize, sort);
	}	

	/**
	 * Create instance of {@code PageOptions2}.
	 *
	 * @param pageable a Pageable
	 */
	public PageOptions2(Pageable pageable) {
		super(pageable);
	}	

	/**
	 * Create instance of {@code PageOptions2}.
	 *
	 * @param obj a prototype
	 */
	public PageOptions2(Object obj) {
		MappingUtils.updateObjectFrom(this, obj);
	}

	
	/**
	 * Get the value of property {@code marker}.
	 *
	 * @return the marker
	 */
	public String getMarker() {
		return marker;
	}

	/**
	 * Set the value of property {@code marker}.
	 *
	 * @param marker the value of property marker
	 */
	public void setMarker(String marker) {
		this.marker = marker;
	}
	
	/**
	 * Set the value of property {@code marker}.
	 *
	 * @param marker the value of property marker
	 */
	public PageOptions2 withMarker(String marker) {
		this.marker = marker;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString(creator)
			.append("marker", marker)
			;

	}


}