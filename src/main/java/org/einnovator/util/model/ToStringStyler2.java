package org.einnovator.util.model;

import org.springframework.core.style.ToStringStyler;

public interface ToStringStyler2 extends ToStringStyler {

	void styleField(StringBuilder buffer, String fieldName, Object value, boolean styledFirstField);

}
