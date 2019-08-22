package org.einnovator.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class PathUtil {

	public static final String SEPARATOR = "/";
	public static final String DELIMITER = SEPARATOR;

	public static String concat(String folder, String filename) {
		return concat(folder, filename, SEPARATOR);
	}

	public static String concat(String folder, String filename, String delimeter) {
		if (!StringUtils.hasText(folder)) {
			return filename;
		}
		if (!StringUtils.hasText(filename)) {
			return folder;
		}
		if (folder.endsWith(delimeter) && filename.startsWith(delimeter)) {
			return filename.length()>1 ? folder + filename.substring(1) : folder;
		}
		String sep = folder.endsWith(delimeter) ||	filename.startsWith(delimeter) ? "" : delimeter;
		return folder + sep + filename;
	}

	public static String concatAll(String... names) {
		StringBuilder sb = new StringBuilder();
		boolean endsWithDeliter = false;
		for (String name: names) {
			if (StringUtils.hasText(name)) {
				if (sb.length()> 0 && !endsWithDeliter && !name.startsWith(SEPARATOR)) {
					sb.append(SEPARATOR);
				}
				if (endsWithDeliter && name.startsWith(SEPARATOR)) {
					name = name.length()>1 ? name.substring(1) : name;
					if (!StringUtils.hasText(name)) {
						continue;
					}
				}
				sb.append(name);
				endsWithDeliter = name.endsWith(SEPARATOR);
			}			
		}
		return sb.toString();
	}

	public static List<Map<String, String>> crumbs(String path, String delimiter) {
		List<Map<String, String>> crumbs = new ArrayList<>();
		String[] a = path.split(SEPARATOR);
		StringBuilder sb = new StringBuilder();
		for (String s : a) {
			sb.append(s);
			sb.append(delimiter);
			Map<String, String> map = new HashMap<>();
			map.put("path", sb.toString());
			map.put("name", s);
			crumbs.add(map);
		}
		return crumbs;
	}

	
	public static String getFolder(String path) {
		return getFolder(path, SEPARATOR);
	}
		
	public static String getFolder(String path, String delimiter) {
		if (isFolder(path, delimiter)) {
			return path;
		}
		int i = path.lastIndexOf(delimiter);
		if (i > 0 && i<path.length()-1) {
			path = path.substring(0, i + 1);
		}
		return path;
	}

	public static String getFolderParent(String path) {
		return getFolderParent(path, SEPARATOR);
	}

	public static String getFolderParent(String path, String delimiter) {
		if (path.endsWith(delimiter)) {
			int i = path.lastIndexOf(delimiter);
			if (i > 0) {
				path = path.substring(0, i);
			}
		}
		int i = path.lastIndexOf(delimiter);
		if (i > 0) {
			path = path.substring(0, i + 1);
		}
		return path;
	}

	public static boolean isFolder(String path) {
		return isFolder(path, SEPARATOR);
	}

	public static boolean isFolder(String path, String delimiter) {
		if (path!=null && path.endsWith(delimiter)) {
			return true;
		}
		return false;
	}

	public static boolean isRoot(String path) {
		return path==null || path.isEmpty() || SEPARATOR.equals(path) || !StringUtils.hasText(path);
	}
	
	public static String absolute(File relativeTo, String filename) {
		if (filename == null) {
			return null;
		}
		File file = new File(filename);
		if (file.isAbsolute()) {
			return file.getAbsolutePath();
		}
		return new File(relativeTo.getParentFile(), filename).getAbsolutePath();
	}

	public static String getFilename(String path) {
		if (path==null) {
			return null;
		}
		int i = path.lastIndexOf(SEPARATOR);
		if (i>=0 && i<path.length()-1) {
			return path.substring(i+1);
		}
		return path;
	}
}
