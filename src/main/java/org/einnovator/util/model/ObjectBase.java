package org.einnovator.util.model;

import java.util.Map;

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
		update(obj, true);
	}

	public void updateFrom(Object obj, boolean ignoreCollections) {
		update(obj, ignoreCollections);
	}
	
	public void updateFrom(Object obj, boolean ignoreCollections, boolean overwrite) {
		update(obj, ignoreCollections, overwrite);
	}
	
	public void update(Object from) {
		update(from, true, true);
	}
	
	public void update(Object obj, boolean ignoreCollections) {
		update(obj, ignoreCollections, true);
	}
	
	@SuppressWarnings("unchecked")
	public void update(Object from, boolean ignoreCollections, boolean overwrite) {
		if (from instanceof Map) {
			MappingUtils.fromMap(this, (Map<String, Object>)from);
			return;
		} 
		if (overwrite) {
			if (ignoreCollections) {
				MappingUtils.updateObjectFromNonNullIgnoreCollections(this, from);							
			} else {
				MappingUtils.updateObjectFromNonNull(this, from);											
			}
		} else {
			if (ignoreCollections) {
				MappingUtils.updateObjectFromNonNullNoOverwriteIgnoreCollections(this, from);
			} else {
				MappingUtils.updateObjectFromNonNullNoOverwrite(this, from);				
			}
		}
	}


}