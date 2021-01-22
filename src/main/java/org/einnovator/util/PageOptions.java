package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;

public class PageOptions extends ObjectBase {

	public static final Integer DEFAULT_PAGESIZE = 50;
	
	protected Integer page = 0;
	
	protected Integer pageSize;

	protected String sort;
	
	/**
	 * Create instance of {@code PageOptions}.
	 *
	 */
	public PageOptions() {
	}
	
	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param options a prototype
	 */
	public PageOptions(PageOptions options) {
		this.page = options.page;
		this.pageSize = options.pageSize;
		this.sort = options.sort;
	}

	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param page the page
	 * @param pageSize the pageSize
	 */
	public PageOptions(Integer page, Integer pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}	

	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param page the page
	 * @param pageSize the pageSize
	 * @param sort the sort
	 */
	public PageOptions(Integer page, Integer pageSize, String sort) {
		this.page = page;
		this.pageSize = pageSize;
		this.sort = sort;
	}	

	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param pageable a Pageable
	 */
	public PageOptions(Pageable pageable) {
		this.page = pageable.getPageNumber();
		this.pageSize = pageable.getPageSize();
		this.sort = toSort(pageable.getSort());
	}	

	/**
	 * Get the value of property {@code page}.
	 *
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * Set the value of property {@code page}.
	 *
	 * @param page the value of property page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * Get the value of property {@code pageSize}.
	 *
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * Set the value of property {@code pageSize}.
	 *
	 * @param pageSize the value of property pageSize
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Get the value of property {@code sort}.
	 *
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * Set the value of property {@code sort}.
	 *
	 * @param sort the value of property sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * Create instance of {@code PageOptions}.
	 *
	 * @param obj a prototype
	 */
	public PageOptions(Object obj) {
		MappingUtils.updateObjectFrom(this, obj);
	}

	//
	// With
	//
	

	/**
	 * Set the value of property {@code page}.
	 *
	 * @param page the value of property page
	 * @return this {@code PageOptions}
	 */
	public PageOptions withPage(Integer page) {
		this.page = page;
		return this;
	}

	/**
	 * Set the value of property {@code pageSize}.
	 *
	 * @param pageSize the value of property pageSize
	 * @return this {@code PageOptions}
	 */	
	public PageOptions withPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	/**
	 * Set the value of property {@code sort}.
	 *
	 * @param sort the value of property sort
	 * @return this {@code PageOptions}
	 */
	public PageOptions withSort(String sort) {
		this.sort = sort;
		return this;
	}

	public PageOptions applyDefaultPageSize(Integer pageSize, boolean force) {
		if ((force || this.pageSize==null) && pageSize!=null) {
			this.pageSize = pageSize;
		}
		return this;
	}

	public PageOptions applyDefaultPageSize(Integer pageSize) {
		return applyDefaultPageSize(pageSize, false);
	}

	public PageOptions applyDefaultPageSize() {
		return applyDefaultPageSize(DEFAULT_PAGESIZE);
	}
	
	public PageOptions applyDefaultSort(String sort, boolean force) {
		if (StringUtils.hasText(sort) && (force || !StringUtils.hasText(this.sort))) {
			this.sort = sort;
		}
		return this;
	}

	public PageOptions applyDefaultSort(String sort) {
		return applyDefaultSort(sort, false);
	}

	public PageRequest toPageRequest() {
		return toPageRequest(this);
	}

	@Override
	public ToStringCreator toString(ToStringCreator creator) {
		return super.toString(creator)
			.append("page", page)
			.append("pageSize", pageSize)
			.append("sort", sort);

	}

	
	public static PageRequest toPageRequest(PageOptions options) {
		return PageRequest.of(options.getPage()!=null ? options.getPage() : 0, options.getPageSize()!=null ? options.getPageSize() : PageOptions
				.DEFAULT_PAGESIZE, toSort(options));
	}

	public static Sort toSort(PageOptions options) {
		return toSort(options.getSort());
	}

	public static String toSort(Sort sort) {
		if (sort==null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Sort.Order order: sort) {
			if (sb.length()>0) {
				sb.append(",");
			}
			if (order.isDescending()) {
				sb.append("-");
			}
			sb.append(order.getProperty());
		}
		return sb.toString();
	}

	public static Sort toSort(String sort) {
		if (!StringUtils.hasText(sort)) {
			return null;
		}
		String ss[] = sort.trim().split(",");
		List<Order> orderList = new ArrayList<>();
		for (String s: ss) {
			s = s.trim();
			Direction direction = Sort.DEFAULT_DIRECTION;
			if (s.startsWith("+")) {
				s = s.substring(1).trim();
				direction = Direction.ASC;
			} else if (s.startsWith("-")) {
				s = s.substring(1).trim();
				direction = Direction.DESC;
			} 
			orderList.add(new Order(direction, s));
		}
		if (orderList.isEmpty()) {
			return null;
		}
		return Sort.by(orderList);
	}


}