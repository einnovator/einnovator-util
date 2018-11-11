/**
 * 
 */
package org.einnovator.util;

/**
 * Miscellaneous boolean operations.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class BooleanUtil {


	public static Boolean not(Boolean b) {
		return b!=null ? Boolean.TRUE.equals(b) : null;
	}
}
