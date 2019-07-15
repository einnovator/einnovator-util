/**
 * 
 */
package org.einnovator.util;

import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * Environment Utilities.
 *
 */
public class EnvUtil {

	public static final String SPRING_PROFILES_ACTIVE = "SPRING_PROFILES_ACTIVE";
	public static final String SPRING_PROFILES_INCLUDE = "SPRING_PROFILES_INCLUDE";
	
	public static String getEnv(String var) {
		var = var.replace('.', '_');
		for (Map.Entry<String, String> e: System.getenv().entrySet()) {
			String key = e.getKey();
			key = key.replace('.', '_');
			if (var.equalsIgnoreCase(key)) {
				return e.getValue();
			}
		}
		return null;
	}
	
	public static void dumpEnv() {
		for (Map.Entry<String, String> e: System.getenv().entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}		
	}
	
	public static boolean isSpringProfileActive(String name) {
		String profilesActive = getEnv(SPRING_PROFILES_ACTIVE);
		if (StringUtils.hasText(profilesActive)) {
			String[] pp = profilesActive.split(",");
			if (StringUtil.contains(pp, name)) {
				return true;
			}
		}
		String profilesInclude = getEnv(SPRING_PROFILES_INCLUDE);
		if (StringUtils.hasText(profilesInclude)) {
			String[] pp = profilesInclude.split(",");
			if (StringUtil.contains(pp, name)) {
				return true;
			}
		}
		return false;
	}
	
}
