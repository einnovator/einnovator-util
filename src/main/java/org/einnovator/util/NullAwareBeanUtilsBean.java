package org.einnovator.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

public class NullAwareBeanUtilsBean extends BeanUtilsBean {

	private boolean ignoreCollections;

	private boolean overwrite;

	private final Log logger = LogFactory.getLog(getClass());

	public NullAwareBeanUtilsBean() {
	}
	public NullAwareBeanUtilsBean(boolean ignoreCollections, boolean overwrite) {
		this.ignoreCollections = ignoreCollections;
		this.overwrite = overwrite;
	}

	@Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if (value==null) {
        	return;
        }
        if (ignoreCollections && value instanceof Collection) {
        	if (logger.isTraceEnabled()) {
        		logger.trace("copyProperty: skip:" + name);
        	}
        	return;
        }
        if (!overwrite) {
            try {
				Object value0 = super.getProperty(dest, name);
				if (!nullOrEmpty(value0)) {
		        	if (logger.isTraceEnabled()) {
		        		logger.trace("copyProperty: skip:" + name);
		        	}
					return;
				}
			} catch (NoSuchMethodException e) {
			}
        }
    	if (logger.isTraceEnabled()) {
    		logger.trace("copyProperty: " + name + "<-" + value);
    	}
        super.copyProperty(dest, name, value);
    }
    
	protected boolean nullOrEmpty(Object value) {
		if (value==null) {
			return true;
		}
		if (value instanceof String) {
			if (!StringUtils.hasText((String)value)) {
				return true;
			}
		}
		return false;
	}
    public static NullAwareBeanUtilsBean singleton = new NullAwareBeanUtilsBean(false, true);
    public static NullAwareBeanUtilsBean singletonIgnoreCollections = new NullAwareBeanUtilsBean(true, true);

    public static NullAwareBeanUtilsBean singletonNoOverwrite = new NullAwareBeanUtilsBean(false, false);
    public static NullAwareBeanUtilsBean singletonNoOverwriteIgnoreCollections = new NullAwareBeanUtilsBean(true, false);

}