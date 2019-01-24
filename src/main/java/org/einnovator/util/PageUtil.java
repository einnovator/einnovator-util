package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.MappingUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class PageUtil {


	public static <U> Page<U> create(Page<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		for (Object obj: page.getContent()) {
			list.add(MappingUtils.convert(obj, type));
		}
		return new PageImpl<U>(list, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
	}

	public static <U> Page<U> create2(PageResult<?> page, Class<U> type) {
		List<U> list = new ArrayList<>();
		for (Object obj: page.getContent()) {
			list.add(MappingUtils.convert(obj, type));
		}
		return new PageImpl<U>(list, new PageRequest(page.getNumber(), page.getSize()), page.getTotalElements());
	}

	public static String toString(Page<?> page) {
		if (page==null) {
			return null;
		}
		return String.format("%s %s/%s %s/%s", page.getNumberOfElements(),  page.getContent()!=null ? page.getContent().size() : null, page.getTotalElements(), page.getNumber(), page.getTotalPages());
	}


}
