package org.einnovator.util.model;

import org.einnovator.util.MappingUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ObjectBase {

	public ObjectBase() {
	}
	
	public ObjectBase(Object obj) {
		updateFrom(obj, false);
	}
	
	@Override
	public String toString() {
		return toString(new ToStringCreator(this, new DefaultToStringStyler2())).toString();
	}

	public ToStringCreator toString(ToStringCreator creator) {
		return toString2(toString1(toString0(creator)));
	}

	public ToStringCreator toString0(ToStringCreator creator) {
		return creator;
	}

	public ToStringCreator toString1(ToStringCreator creator) {
		return creator;
	}

	public ToStringCreator toString2(ToStringCreator creator) {
		return creator;
	}

	public void updateFrom(Object obj) {		
		updateFrom(obj, true);
	}

	public void updateFrom(Object obj, boolean ignoreCollections) {
		if (ignoreCollections) {
			MappingUtils.updateObjectFromNonNullIgnoreCollections(this, obj);			
		} else {
			MappingUtils.updateObjectFromNonNull(this, obj);						
		}
	}

}