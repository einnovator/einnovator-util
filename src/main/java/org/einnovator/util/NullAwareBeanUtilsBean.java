package org.einnovator.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.apache.commons.beanutils.BeanUtilsBean;

public class NullAwareBeanUtilsBean extends BeanUtilsBean {

	private boolean ignoreCollections;

	private boolean overwrite;

	public NullAwareBeanUtilsBean() {
	}
	public NullAwareBeanUtilsBean(boolean ignoreCollections, boolean overwrite) {
		this.ignoreCollections = ignoreCollections;
	}

	@Override
    public void copyProperty(Object dest, String name, Object value)
            throws IllegalAccessException, InvocationTargetException {
        if (value==null) {
        	return;
        }
        if (ignoreCollections && value instanceof Collection) {
        	return;
        }
        super.copyProperty(dest, name, value);
    }
    
    public static NullAwareBeanUtilsBean singleton = new NullAwareBeanUtilsBean(false, true);
    public static NullAwareBeanUtilsBean singletonIgnoreCollections = new NullAwareBeanUtilsBean(true, true);

    public static NullAwareBeanUtilsBean singletonNoOverwrite = new NullAwareBeanUtilsBean(false, false);
    public static NullAwareBeanUtilsBean singletonNoOverwriteIgnoreCollections = new NullAwareBeanUtilsBean(true, false);

}