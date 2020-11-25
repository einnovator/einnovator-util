package org.einnovator.util.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.util.multitenant.MultitenantResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.util.StringUtils;

/**
 * A {@code CachingManagerBase}
 *
 * @author support@einnovator.org
 */
public class CachingManagerBase {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired(required=false)
	private MultitenantResolver multitenantResolver;
	
	protected <T> T getCacheValueForPrincipal(Class<T> type, Cache cache, Object... keys) {
		return CacheUtils.getCacheValueForPrincipal(type, cache, makeKey(keys));
	}

	protected <T> T putCacheValueForPrincipal(T value, Cache cache, Object... keys) {
		return CacheUtils.putCacheValueForPrincipal(value, cache, makeKey(keys));
	}
	
	public <T> T getCacheValueForUser(Class<T> type, Cache cache, String username, Object... keys) {
		return CacheUtils.getCacheValueForUser(type, cache, username, makeKey(keys));
	}
	
	public <T> T putCacheValueForUser(T value, Cache cache, String username, Object... keys) {
		return CacheUtils.putCacheValueForUser(value, cache, username, makeKey(keys));
	}

	protected <T> T getCacheValue(Class<T> type, Cache cache, Object... keys) {
		return CacheUtils.getCacheValue(type, cache, makeKey(keys));
	}

	protected <T> T putCacheValue(T value, Cache cache, Object... keys) {
		return CacheUtils.putCacheValue(value, cache, makeKey(keys));
	}
	
	protected String makeKey(Object... keys) {
		String tenant = getTenant();
		String key = CacheUtils.makeKey(keys);
		return StringUtils.hasText(tenant) ? tenant + ":" + key : key;
	}

	protected String makeKeyForPrincipal(Object... keys) {
		String tenant = getTenant();
		String key = CacheUtils.makeKeyForPrincipal(keys);
		return StringUtils.hasText(tenant) ? tenant + ":" + key : key;
	}

	protected String makeKeyForUser(String username, Object... keys) {
		String tenant = getTenant();
		String key = CacheUtils.makeKeyForUser(username, keys);
		return StringUtils.hasText(tenant) ? tenant + ":" + key : key;
	}
	
	protected String getTenant() {
		if (multitenantResolver==null) {
			return null;
		}
		return multitenantResolver.getTenant();
	}


}
