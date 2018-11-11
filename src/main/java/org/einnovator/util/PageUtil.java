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


}
