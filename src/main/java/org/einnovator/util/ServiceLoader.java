/**
 * 
 */
package org.einnovator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * A loader for service providers.
 *
 * @author  {@code support@einnovator.org}
 * @param <T> the type of the service
 */
public class ServiceLoader<T> {

	public Log logger = LogFactory.getLog(this.getClass());

	private volatile Map<ClassLoader, List<T>> services = new HashMap<ClassLoader, List<T>>();

	private static final String SERVICE_PROVIDER_DIR = "META-INF/services/";

	private String serviceProviderFile;

	private Class<T> type;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of ServiceLoader.
	 *
	 * @param type the type of service
	 * @param serviceProviderFile the service provider file
	 */
	public ServiceLoader(Class<T> type, String serviceProviderFile) {
		this.type = type;
		this.serviceProviderFile = serviceProviderFile;
	}

	/**
	 * Create instance of ServiceLoader.
	 *
	 * @param type the type of service
	 */
	public ServiceLoader(Class<T> type) {
		this(type, SERVICE_PROVIDER_DIR + type.getName());
	}

	//
	// Service methods
	//
	
	/**
	 * Get all service providers.
	 * 
	 * @return the list of service providers; or {@code null}, if service files could not be read. 
	 */
	public List<T> getServices() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		List<T> loadedServices = this.services.get(loader);
		if (loadedServices == null) {
			Collection<ServiceName> serviceNames = null;
			try {
				serviceNames = getServiceNames(loader);
			} catch (IOException e1) {
				logger.warn("getServices:" + "Unable to read service files for:" + type.getName());
				return null;
			}
			loadedServices = new ArrayList<T>();
	
			for (ServiceName serviceName : serviceNames) {
				try {
					Class<?> type2 = loader.loadClass(serviceName.getName());
					if (!type.isAssignableFrom(type2)) {
						throw new ClassCastException();
					}
					@SuppressWarnings("unchecked")
					T service = (T) type2.newInstance();
					logger.debug("getServices: " + "found:" + service.getClass().getName() + " for type:" + type.getName());
					loadedServices.add(service);
				} catch (java.lang.ClassNotFoundException e) {
					log(e, serviceName);
				} catch (InstantiationException e) {
					log(e, serviceName);
				} catch (IllegalAccessException e) {
					log(e, serviceName);
				} catch (java.lang.ClassCastException e) {
					log(e, serviceName);
				}
			}
	
			// If none are found we'll log the service names for diagnostic
			// purposes.
			if (loadedServices.isEmpty() && !serviceNames.isEmpty()) {
				logger.warn("getServices:" + "No valid services found of type:" + type.getName());
			}	
			this.services.put(loader, loadedServices);
		}
	
		return loadedServices;
	}

	private void log(Exception e, ServiceName serviceName) {
		logger.debug("getServices: " + e + ": " + serviceName);
	}
	/**
	 * Locate all matching services files and collect all of the
	 * service names available.
	 * @throws IOException 
	 */
	private Collection<ServiceName> getServiceNames(ClassLoader loader) throws IOException {

		Enumeration<URL> resources = loader.getResources(serviceProviderFile);

		Collection<ServiceName> serviceNames = new TreeSet<ServiceName>();

		while (resources.hasMoreElements()) {
			URL url = resources.nextElement();
			addServiceNames(url, serviceNames);
		}

		return serviceNames;
	}

	private static final Pattern nonCommentPattern = Pattern.compile("^([^#]+)");

	/**
	 * For each services file look for uncommented service names on each
	 * line.
	 */
	private void addServiceNames(URL url, Collection<ServiceName> serviceNames) {
		InputStream in = null;
		try {
			in = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				Matcher m = nonCommentPattern.matcher(line);
				if (m.find()) {
					serviceNames.add(new ServiceName(m.group().trim(), url));
				}
			}
		} catch (IOException e) {
			logger.warn("addServiceNames: " + e + " " + url);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

	/**
	 * Clear all cached services
	 */
	public void clearCachedServices() {
		this.services.clear();
	}

	/**
	 * A ServiceName captures each service name found in a service file as
	 * well as the URL for the service file it was found in. This
	 * information is only used for diagnostic purposes.
	 */
	private static class ServiceName implements Comparable<ServiceName> {

		/**
		 * Service name
		 **/
		private String name;

		/**
		 * URL for the service file where the service name was found
		 **/
		private URL source;

		//
		// Constructors
		//
		
		/**
		 * Create instance of {@code ServiceName}.
		 *
		 * @param name
		 * @param sourceURL
		 */
		public ServiceName(String name, URL sourceURL) {
			this.name = name;
			this.source = sourceURL;
		}

		//
		// Getters an Setters
		//
		
		public String getName() {
			return name;
		}

		public URL getSource() {
			return source;
		}
		
		//
		// Object Overrides
		//
		
		/**
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (obj==null || !(obj instanceof ServiceName)) {
				return false;
			}
			return this.name.equals(((ServiceName)obj));
		}

		/**
		 * @see java.lang.Object#toString()
		 */
		public String toString() {
			return getName() + " - " + getSource();
		}

		//
		// Comparable Implementation
		//
		
		@Override
		public int compareTo(ServiceName serviceName) {
			return this.name.compareTo(serviceName.name);
		}
	}
	
	private static Map<Class<?>, ServiceLoader<?>> instances;
	
	@SuppressWarnings("unchecked")
	public static synchronized <T> ServiceLoader<T> getServiceLoader(Class<T> type) {
		ServiceLoader<T> loader = null;
		if (instances==null) {
			instances = new HashMap<Class<?>, ServiceLoader<?>>();			
		} else {
			loader = (ServiceLoader<T>) instances.get(type);
		}
		if (loader==null) {
			loader = new ServiceLoader<T>(type);
			instances.put(type, loader);
		}
		return loader;
	}
}
