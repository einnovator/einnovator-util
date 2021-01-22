/**
 * 
 */
package org.einnovator.util.resource;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.FileUtil;
import org.einnovator.util.MappingUtils;
import org.einnovator.util.ResourceUtils;
import org.springframework.boot.web.server.MimeMappings;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

/**
 *
 */
public class DefaultDatasetLoader implements DatasetLoader {

	final public static MimeMappings mimeMappings = new MimeMappings();		


	@SuppressWarnings("unchecked")
	public <T> T[] read(Class<T> type, String... resources) {
		List<T> list = new ArrayList<>();
		Class<?> arrayType = Array.newInstance(type, 0).getClass();

		for (String resource: resources) {
			Object[] objs = (Object[])read(arrayType, resource);
			if (objs!=null) {
				for (Object obj: objs) {
					list.add((T)obj);
				}
			}
		}
		Object a = Array.newInstance(type, list.size());
		System.arraycopy(list.toArray(), 0, a, 0, list.size());
		return (T[])a;
	}

	protected <T> T read(Class<T> type, String resource) {
		Resource resource2 = ResourceUtils.makeResource(resource, true);
		String s = ResourceUtils.readOptionalResource(resource2);
		if (s==null) {
			return null;
		}
		String mime = getMimeType(resource);
		switch (mime) {
		case MediaType.APPLICATION_JSON_VALUE:
			return MappingUtils.fromJson(s, type);
		default:
			return null;
		}
	}
	
	
	public String getMimeType(String resource) {
		String ext = FileUtil.getExtention(resource);
		String mime = mimeMappings.get(ext);
		return mime;
	}
}
