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

	public static final String MARKER = "$";
	
	public String expand(String text, Map<String, Object> env) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i<text.length()) {
			int i1 = text.indexOf(MARKER+"{", i);
			if (i1>=0) {
				sb.append(text.substring(i, i1));
				int i2 = text.indexOf("}", i1+2);
				if (i2<0) {
					//ERROR
					sb.append("?{..?");
					sb.append(text.substring(i));
					break;
				}
				String var = text.substring(i1+2, i2);
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
		String[] a = var.split("\\.");
		Object value = null;
		int i = 0;
		for (String s: a) {
			value = env.get(s);
			if (value instanceof Map) {
				env = (Map<String, Object>) value;
			} else if (i<a.length-1) {
				env = MappingUtils.toMap(value);
			}
			i++;
		}
		return value!=null ? value.toString() : null;
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
