/**
 * 
 */
package org.einnovator.util;

/**
 * A ClassCastException.
 *
 * @author  {@code support@einnovator.org}
 */
public class ClassCastException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of ClassCastException.
	 *
	 */
	public ClassCastException() {
		super();
	}

	/**
	 * Create instance of ClassCastException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public ClassCastException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of ClassCastException.
	 *
	 * @param message a message
	 */
	public ClassCastException(String message) {
		super(message);
	}

	/**
	 * Create instance of ClassCastException.
	 *
	 * @param cause the cause
	 */
	public ClassCastException(Throwable cause) {
		super(cause);
	}

	
}
