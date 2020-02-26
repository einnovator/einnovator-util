package org.einnovator.util;

import java.util.Locale;

import org.springframework.util.StringUtils;

/**
 * Miscellaneous utility methods related with i18n.
 *
 * @author {@code support@einnovator.org}
 *
 */
public class I18nUtil {

	public static Locale parseLocale(String s, Locale defaultLocale) {
		if (!StringUtils.hasText(s)) {
			return defaultLocale;
		}			
		String[] a = s.split(",");
		if (a.length==1) {
			return new Locale(s.trim());
		}
		if (a.length==2) {
			return new Locale(a[0], a[1]);
		}
		if (a.length>=3) {
			return new Locale(a[0], a[1], a[2]);
		}
		return defaultLocale;
	}

}
