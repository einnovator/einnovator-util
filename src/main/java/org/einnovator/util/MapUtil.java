/**
 * 
 */
package org.einnovator.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A {@code MapUtil}.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class MapUtil {


	public static Map<String, List<String>> mapToListValues(Map<String, String> map) {
		Map<String, List<String>> map2 = new LinkedHashMap<String, List<String>>();
		for (Map.Entry<String, String> e: map.entrySet()) {
			List<String> values = map2.get(e.getKey());
			if (values==null) {
				values = new ArrayList<String>();
				map2.put(e.getKey(), values);
			}
			values.add(e.getValue());
		}
		return map2;
	}

	
	public static String toString(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		boolean first = true;
		for (Map.Entry<?, ?> e: map.entrySet()) {
			if (!first) {
				sb.append(", ");
			} else {
				first = false;
			}
			sb.append(e.getKey());
			sb.append(": ");
			sb.append(CollectionUtil.toString(e.getValue()));
		}
		sb.append(" }");
		return sb.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static Object resolve(String var,  Map<String, Object> env) {
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
			return value;			
		}
		return null;
	}

}
