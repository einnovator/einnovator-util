/**
 * 
 */
package org.einnovator.util.web;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jsima
 *
 */
public class WebUtil {

	public static String getBaseUrl(HttpServletRequest request) {
		String url = request.getRequestURL().toString();
		if (request.getPathInfo()!=null) {
			int n = request.getPathInfo().length();			
			return url.substring(0, url.length() - n);
		}
		int n = url.lastIndexOf("/");
		return url.substring(0, n);
	}
}
