package org.einnovator.util;

import java.io.ByteArrayOutputStream;
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
		if (path.indexOf("://")>0) {
			try {
				return new UrlResource(path);
			} catch (MalformedURLException e) {
				return null;
			}
		}
		return classpath ? new ClassPathResource(path) : new FileSystemResource(path);
	}
	
	public static String readResource(String path) {
		return readResource(path, true);
	}

	public static byte[] readResourceBytes(String path) {
		return readResourceBytes(path, true);
	}

	public static String readResource(String path, boolean classpath) {
		Resource resource =  makeResource(path, classpath);
		if (resource==null) {
			return null;
		}
		return readResource(resource);
	}
	
	public static byte[] readResourceBytes(String path, boolean classpath) {
		Resource resource =  makeResource(path, classpath);
		if (resource==null) {
			return null;
		}
		return readResourceBytes(resource);
	}

	
	public static String readResource(Resource resource) {
		try {
			return readResource(resource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] readResourceBytes(Resource resource) {
		try {
			return readResourceBytes(resource.getInputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String readOptionalResource(Resource resource) {
		try {
			return readResource(resource.getInputStream());
		} catch (IOException e) {
			return null;
		}
	}
	
	public static String readResource(InputStream inputStream) {
		try {
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, Charset.forName("UTF-8"));
			String s = writer.toString();
			return s;
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} 
		}
	}
	
	public static byte[] readResourceBytes(InputStream inputStream) {
		try {
			return IOUtils.toByteArray(inputStream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			} 
		}
	}
	
	public static String readUrlResource(String uri) {
		try (InputStream inputStream = new UrlResource(uri).getInputStream()) {
			StringWriter writer = new StringWriter();
			IOUtils.copy(inputStream, writer, Charset.forName("UTF-8"));
			String s = writer.toString();
			return s;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static byte[] readUrlResourceBytes(String uri) {
		try (InputStream inputStream = new UrlResource(uri).getInputStream()) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			IOUtils.copy(inputStream, out);
			return out.toByteArray();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
