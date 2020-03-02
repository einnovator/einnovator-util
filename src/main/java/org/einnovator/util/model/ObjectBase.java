package org.einnovator.util.model;

import java.util.Map;

import org.einnovator.util.MappingUtils;
import org.einnovator.util.web.RequestOptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Support type for framework and application objects.
 *
 * @author support@einnovator.org
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ObjectBase {
	
	//
	// Constructors
	//

	/**
	 * Create instance of {@code ObjectBase}.
	 *
	 */
	public ObjectBase() {
	}
	
	/**
	 * Create instance of {@code ObjectBase}.
	 *
	 * @param obj a prototype
	 */
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

	//
	// Update state using reflection
	//
	
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

	
	/**
	 * Returns this {@code Object} cast to specified type.
	 * 
	 * @return this {@code Object}
	 */
	@SuppressWarnings("unchecked")
	public <T extends RequestOptions> T as(Class<T> type) {
		return (T)this;
	}
}