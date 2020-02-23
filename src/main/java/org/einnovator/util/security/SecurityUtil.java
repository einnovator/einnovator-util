package org.einnovator.util.security;

import java.security.Principal;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class SecurityUtil {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";

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

	public static Collection<? extends GrantedAuthority> getAuthorities() {
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

	/**
	 * Check if role or authority exists in {@link Collection}.
	 * 
	 * @param role
	 * @param authorities
	 * @return
	 */
	public static boolean hasAuthority(String role, Collection<? extends GrantedAuthority> authorities) {
		if (role==null || authorities==null) {
			return false;
		}
		for (GrantedAuthority authority : authorities) {
			if (authority.getAuthority().equalsIgnoreCase(role)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAnonymous() {
		Authentication authentication = getAuthentication();
		return authentication!=null && authentication instanceof AnonymousAuthenticationToken;		
	}

	public static final Map<String, Object> getPrincipalDetails() {
		Authentication authentication = SecurityUtil.getAuthentication();
		if (authentication==null) {
			return null;
		}
		if (authentication instanceof OAuth2Authentication) {
			OAuth2Authentication authentication2 = (OAuth2Authentication)authentication;
			if (authentication2.getUserAuthentication() instanceof UsernamePasswordAuthenticationToken) {
				UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken)authentication2.getUserAuthentication();
				@SuppressWarnings("unchecked")
				Map<String, Object> details = (Map<String, Object>)authToken.getDetails();
				return details;				
			}
		}
		return null;
	}
}
