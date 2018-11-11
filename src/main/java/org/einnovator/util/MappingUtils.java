package org.einnovator.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingUtils {
	static public ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		//mapper.setSerializationInclusion(SerializationFeature.FAIL_ON_EMPTY_BEANS)		
	}

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String obj, Class<T> type) {
		try {
			return mapper.readValue(obj, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T makeObject(Class<T> type, Map<String, Object> map) {
		if (map==null) {
			return null;
		}
		return mapper.convertValue(map, type);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T makeCopy(T obj) {
		return (T) MappingUtils.convert(obj, obj.getClass());
	}


	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object obj, Map<String, Object> map) {
		if (obj==null) {
			return null;
		}
		map.putAll(mapper.convertValue(obj, LinkedHashMap.class));
		return map;
	}


	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object obj) {
		if (obj==null) {
			return null;
		}
		return mapper.convertValue(obj, LinkedHashMap.class);
	}
	
	public static <T> T convert(Object obj, Class<T> type) {
		if (obj==null || type==null) {
			return null;
		}
		return mapper.convertValue(obj, type);
	}
	
	public static Map<String, String> toMapFormatted(Object obj) {
		Map<String, String> env = new LinkedHashMap<>();
		toMapFormatted(obj, env);
		return env;
	}

	public static Map<String, String> toMapFormatted(Object obj, Map<String, String> env) {
		if (obj==null) {
			return env;
		}
		LinkedHashMap<?,?> map = mapper.convertValue(obj, LinkedHashMap.class);
		for (Map.Entry<?, ?> e: map.entrySet()) {
			env.put(e.getKey().toString(), e.getValue()!=null ? format(e.getValue()) : null);			
		}
		return env;
	}
	
	public static String format(Object obj) {
		if (obj==null) {
			return null;
		}
		if (obj.getClass().isArray()) {
			ArrayList<String> list = new ArrayList<>();
			for (Object e: Arrays.asList((Object[])obj)) {
				list.add(e.toString());
			}
			return String.join(",", list);
		} else if (obj instanceof Collection) {
			ArrayList<String> list = new ArrayList<>();
			for (Object e: (Collection<?>)obj) {
				list.add(e.toString());
			}
			return String.join(",", list);
		}
		return obj.toString();
	}

  
	public static <T> T updateObjectFrom(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		try {
			BeanUtils.copyProperties(current, obj);       
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	public static <T> T updateObjectFromNonNull(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		try {
			NullAwareBeanUtilsBean.singleton.copyProperties(current, obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	public static <T> T updateObjectFromNonNullIgnoreCollections(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		try {
			NullAwareBeanUtilsBean.singletonIgnoreCollections.copyProperties(current, obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	public static <T> T get(String key, Map<String, Object> map, T defaultValue) {
		@SuppressWarnings("unchecked")
		T value = (T)map.get(key);
		if (value==null) {
			value = defaultValue;
		}
		return value;
	}
	
	public static Map<String, Object> put(String name, Object value, Map<String, Object> profile) {
		if (value!=null) {
			String s = value.toString();
			profile.put(name, s);
		}
		return profile;
	}

}
