/**
 * 
 */
package org.einnovator.util;

import java.security.Principal;

import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.util.StringUtils;

/**
 * @author jsima
 *
 */
public class CacheUtils {

	@SuppressWarnings("unchecked")
	protected <T> T getCacheValueForPrincipal(Class<T> type, Cache cache, Object... keys) {
		if (cache==null) {
			return null;
		}
		Principal principal = SecurityUtil.getPrincipal();
		if (principal==null) {
			return null;
		}
		String key = makeKeyForPrincipal(keys);
		ValueWrapper value = cache.get(key);
		if (value!=null) {
			T val = (T)value.get();
			return val;
		}
		return null;
	}

	protected <T> T putCacheValueForPrincipal(T value, Cache cache, Object... keys) {
		if (cache==null) {
			return value;
		}
		Principal principal = SecurityUtil.getPrincipal();
		if (principal==null) {
			return value;
		}
		String key = makeKeyForPrincipal(keys);
		cache.put(key, value);
		return value;
	}


	@SuppressWarnings("unchecked")
	protected <T> T getCacheValue(Class<T> type, Cache cache, Object... keys) {
		if (cache==null) {
			return null;
		}
		String key = makeKey(keys);
		if (key!=null) {
			ValueWrapper value = cache.get(key);
			if (value!=null) {
				T val = (T)value.get();
				return val;			}
		}
		return null;
	}

	protected <T> T putCacheValue(T value, Cache cache, Object... keys) {
		if (cache==null) {
			return value;
		}
		String key = makeKey(keys);
		if (key!=null) {
			cache.put(key, value);
		}
		return value;
	}

	protected String makeKeyForPrincipal(Object... keys) {
		Principal principal = SecurityUtil.getPrincipal();
		if (principal==null) {
			return null;
		}
		String key = makeKey(keys);
		return StringUtils.hasText(key) ? principal.getName() + ":" + key : principal.getName();
	}
		

	protected String makeKey(Object... keys) {
		StringBuilder sb = new StringBuilder();
		for (Object key: keys) {
			if (key!=null) {
				if (sb.length()>0) {
					sb.append(":");						
				}
				if (key instanceof String) {
					sb.append(key);
				} else {
					sb.append(key.hashCode());
				}				
			}
		}
		return sb.toString();
	}


}
