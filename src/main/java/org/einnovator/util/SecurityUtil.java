package org.einnovator.util;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

	public static Principal getPrincipal() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			Authentication authentication = context.getAuthentication();
			if (authentication != null) {
				if (authentication.getPrincipal() instanceof Principal) {
					return (Principal) authentication.getPrincipal();
				}
			}
		}
		return null;
	}

}
