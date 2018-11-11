package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.util.StringUtils;

public class ListOptions {

	public static final Integer DEFAULT_PAGESIZE = 50;
	
	protected Integer page = 0;
	
	protected Integer pageSize;

	protected String sort;
	
	protected String nextToken;
	
	public ListOptions() {
	}
	
	public ListOptions(ListOptions options) {
		this.page = options.page;
		this.pageSize = options.pageSize;
		this.nextToken = options.nextToken;
		this.sort = options.sort;
	}
	
	public ListOptions(String nextToken, Integer pageSize) {
		this.nextToken = nextToken;
		this.pageSize = pageSize;
	}

	public ListOptions(Integer page, Integer pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}	
	
	public ListOptions(Pageable pageable) {
		this.pageSize = pageable.getPageSize();
		this.page = pageable.getPageNumber();
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

	public String getNextToken() {
		return nextToken;
	}

	public void setNextToken(String nextToken) {
		this.nextToken = nextToken;
	}


	public ListOptions applyDefaultPageSize(Integer pageSize, boolean force) {
		if ((force || this.pageSize==null) && pageSize!=null) {
			this.pageSize = pageSize;
		}
		return this;
	}

	public ListOptions applyDefaultPageSize(Integer pageSize) {
		return applyDefaultPageSize(pageSize, false);
	}

	public ListOptions applyDefaultPageSize() {
		return applyDefaultPageSize(DEFAULT_PAGESIZE);
	}
	
	public ListOptions applyDefaultSort(String sort, boolean force) {
		if (StringUtils.hasText(sort) && (force || !StringUtils.hasText(this.sort))) {
			this.sort = sort;
		}
		return this;
	}

	public ListOptions applyDefaultSort(String sort) {
		return applyDefaultSort(sort, false);
	}
	

	public PageRequest toPageRequest() {
		return toPageRequest(this);
	}
	
	public Sort toSort() {
		return toSort(this);
	}


	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " ["
				+ (page != null ? "page=" + page + ", " : "")
				+ (pageSize != null ? "pageSize=" + pageSize + ", " : "") 
				+ (sort != null ? "sort=" + sort + ", " : "")
				+ (nextToken != null ? "nextToken=" + nextToken : "") 
				+ "]";
	}
	
	public static PageRequest toPageRequest(ListOptions options) {
		return new PageRequest(options.getPage()!=null ? options.getPage() : 0, options.getPageSize()!=null ? options.getPageSize() : ListOptions.DEFAULT_PAGESIZE, toSort(options));
	}
	
	public static Sort toSort(ListOptions options) {
		String sort = options.getSort();
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