package org.einnovator.util;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

	public static String getPrincipalName() {
		Principal principal = getPrincipal();
		return principal!=null ? principal.getName() : null;
	}

	public static Principal getPrincipal() {
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			if (authentication instanceof Principal) {
				return authentication;
			}
			if (authentication.getPrincipal() instanceof Principal) {
				return (Principal) authentication.getPrincipal();
			}
		}
		return null;
	}

	public static Collection<? extends GrantedAuthority> getAuthorites() {
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			return authentication.getAuthorities();
		}
		return null;
	}

	public static  Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			return context.getAuthentication();
		}
		return null;
	}



}
