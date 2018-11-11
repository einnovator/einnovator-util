package org.einnovator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratorUtil {

	public static <T> List<T> asList(Iterator<T> it) {
		return collect(it, new ArrayList<T>());
	}
	
	public static <T, U extends Collection<T>> U collect(Iterator<T> it, U collection) {
		while (it.hasNext()) {
			collection.add(it.next());
		}
		return collection;
	}

	
}
