package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;

public class PageOptions {

	public static final Integer DEFAULT_PAGESIZE = 50;
	
	protected Integer page = 0;
	
	protected Integer pageSize;

	protected String sort;
	
	protected String marker;
	
	public PageOptions() {
	}
	
	public PageOptions(PageOptions options) {
		this.page = options.page;
		this.pageSize = options.pageSize;
		this.marker = options.marker;
		this.sort = options.sort;
	}
	
	public PageOptions(String marker, Integer pageSize) {
		this.marker = marker;
		this.pageSize = pageSize;
	}

	public PageOptions(Integer page, Integer pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}	

	public PageOptions(Pageable pageable) {
		this.page = pageable.getPageNumber();
		this.pageSize = pageable.getPageSize();
		this.sort = toSort(pageable.getSort());
	}	

	public PageOptions(Object obj) {
		MappingUtils.updateObjectFrom(this, obj);
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
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
	public String toString() {
		return this.getClass().getSimpleName() + " ["
				+ (page != null ? "page=" + page + ", " : "")
				+ (pageSize != null ? "pageSize=" + pageSize + ", " : "") 
				+ (sort != null ? "sort=" + sort + ", " : "")
				+ (marker != null ? "marker=" + marker : "") 
				+ "]";
	}

	
	public static PageRequest toPageRequest(PageOptions options) {
		return new PageRequest(options.getPage()!=null ? options.getPage() : 0, options.getPageSize()!=null ? options.getPageSize() : PageOptions
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
		return new Sort(orderList);
	}


}