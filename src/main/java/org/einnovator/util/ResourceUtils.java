package org.einnovator.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

public class ResourceUtils {
	
	public static Resource makeResource(String path, boolean classpath) {
		if (path.startsWith("classpath:")) {
			return new ClassPathResource(path.substring("classpath:".length()));
		}
		if (path.startsWith("file:")) {
			return new FileSystemResource(path.substring("file:".length()));
		}
		if (path.startsWith("http:")) {
			try {
				return new UrlResource(path);
			} catch (MalformedURLException e) {
				return null;
			}
		}
		return classpath ? new ClassPathResource(path) : new FileSystemResource(path);
	}
	
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
