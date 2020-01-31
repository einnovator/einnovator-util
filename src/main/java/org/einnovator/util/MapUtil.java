/**
 * 
 */
package org.einnovator.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

/**
 * A {@code MapUtil}.
 *
 * @author  {@code support@einnovator.org}
 */
public class MapUtil {


	
	public static String toQName(Map<String, Object> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Object> e: map.entrySet()) {
			if (e.getValue()==null) {
				continue;
			}
			if (sb.length()>0) {
				sb.append(",");
			}
			sb.append(e.getKey());
			sb.append("=");
			sb.append(format(e.getValue()));
		}
		return sb.toString();
	}

	public static Map<String, String> parseQName(String qname) {
		if (qname==null) {
			return null;
		}
		Map<String, String> map = new LinkedHashMap<String, String>();
		String[] a= qname.split(",");
		for (String s: a) {
			String key = s.trim();
			if (key.isEmpty()) {
				continue;
			}
			String value = "";
			int i = s.indexOf("=");
			if (i==0) {
				continue;
			}
			if (i==s.length()-1) {
				key = s.substring(0, s.length()-1);
			} else {
				key = s.substring(0, i);
				value = s.substring(i+1);
			}
			map.put(key, value);
			
		}
		return map;
	}

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
	
	@SuppressWarnings("unchecked")
	public static Object resolve(String var,  Object env) {
		Map<String, Object> map = MappingUtils.convert(env, Map.class);
		return resolve(var, map);
	}

	
	public static String format(Object value) {
		if (value==null) {
			return "";
		}
		if (value.getClass().isArray()) {
			if (value instanceof boolean[]) {
				value = ArrayUtils.toObject((boolean[])value);
			} else if (value instanceof int[]) {
				value = ArrayUtils.toObject((int[])value);
			} else if (value instanceof long[]) {
				value = ArrayUtils.toObject((long[])value);
			} else if (value instanceof double[]) {
				value = ArrayUtils.toObject((double[])value);
			} else if (value instanceof float[]) {
				value = ArrayUtils.toObject((float[])value);
			} else if (value instanceof char[]) {
				value = ArrayUtils.toObject((char[])value);
			} else if (value instanceof byte[]) {
				value = ArrayUtils.toObject((byte[])value);
			} else if (value instanceof short[]) {
				value = ArrayUtils.toObject((short[])value);
			}
			return Arrays.deepToString((Object[])value);
		}
		return value.toString();		
	}
	
	public static void print(Map<?, ?> map, PrintStream out) {
		if (map!=null) {
			for (Map.Entry<?, ?> e: map.entrySet()) {
				out.print(e.getKey());
				out.print("=");
				if (e.getValue()!=null) {
					out.println(format(e.getValue()));					
				} else {
					out.println();
				}
			}			
		}
	}
	
	public static void print(Map<?, ?> map) {
		print(map, System.out);
	}

	public static String replaceAll(String s, Map<String, Object> env) {
		if (s!=null && env!=null) {
			for (Map.Entry<String, Object> e: env.entrySet()) {
				s = s.replaceAll(e.getKey(), e.getValue().toString());
			}			
		}
		return s;
	}

}
