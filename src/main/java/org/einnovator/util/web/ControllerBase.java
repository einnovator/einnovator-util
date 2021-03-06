package org.einnovator.util.web;

import java.net.URI;
import java.security.Principal;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.einnovator.util.UriUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class ControllerBase {
	
	public static final String ATTRIBUTE_REDIRECT_URI = "redirect_uri";

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired(required=false)
	protected MessageSource messageSource;
	
	@Autowired(required=false)
	protected LocaleResolver localeResolver;

	
	protected String format(HttpStatus status) {
		return status + " " + status.getReasonPhrase();
	}
	
	protected String format(Object... objs) {
		StringBuilder sb = new StringBuilder();
		if (objs!=null) {
			for (Object obj: objs) {
				if (obj!=null) {
					if (sb.length()>0) {
						sb.append(" ");
					}
					sb.append(format(obj));				
				}
			}			
		}
		return sb.toString();
	}
	
	protected String format(Object obj) {
		if (obj==null) {
			return null;
		}
		if (obj instanceof Class) {
			return ((Class<?>)obj).getSimpleName();
		}
		if (obj instanceof Principal) {
			return ((Principal)obj).getName();
		}
		return obj.toString();
	}


	protected String error(String msg, Throwable t, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String key = Messages.KEY_FAILURE;
		String defaultMsg = Messages.MSG_FAILURE;
		Object[] args = null;
		if (t instanceof AccessDeniedException) {
			key = Messages.KEY_FORBIDDEN;
			defaultMsg = Messages.MSG_FORBIDDEN;
		}
		return flashError (msg, key, args, defaultMsg, request, redirectAttributes);
	}

	protected <T> ResponseEntity<T> status(String msg, Throwable t, HttpServletResponse response, Object... objs) {
		HttpStatus status;
		if (t instanceof AccessDeniedException) {
			status = HttpStatus.FORBIDDEN;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		response.setStatus(status.value());
		logger.error(String.format("%s: %s %s %s", msg, format(status), t, format(objs)));
		return ResponseEntity.status(status).build();
	}

	protected void info(String msg, Object... objs) {
		if (logger.isInfoEnabled()) {
			logger.info(String.format("%s: %s", msg, format(objs)));			
		}
	}

	protected void debug(String msg, Object... objs) {
		if (logger.isDebugEnabled()) {
			logger.info(String.format("%s: %s", msg, format(objs)));			
		}
	}

	protected void error(String msg, Object... objs) {
		if (logger.isErrorEnabled()) {
			logger.error(String.format("%s: %s", msg, format(objs)));			
		}
	}

	protected void warn(String msg, Object... objs) {
		if (logger.isWarnEnabled()) {
			logger.warn(String.format("%s: %s", msg, format(objs)));			
		}
	}

	protected <T> ResponseEntity<T> status(String msg, HttpStatus status, HttpServletResponse response, Object... objs) {
		response.setStatus(status.value());
		if (status.is2xxSuccessful() || status.is3xxRedirection()) {
			if (logger.isDebugEnabled()) {
				logger.debug(String.format("%s %s %s", msg, format(status), format(objs)));				
			}
		} else {
			if (logger.isErrorEnabled()) {
				logger.error(String.format("%s %s %s", msg, format(status), format(objs)));							
			}
		}
		return ResponseEntity.status(status).build();
	}

	protected String flash(String type, String key, Object[] args, String defaultMsg, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String msg = makeMessage(key, args, defaultMsg, request);
		request.setAttribute(type, msg);
		redirectAttributes.addFlashAttribute(type, msg);
		return defaultMsg!=null ? defaultMsg : msg;
	}

	protected String makeMessage(String key, Object[] args, String defaultMsg, HttpServletRequest request) {
		String msg = defaultMsg;
		if (messageSource!=null && key!=null) {
			Locale locale = null;
			if (localeResolver!=null) {
				locale = localeResolver.resolveLocale(request);
			}
			if (locale==null) {
				locale = Locale.getDefault();
			}
			msg = messageSource.getMessage(key, args, defaultMsg, locale);
		}
		return StringUtils.hasText(msg) ? msg : defaultMsg;
	}

	protected String flashError(String msg, String key, Object[] args, String defaultMsg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		error(msg, objs);
		return flash(Messages.ATTRIBUTE_ERROR, key, args, defaultMsg, request, redirectAttributes);
	}

	protected String flashInfo(String msg, String key, Object[] args, String defaultMsg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		info(msg, objs);
		return flash(Messages.ATTRIBUTE_INFO, key, args, defaultMsg, request, redirectAttributes);
	}

	protected String flashError(String msg, String defaultMsg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, null, null, defaultMsg, request, redirectAttributes, objs);
	}

	protected String flashInfo(String msg, String defaultMsg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashInfo(msg, null, null, defaultMsg, request, redirectAttributes, objs);
	}

	protected String flashError(String msg, String defaultMsg, RedirectAttributes redirectAttributes, Object... objs) {
		error(msg, objs);
		return flashError(msg, defaultMsg,  WebUtil.getHttpServletRequest(), redirectAttributes);
	}

	protected String flashInfo(String msg, String defaultMsg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashInfo(msg, null, null, defaultMsg,  WebUtil.getHttpServletRequest(), redirectAttributes, objs);
	}

	protected String flash(String type, String key, Object[] args, String defaultMsg, RedirectAttributes redirectAttributes) {
		return flash(type, key, args, defaultMsg, WebUtil.getHttpServletRequest(), redirectAttributes);
	}

	protected String flashSuccess(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashInfo(msg, Messages.KEY_SUCCESS, null, Messages.MSG_SUCCESS, request, redirectAttributes, objs);
	}

	protected String flashSuccess(String msg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashSuccess(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);
	}

	protected String flashFailure(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, Messages.KEY_FAILURE, null, Messages.MSG_FAILURE, request, redirectAttributes, objs);
	}

	protected String flashFailure(String msg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashFailure(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);
	}

	protected String flashUnauthorized(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, Messages.KEY_UNAUTHORIZED, null, Messages.MSG_UNAUTHORIZED, request, redirectAttributes, objs);		
	}
	
	protected String flashUnauthorized(String msg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashUnauthorized(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);		
	}

	protected <T> ResponseEntity<T> unauthorized(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.UNAUTHORIZED, response, objs);		
	}

	protected String flashForbidden(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, Messages.KEY_FORBIDDEN, null, Messages.MSG_FORBIDDEN, request, redirectAttributes, objs);		
	}
	
	protected String flashForbidden(String msg,RedirectAttributes redirectAttributes, Object... objs) {
		return flashForbidden(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);		
	}

	protected <T> ResponseEntity<T> forbidden(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.FORBIDDEN, response, objs);		
	}

	protected String flashNotfound(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, Messages.KEY_NOT_FOUND, null, Messages.MSG_NOT_FOUND, request, redirectAttributes, objs);		
	}

	protected String flashNotfound(String msg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashNotfound(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);		
	}

	protected <T> ResponseEntity<T> notfound(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.NOT_FOUND, response, objs);		
	}

	protected String flashBadrequest(String msg, HttpServletRequest request, RedirectAttributes redirectAttributes, Object... objs) {
		return flashError(msg, Messages.KEY_FAILURE, null, Messages.MSG_FAILURE, request, redirectAttributes, objs);		
	}
	
	protected String flashBadrequest(String msg, RedirectAttributes redirectAttributes, Object... objs) {
		return flashBadrequest(msg, WebUtil.getHttpServletRequest(), redirectAttributes, objs);		
	}
	
	protected <T> ResponseEntity<T> badrequest(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.BAD_REQUEST, response, objs);		
	}
	
	protected <T> ResponseEntity<T> internalerror(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.INTERNAL_SERVER_ERROR, response, objs);		
	}

	protected <T> ResponseEntity<T> conflict(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.CONFLICT, response, objs);		
	}

	protected <T> ResponseEntity<T> ok(T result, String msg, HttpServletResponse response, Object... objs) {
		status(msg, HttpStatus.OK, response, objs);		
		return new ResponseEntity<T>(result, HttpStatus.OK);
	}

	protected <T> ResponseEntity<T> nocontent(String msg, HttpServletResponse response, Object... objs) {
		return status(msg, HttpStatus.NO_CONTENT, response, objs);		
	}

	protected <T> ResponseEntity<T> created(URI location, String msg, HttpServletResponse response, Object... objs) {
		status(msg, HttpStatus.CREATED, response, objs);	
		return ResponseEntity.created(location).build();
	}

	public static boolean adminAccess(HttpServletRequest request) {
		return request.getRequestURI().indexOf("/admin")>=0;
	}

	public static boolean adminAccess(HttpServletRequest request, Model model) {
		boolean _admin = adminAccess(request);
		model.addAttribute("_admin", _admin);		
		return _admin;
	}
	
	public static String redirect(boolean admin, String uri) {
		return "redirect:" + (admin ? "/admin" : "") + uri;	
	}
	
	public static String redirect(String uri) {
		return "redirect:" + uri;	
	}

	protected String parseUri(String uri, Map<String, String> hosts, Map<String, Object> env) {
		return UriUtils.parseUri(uri, hosts, env);
	}


	protected String parseUri(String uri) {
		return UriUtils.parseUri(uri, getHosts(), null);
	}
	
	protected Map<String, String> getHosts() {
		return null;
	}

	protected String redirect(String uri, HttpSession session) {
		return redirect(uri, null, session);
	}

	protected String redirect(String uri, String redirect_uri, HttpSession session) {
		if (session!=null) {
			String redirect = (String)session.getAttribute(ATTRIBUTE_REDIRECT_URI);
			if (redirect!=null) {
				session.removeAttribute(ATTRIBUTE_REDIRECT_URI);
				return redirect(parseUri(redirect));
			}
		}	
		if (StringUtils.hasText(redirect_uri)) {
			return redirect(parseUri(redirect_uri));
		} 
		return redirect(uri);
	}

}
