package org.einnovator.util.model;

import java.util.Collection;

import org.springframework.core.style.DefaultValueStyler;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.core.style.ValueStyler;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;

/**
 * EInnovator default {@code toString()} styler.
 *
 * <p>This class is used by {@link ToStringCreator} to style {@code toString()}
 * output in a consistent manner according to EInnovator conventions.
 *
 * @author  {support@einnovator.org}
 */
public class DefaultToStringStyler2 implements ToStringStyler2 {

	
	/**
	 * Default ValueStyler instance used by the {@code style} method.
	 * Also available for the {@link ToStringCreator} class in this package.
	 */
	static final ValueStyler DEFAULT_VALUE_STYLER = new DefaultValueStyler();
	
	private final ValueStyler valueStyler;


	private boolean includeNulls;
	
	private boolean includeEmptyCollections;

	private boolean includeEmptyStrings;

	private boolean includeHashCode;

	/**
	 * Create a new DefaultToStringStyler.
	 * @param valueStyler the ValueStyler to use
	 */
	public DefaultToStringStyler2(ValueStyler valueStyler) {
		Assert.notNull(valueStyler, "ValueStyler must not be null");
		this.valueStyler = valueStyler;
	}

	/**
	 * Create a new DefaultToStringStyler.
	 */
	public DefaultToStringStyler2() {
		this(DEFAULT_VALUE_STYLER);
	}

	/**
	 * Return the ValueStyler used by this ToStringStyler.
	 */
	protected final ValueStyler getValueStyler() {
		return this.valueStyler;
	}


	@Override
	public void styleStart(StringBuilder buffer, Object obj) {
		if (!obj.getClass().isArray()) {
			buffer.append(ClassUtils.getShortName(obj.getClass()));
			buffer.append("(");
			if (includeHashCode) {
				styleIdentityHashCode(buffer, obj);				
			}
		}
		else {
			buffer.append('[');
			if (includeHashCode) {
				styleIdentityHashCode(buffer, obj);				
			}
				
			buffer.append(' ');
			styleValue(buffer, obj);
		}
	}

	private void styleIdentityHashCode(StringBuilder buffer, Object obj) {
		buffer.append('@');
		buffer.append(ObjectUtils.getIdentityHexString(obj));
	}

	@Override
	public void styleEnd(StringBuilder buffer, Object obj) {
		if (!obj.getClass().isArray()) {
			buffer.append(')');			
		} else {
			buffer.append(']');
		}

	}

	@Override
	public void styleField(StringBuilder buffer, String fieldName, Object value) {
		styleField(buffer, fieldName, value, true);
	}

	@Override
	public void styleField(StringBuilder buffer, String fieldName, Object value, boolean styledFirstField) {
		if (value!=null || includeNulls) {
			if (value!=null) {
				if (!includeEmptyCollections) {
					if (value instanceof Collection && (((Collection<?>)value).isEmpty())) {
						return;
					}
					if (value!=null && !includeEmptyCollections && value.getClass().isArray() && ((Object[])value).length==0) {
						return;
					}
				}
				if (!includeEmptyStrings) {
					if (value instanceof String && ((String)value).isEmpty()) {
						return;
					}
				}
			}
			if (styledFirstField) {
				styleFieldSeparator(buffer);
			}
			styleFieldStart(buffer, fieldName);
			styleValue(buffer, value);
			styleFieldEnd(buffer, fieldName);			
		}
	}

	protected void styleFieldStart(StringBuilder buffer, String fieldName) {
		buffer.append(fieldName).append("=");
	}

	protected void styleFieldEnd(StringBuilder buffer, String fieldName) {
	}

	@Override
	public void styleValue(StringBuilder buffer, Object value) {
		buffer.append(this.valueStyler.style(value));
	}

	@Override
	public void styleFieldSeparator(StringBuilder buffer) {
		buffer.append(", ");
	}

}
