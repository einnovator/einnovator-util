package org.einnovator.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class PageUtil {


	public static <U> Page<U> create(Page<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		if (page.getContent()!=null) {
			for (Object obj: page.getContent()) {
				list.add(MappingUtils.convert(obj, type));
			}
		}
		return new PageImpl<U>(list, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
	}

	public static <U> Page<U> create2(PageResult<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		if (page.getContent()!=null) {
			for (Object obj: page.getContent()) {
				list.add(MappingUtils.convert(obj, type));
			}			
		}
		return new PageImpl<U>(list, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
	}

	public static String toString(Page<?> page) {
		if (page==null) {
			return null;
		}
		return String.format("%s %s/%s %s/%s", page.getNumberOfElements(),  page.getContent()!=null ? page.getContent().size() : null, page.getTotalElements(), page.getNumber(), page.getTotalPages());
	}

	public static Map<String, Object> toMap(Page<?> page, boolean content) {
		if (page==null) {
			return null;
		}
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("number", page.getNumber());
		map.put("size", page.getSize());
		map.put("totalElements", page.getTotalElements());
		map.put("totalPages", page.getTotalPages());
		if (page.getSort()!=null) {
			map.put("sort", page.getSort().toString());			
		}
		if (content) {
			map.put("sort", page.getContent());			
		}
		return map;
	}
	
	public static String toJson(Page<?> pager, boolean content) {
		return MappingUtils.toJson(toMap(pager, content));
	}

}
