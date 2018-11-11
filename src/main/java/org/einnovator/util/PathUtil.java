package org.einnovator.util;

public class PathUtil {


	public static String pconcat(String folder, String filename) {
		String sep = folder.endsWith("/") ||  filename.startsWith("/") ? "" : "/";
		return folder + sep + filename;
	}

}
