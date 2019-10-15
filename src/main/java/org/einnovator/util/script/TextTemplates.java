package org.einnovator.util.script;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.einnovator.util.IOUtil;
import org.einnovator.util.MapUtil;
import org.springframework.core.io.Resource;

public class TextTemplates {

	public static final String DEFAULT_START_MARKER = "${";
	public static final String DEFAULT_END_MARKER = "}";
	public static final String DEFAULT_VALUE_SEPARATOR = ":";
	
	protected String startMarker = DEFAULT_START_MARKER;

	protected String endMarker = DEFAULT_END_MARKER;

	protected ExpressionResolver resolver;
	
	/**
	 * Create instance of {@code TextTemplates}.
	 *
	 */
	public TextTemplates() {
	}
	
	/**
	 * Create instance of {@code TextTemplates}.
	 *
	 */
	public TextTemplates(String startMarker, String endMarker) {
		this.startMarker = startMarker;
		this.endMarker = endMarker;
	}
	
	public TextTemplates(String startMarker, String endMarker, ExpressionResolver resolver) {
		this.startMarker = startMarker;
		this.endMarker = endMarker;
		this.resolver = resolver;
	}
	
	public TextTemplates(ExpressionResolver resolver) {
		this(DEFAULT_START_MARKER, DEFAULT_END_MARKER, resolver);
	}
	
	/**
	 * Get the value of property {@code startMarker}.
	 *
	 * @return the startMarker
	 */
	public String getStartMarker() {
		return startMarker;
	}

	/**
	 * Set the value of property {@code startMarker}.
	 *
	 * @param startMarker the startMarker to set
	 */
	public void setStartMarker(String startMarker) {
		this.startMarker = startMarker;
	}

	/**
	 * Get the value of property {@code endMarker}.
	 *
	 * @return the endMarker
	 */
	public String getEndMarker() {
		return endMarker;
	}

	/**
	 * Set the value of property {@code endMarker}.
	 *
	 * @param endMarker the endMarker to set
	 */
	public void setEndMarker(String endMarker) {
		this.endMarker = endMarker;
	}

	/**
	 * Get the value of property {@code resolver}.
	 *
	 * @return the resolver
	 */
	public ExpressionResolver getResolver() {
		return resolver;
	}

	/**
	 * Set the value of property {@code resolver}.
	 *
	 * @param resolver the resolver to set
	 */
	public void setResolver(ExpressionResolver resolver) {
		this.resolver = resolver;
	}

	public InputStream expandAsStream(InputStream in, Map<String, Object> env) {
		String s = expand(in, env);
		if (s==null) {
			return null;
		}
		return new ByteArrayInputStream(s.getBytes());
	}
	
	public String expand(InputStream in, Map<String, Object> env) {
		String s = IOUtil.readFile(in);
		if (s==null) {
			return null;
		}
		return expand(s, env);
	}

	public String expand(Resource resource, Map<String, Object> env) {
		try {
			return expand(resource.getInputStream(), env);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String expand(String text, Map<String, Object> env) {
		return expand(text, this.resolver, env);
	}


	public String expand(String text, ExpressionResolver resolver, Map<String, Object> env) {
		if (text==null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<text.length()) {
			int i1 = text.indexOf(startMarker, i);
			if (i1>=0) {
				sb.append(text.substring(i, i1));
				int i2 = text.indexOf(endMarker, i1+2);
				if (i2<0) {
					//ERROR
					sb.append(startMarker);
					sb.append(text.substring(i));
					break;
				}
				String var = text.substring(i1+startMarker.length(), i2);
				String value = resolve(var, resolver, env);
				if (value==null) {
					value = startMarker + var + endMarker;
				}
				sb.append(value);
				i = i2+1;				
			} else {
				sb.append(text.substring(i));
				break;
			}
		}
		return sb.toString();
	}

	public String resolve(String expr, ExpressionResolver resolver, Map<String, Object> env) {
		if (resolver!=null) {
			Object value = resolver.eval(expr, env);			
			if (value!=null) {
				String result = format(value);
				if (!result.equals(expr)) {
					return result;					
				}
			}
		}
		return resolve(expr, env);
	}

	public String resolve(String var,  Map<String, Object> env) {
		String defaultValue = null;
		if (var!=null) {
			int i = var.indexOf(DEFAULT_VALUE_SEPARATOR);
			if (i>0 && i<var.length()-1) {
				defaultValue = var.substring(i+1);
				var = var.substring(0,i);
			}
		}
		Object value = MapUtil.resolve(var, env);
		if (value==null) {
			value = defaultValue;
		}
		return format(value);
	}
	
	
	protected String format(Object obj) {
		if (obj==null) {
			return null;
		}
		return obj.toString();
	}
}
