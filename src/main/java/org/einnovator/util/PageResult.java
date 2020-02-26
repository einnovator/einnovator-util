/**
 * 
 */
package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

/**
 * @author support@einnovator.org
 *
 */
public class PageResult<T> extends ObjectBase {
	private Integer number;
	
	private Integer size;
	
	private Integer numberOfElements;
	
	private Integer totalPageResults;
	
	private Long totalElements;
	
	private List<T> content;
	
	private Class<T> type;

	private String label;

	private String plural;

	/**
	 * Create instance of {@code PageResult}.
	 *
	 */
	public PageResult() {
	}
	
	/**
	 * Create instance of {@code PageResult}.
	 *
	 * @param page a prototype page
	 */
	public PageResult(PageResult<T> page) {
		this.totalElements = page.totalElements;
		this.number = page.number;
		this.size = page.size;
		this.numberOfElements = page.numberOfElements;
		this.totalPageResults = page.totalPageResults;
		this.content = page.content;
	}
	
	/**
	 * Create instance of {@code PageResult}.
	 *
	 * @param page a prototype page
	 * @param content the content
	 */
	public PageResult(PageResult<?> page, List<T> content) {
		this.totalElements = page.totalElements;
		this.number = page.number;
		this.size = page.size;
		this.numberOfElements = page.numberOfElements;
		this.totalPageResults = page.totalPageResults;
		this.content = content;
	}

	/**
	 * Create instance of {@code PageResult}.
	 *
	 * @param number the number
	 * @param size the size
	 * @param numberOfElements the numberOfElements
	 * @param totalPageResults the totalPageResults
	 * @param totalElements the totalElements
	 * @param content the content
	 */
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

	/**
	 * Get the value of property {@code number}.
	 *
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the value of property number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * Get the value of property {@code size}.
	 *
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the value of property size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * Get the value of property {@code numberOfElements}.
	 *
	 * @return the numberOfElements
	 */
	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	/**
	 * Set the value of property {@code numberOfElements}.
	 *
	 * @param numberOfElements the value of property numberOfElements
	 */
	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	/**
	 * Get the value of property {@code totalPageResults}.
	 *
	 * @return the totalPageResults
	 */
	public Integer getTotalPageResults() {
		return totalPageResults;
	}

	/**
	 * Set the value of property {@code totalPageResults}.
	 *
	 * @param totalPageResults the value of property totalPageResults
	 */
	public void setTotalPageResults(Integer totalPageResults) {
		this.totalPageResults = totalPageResults;
	}

	/**
	 * Get the value of property {@code totalElements}.
	 *
	 * @return the totalElements
	 */
	public Long getTotalElements() {
		return totalElements;
	}

	/**
	 * Set the value of property {@code totalElements}.
	 *
	 * @param totalElements the value of property totalElements
	 */
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * Get the value of property {@code content}.
	 *
	 * @return the content
	 */
	public List<T> getContent() {
		return content;
	}

	/**
	 * Set the value of property {@code content}.
	 *
	 * @param content the value of property content
	 */
	public void setContent(List<T> content) {
		this.content = content;
	}

	/**
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public Class<T> getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}

	/**
	 * Get the value of property {@code label}.
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set the value of property {@code label}.
	 *
	 * @param label the value of property label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Get the value of property {@code plural}.
	 *
	 * @return the plural
	 */
	public String getPlural() {
		return plural;
	}

	/**
	 * Set the value of property {@code plural}.
	 *
	 * @param plural the value of property plural
	 */
	public void setPlural(String plural) {
		this.plural = plural;
	}

	/**
	 * Set the value of property {@code number}.
	 *
	 * @param number the value of property number
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withNumber(Integer number) {
		this.number = number;
		return this;
	}

	/**
	 * Set the value of property {@code size}.
	 *
	 * @param size the value of property size
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withSize(Integer size) {
		this.size = size;
		return this;
	}

	/**
	 * Set the value of property {@code numberOfElements}.
	 *
	 * @param numberOfElements the value of property numberOfElements
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
		return this;
	}

	/**
	 * Set the value of property {@code totalPageResults}.
	 *
	 * @param totalPageResults the value of property totalPageResults
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withTotalPageResults(Integer totalPageResults) {
		this.totalPageResults = totalPageResults;
		return this;
	}

	/**
	 * Set the value of property {@code totalElements}.
	 *
	 * @param totalElements the value of property totalElements
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withTotalElements(Long totalElements) {
		this.totalElements = totalElements;
		return this;
	}

	/**
	 * Set the value of property {@code content}.
	 *
	 * @param content the value of property content
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withContent(List<T> content) {
		this.content = content;
		return this;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the value of property type
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withType(Class<T> type) {
		this.type = type;
		return this;
	}

	/**
	 * Set the value of property {@code label}.
	 *
	 * @param label the value of property label
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withLabel(String label) {
		this.label = label;
		return this;
	}

	/**
	 * Set the value of property {@code plural}.
	 *
	 * @param plural the value of property plural
	 * @return this {@code PageResult}
	 */
	public PageResult<T> withPlural(String plural) {
		this.plural = plural;
		return this;
	}

	public String getRequiredLabel() {
		return label!=null ? label : (content!=null && content.isEmpty() && content.get(0)!=null ? makeLabel(content.get(0)) : null);
	}

	public String getRequiredPlural() {
		return plural!=null ? plural : makePlural(getRequiredLabel());
	}

	public static String makeLabel(Object obj) {
		if (obj==null) {
			return null;
		}
		return obj.getClass().getSimpleName();
	}

	public static String makePlural(String s) {
		if (s==null) {
			return null;
		}
		return s + "s";
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("number", number)
				.append("size", size)
				.append("numberOfElements", numberOfElements)
				.append("totalPageResults", totalPageResults)
				.append("totalElements", totalElements)
				;
	}


	public static <U> PageResult<U> create(PageResult<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		for (Object obj: page.getContent()) {
			list.add(MappingUtils.convert(obj, type));
		}
		return new PageResult<U>(page, list);
	}

}
