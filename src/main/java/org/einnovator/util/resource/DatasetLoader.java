/**
 * 
 */
package org.einnovator.util.resource;

/**
 *
 */
public interface DatasetLoader {


	<T> T[] read(Class<T> type, String... resources);
}
