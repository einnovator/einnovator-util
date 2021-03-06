package org.einnovator.util.model;

import org.springframework.core.style.ValueStyler;
import org.springframework.util.Assert;

/**
 * Utility class that builds pretty-printing {@code toString()} methods
 * with pluggable styling conventions. By default, ToStringCreator adheres
 * to EInnovator {@code toString()} styling conventions.
 *
 * @author  {support@einnovator.org}
 */
public class ToStringCreator {

	/**
	 * Default ToStringStyler instance used by this ToStringCreator.
	 */
	private static final ToStringStyler2 DEFAULT_TO_STRING_STYLER = new DefaultToStringStyler2();

	private final StringBuilder buffer = new StringBuilder(256);

	private final ToStringStyler2 styler;

	private final Object object;

	private boolean styledFirstField;


	/**
	 * Create a ToStringCreator for the given object.
	 * @param obj the object to be stringified
	 */
	public ToStringCreator(Object obj) {
		this(obj, (ToStringStyler2) null);
	}

	/**
	 * Create a ToStringCreator for the given object, using the provided style.
	 * @param obj the object to be stringified
	 * @param styler the ValueStyler encapsulating pretty-print instructions
	 */
	public ToStringCreator(Object obj, ValueStyler styler) {
		this(obj, new DefaultToStringStyler2(styler != null ? styler : DefaultToStringStyler2.DEFAULT_VALUE_STYLER));
	}

	/**
	 * Create a ToStringCreator for the given object, using the provided style.
	 * @param obj the object to be stringified
	 * @param styler the ToStringStyler encapsulating pretty-print instructions
	 */
	public ToStringCreator(Object obj, ToStringStyler2 styler) {
		Assert.notNull(obj, "The object to be styled must not be null");
		this.object = obj;
		this.styler = (styler != null ? styler : DEFAULT_TO_STRING_STYLER);
		this.styler.styleStart(this.buffer, this.object);
	}


	/**
	 * Append a byte field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, byte value) {
		return append(fieldName, Byte.valueOf(value));
	}

	/**
	 * Append a short field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, short value) {
		return append(fieldName, Short.valueOf(value));
	}

	/**
	 * Append a integer field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, int value) {
		return append(fieldName, Integer.valueOf(value));
	}

	/**
	 * Append a long field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, long value) {
		return append(fieldName, Long.valueOf(value));
	}

	/**
	 * Append a float field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, float value) {
		return append(fieldName, Float.valueOf(value));
	}

	/**
	 * Append a double field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, double value) {
		return append(fieldName, Double.valueOf(value));
	}

	/**
	 * Append a boolean field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, boolean value) {
		return append(fieldName, Boolean.valueOf(value));
	}

	/**
	 * Append a field value.
	 * @param fieldName the name of the field, usually the member variable name
	 * @param value the field value
	 * @return this, to support call-chaining
	 */
	public ToStringCreator append(String fieldName, Object value) {
		int n = this.buffer.length();
		this.styler.styleField(this.buffer, fieldName, value, styledFirstField);
		if (!styledFirstField) {
			styledFirstField = this.buffer.length()!=n;			
		}
		return this;
	}


	/**
	 * Append the provided value.
	 * @param value The value to append
	 * @return this, to support call-chaining.
	 */
	public ToStringCreator append(Object value) {
		this.styler.styleValue(this.buffer, value);
		return this;
	}


	/**
	 * Return the String representation that this ToStringCreator built.
	 */
	@Override
	public String toString() {
		this.styler.styleEnd(this.buffer, this.object);
		return this.buffer.toString();
	}

}
