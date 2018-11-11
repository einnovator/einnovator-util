package org.einnovator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class ResourceUtils {
	public static String readResource(String filename) {
		try {
			Resource resource = new ClassPathResource(filename);
			InputStream inputStream = resource.getInputStream();
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, Charset.forName("UTF-8"));
			String s = writer.toString();
			return s;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String readUrlResource(String uri) {
		try {
			InputStream inputStream = new UrlResource(uri).getInputStream();
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, Charset.forName("UTF-8"));
			String s = writer.toString();
			return s;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
