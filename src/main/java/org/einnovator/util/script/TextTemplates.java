package org.einnovator.util.script;

import java.util.Map;

import org.einnovator.util.MappingUtils;

public class TextTemplates {

	public static final String DEFAULT_START_MARKER = "${";
	public static final String DEFAULT_END_MARKER = "}";
	
	protected String startMarker = DEFAULT_START_MARKER;

	protected String endMarker = DEFAULT_END_MARKER;

	protected VariableResolver resolver;
	
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
	
	public TextTemplates(String startMarker, String endMarker, VariableResolver resolver) {
		this.startMarker = startMarker;
		this.endMarker = endMarker;
		this.resolver = resolver;
	}

	public String expand(String text, Map<String, Object> env) {
		return expand(text, this.resolver, env);
	}


	public String expand(String text, VariableResolver resolver, Map<String, Object> env) {
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

	public String resolve(String var, VariableResolver resolver, Map<String, Object> env) {
		if (resolver!=null) {
			Object value = resolver.resolve(env, var);			
			if (value!=null) {
				return format(value);
			}
		}
		return resolve(var, env);
	}

	@SuppressWarnings("unchecked")
	public String resolve(String var,  Map<String, Object> env) {
		var = var.trim();
		Object value = env.get(var);
		if (value!=null) {
			return value.toString();
		}
		if (var.contains(".")) {
			String[] a = var.split("\\.");
			int i = 0;
			for (String s: a) {
				value = env.get(s);
				if (value instanceof Map) {
					env = (Map<String, Object>) value;
				} else if (i<a.length-1) {
					env = MappingUtils.toMap(value);
				}
				if (value==null) {
					return null;
				}
				i++;
			}
			return value!=null ? value.toString() : null;			
		}
		return null;
	}
	
	
	protected String format(Object obj) {
		if (obj==null) {
			return null;
		}
		return obj.toString();
	}
}
