/**
 * 
 */
package org.einnovator.util;

/**
 * A NotSupportedException.
 *
 * @author  {@code support@einnovator.org}
 */
public class NotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of NotSupportedException.
	 *
	 */
	public NotSupportedException() {
		super();
	}

	/**
	 * Create instance of NotSupportedException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public NotSupportedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of NotSupportedException.
	 *
	 * @param message a message
	 */
	public NotSupportedException(String message) {
		super(message);
	}

	/**
	 * Create instance of NotSupportedException.
	 *
	 * @param cause the cause
	 */
	public NotSupportedException(Throwable cause) {
		super(cause);
	}

	
}
