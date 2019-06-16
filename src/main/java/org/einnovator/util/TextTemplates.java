package org.einnovator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TextTemplates {

	public static final String DEFAULT_START_MARKER = "${";
	public static final String DEFAULT_END_MARKER = "}";
	
	protected String startMarker = DEFAULT_START_MARKER;

	protected String endMarker = DEFAULT_END_MARKER;

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


	public String expand(String text, Map<String, Object> env) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<text.length()) {
			int i1 = text.indexOf(startMarker, i);
			if (i1>=0) {
				sb.append(text.substring(i, i1));
				int i2 = text.indexOf(endMarker, i1+2);
				if (i2<0) {
					//ERROR
					sb.append("?{..?");
					sb.append(text.substring(i));
					break;
				}
				String var = text.substring(i1+startMarker.length(), i2);
				String value = resolve(var, env);
				if (value==null) {
					value = "?" + var + "?";
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
	
	
	
	public static String readResource(String filename) {
		try {
			Resource resource = new ClassPathResource(filename);
			InputStream inputStream = resource.getInputStream();
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, Charset.forName("UTF-8"));
			String s = writer.toString();
			return s;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
