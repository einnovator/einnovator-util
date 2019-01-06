package org.einnovator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class PathUtil {

	public static final String DELIMITER = "/";

	public static String concat(String folder, String filename) {
		return concat(folder, filename, DELIMITER);
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
		String sep = folder.endsWith(delimeter) ||  filename.startsWith(delimeter) ? "" : delimeter;
		return folder + sep + filename;
	}



	public static List<Map<String, String>> crumbs(String path, String delimiter) {
		List<Map<String, String>> crumbs = new ArrayList<>();
		String[] a = path.split("/");
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
		return getFolder(path, DELIMITER);
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
		return getFolderParent(path, DELIMITER);
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
		return isFolder(path, DELIMITER);
	}

	public static boolean isFolder(String path, String delimiter) {
		if (path!=null && path.endsWith(delimiter)) {
			return true;
		}
		return false;
	}

}
