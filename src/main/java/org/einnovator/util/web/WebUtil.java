/**
 * 
 */
package org.einnovator.util.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author support@einnovator.org
 *
 */
public class WebUtil {

	public static String getBaseUrl(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		if (request.getPathInfo()!=null) {
			int n = request.getPathInfo().length();			
			return url.substring(0, url.length() - n);
		}
		int n = url.indexOf("/",  8);
		return url.substring(0, n);
	}
	
	public static String getBaseUrl() {
		HttpServletRequest request = getHttpServletRequest();
		if (request==null) {
			return null;
		}
		return getBaseUrl(request);
	}
	
	public static HttpServletRequest getHttpServletRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = null;
		if (attrs!=null) {
			request = attrs.getRequest();
		}
		return request;
	}
	
	public static HttpSession getHttpSessionFromRequest() {
		try {
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
		    HttpServletRequest request = attributes.getRequest();
		    HttpSession session = request.getSession(false);
		    return session;
		} catch (RuntimeException e) {
			return null;
		}
	}

	public static String getRequestUri() {
		HttpServletRequest request = getHttpServletRequest();
		if (request==null) {
			return null;
		}
		return request.getRequestURI();
	}

	public static String getHost(boolean header, boolean server) {
		HttpServletRequest request = getHttpServletRequest();
		if (request==null) {
			return null;
		}
		if (header) {
			String host = request.getHeader(HttpHeaders.HOST);
			if (StringUtils.hasText(host)) {
				return host;
			}			
		}
		if (server) {
			return request.getServerName();			
		}
		return null;
	}

	public static String getHost() {
		return getHost(true, true);
	}

	public static final String[] IP_HEADERS = { 
			"X-Forwarded-For",
			"Proxy-Client-IP",
			"WL-Proxy-Client-IP",
			"HTTP_X_FORWARDED_FOR",
			"HTTP_X_FORWARDED",
			"HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP",
			"HTTP_FORWARDED_FOR",
			"HTTP_FORWARDED",
			"HTTP_VIA",
			"REMOTE_ADDR"
	};
	
	public static String getRemoteIp(HttpServletRequest request) {
		if (request==null) {
			return null;
		}
		for (String header : IP_HEADERS) {
			String ip = request.getHeader(header);
			if (StringUtils.hasText(ip) && !ip.toLowerCase().contains("unknown")) {
				ip = ip.trim();
				int i = ip.indexOf(",");
				if (i>0) {
					ip = ip.substring(0, i);
				}
				ip = ip.trim();
				return ip;
			}
		}
		return request.getRemoteAddr();
	}
	
	public static String getRemoteIp() {
		return getRemoteIp(getHttpServletRequest());
	}

}
