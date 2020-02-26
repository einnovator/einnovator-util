/**
 * 
 */
package org.einnovator.util;

/**
 * A ClassNotFoundException.
 *
 * @author  {@code support@einnovator.org}
 */
public class ClassNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of ClassNotFoundException.
	 *
	 */
	public ClassNotFoundException() {
		super();
	}

	/**
	 * Create instance of ClassNotFoundException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public ClassNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of ClassNotFoundException.
	 *
	 * @param message a message
	 */
	public ClassNotFoundException(String message) {
		super(message);
	}

	/**
	 * Create instance of ClassNotFoundException.
	 *
	 * @param cause the cause
	 */
	public ClassNotFoundException(Throwable cause) {
		super(cause);
	}
	
	
}
