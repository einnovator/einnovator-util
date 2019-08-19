/**
 * 
 */
package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author support@einnovator.org
 *
 */
public class PageResult<T> {
	private Integer number;
	
	private Integer size;
	
	private Integer numberOfElements;
	
	private Integer totalPageResults;
	
	private Long totalElements;
	
	private List<T> content;
	
	public PageResult() {
	}
	
	public PageResult(PageResult<T> page) {
		this.totalElements = page.totalElements;
		this.number = page.number;
		this.size = page.size;
		this.numberOfElements = page.numberOfElements;
		this.totalPageResults = page.totalPageResults;
		this.content = page.content;
	}
	
	public PageResult(PageResult<?> page, List<T> content) {
		this.totalElements = page.totalElements;
		this.number = page.number;
		this.size = page.size;
		this.numberOfElements = page.numberOfElements;
		this.totalPageResults = page.totalPageResults;
		this.content = content;
	}

	public PageResult(Integer number, Integer size, Integer numberOfElements, Integer totalPageResults, Long totalElements, List<T> content) {
		this.totalElements = totalElements;
		this.number = number;
		this.size = size;
		this.numberOfElements = numberOfElements;
		this.totalPageResults = totalPageResults;
		this.content = content;
	}

	public PageResult(Object obj) {
		MappingUtils.updateObjectFrom(this, obj);
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Integer getTotalPageResults() {
		return totalPageResults;
	}

	public void setTotalPageResults(Integer totalPageResults) {
		this.totalPageResults = totalPageResults;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "PageResult ["
				+ (number != null ? "number=" + number + ", " : "")
				+ (size != null ? "size=" + size + ", " : "")
				+ (numberOfElements != null ? "numberOfElements=" + numberOfElements + ", " : "")
				+ (totalPageResults != null ? "totalPageResults=" + totalPageResults + ", " : "")
				+ (totalElements != null ? "totalElements=" + totalElements + ", " : "")
				//+ (content != null ? "content=" + content : "") 
				+ "]";
	}

	public static <U> PageResult<U> create(PageResult<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		for (Object obj: page.getContent()) {
			list.add(MappingUtils.convert(obj, type));
		}
		return new PageResult<U>(page, list);
	}

}
