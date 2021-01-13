package org.einnovator.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MappingUtils {
	static public ObjectMapper mapper = new ObjectMapper();

	static {
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		//mapper.setSerializationInclusion(SerializationFeature.FAIL_ON_EMPTY_BEANS)		
	}

	public static ObjectMapper getSingletonMapper() {
		return mapper;
	}
	
	public static <T> T readJson(Resource resource, Class<T> type) {
		try {
			return readJson(resource.getInputStream(), type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T readJson(InputStream in, Class<T> type) {
		if (in==null) {
			return null;
		}
		try {
			return mapper.readValue(in, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String toJsonPrettyPrint(Object obj) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String obj, Class<T> type) {
		if (obj==null) {
			return null;
		}
		try {
			return mapper.readValue(obj, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> fromJsonAsList(String s, Class<T> type, Class<?> arrayType) {
		if (s==null || s.isEmpty()) {
			return null;
		}
		T[] a = (T[])fromJson(s, arrayType);
		if (a==null) {
			return null;
		}
		return new ArrayList<T>(Arrays.asList(a));			
	}

	public static <T> T makeObject(Class<T> type, Map<String, Object> map) {
		if (map==null) {
			return null;
		}
		return mapper.convertValue(map, type);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T makeCopy(T obj) {
		if (obj==null) {
			return null;
		}
		try {
			return (T)BeanUtils.cloneBean(obj);
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
			return null;
		}
	}

	public static <T> T fromMap(T obj, Map<String, Object> map) {
		if (obj==null) {
			return null;
		}
		try {
			BeanUtils.populate(obj, map);
		} catch (IllegalAccessException | InvocationTargetException e) {
			return null;
		}
		return obj;
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

  
	@SuppressWarnings("unchecked")
	public static <T> T updateObjectFrom(T current, Object obj) {
		if (current==null || obj==null) {
			return current;
		}
		if (obj instanceof Map && !(current instanceof Map)) {
			return fromMap(current, (Map<String, Object>)obj);
		}
		try {
			BeanUtils.copyProperties(current, obj);       
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T updateObjectFromNonNull(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		if (obj instanceof Map && !(current instanceof Map)) {
			return fromMap(current, (Map<String, Object>)obj);
		}

		try {
			NullAwareBeanUtilsBean.singleton.copyProperties(current, obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T updateObjectFromNonNullIgnoreCollections(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		if (obj instanceof Map && !(current instanceof Map)) {
			return fromMap(current, (Map<String, Object>)obj);
		}
		try {
			NullAwareBeanUtilsBean.singletonIgnoreCollections.copyProperties(current, obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T updateObjectFromNonNullNoOverwrite(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		if (obj instanceof Map && !(current instanceof Map)) {
			return fromMap(current, (Map<String, Object>)obj);
		}

		try {
			NullAwareBeanUtilsBean.singletonNoOverwrite.copyProperties(current, obj);
		} catch (IllegalAccessException | InvocationTargetException e) {
		}
		return current;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T updateObjectFromNonNullNoOverwriteIgnoreCollections(T current, Object obj) {
		if (obj==null) {
			return current;
		}
		if (obj instanceof Map && !(current instanceof Map)) {
			return fromMap(current, (Map<String, Object>)obj);
		}
		try {
			NullAwareBeanUtilsBean.singletonNoOverwriteIgnoreCollections.copyProperties(current, obj);
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
