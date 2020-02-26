/**
 * 
 */
package org.einnovator.util;

/**
 * A InvalidPropertyPathException.
 *
 * @author  {@code support@einnovator.org}
 */
public class InvalidPropertyPathException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of InvalidPropertyPathException.
	 *
	 */
	public InvalidPropertyPathException() {
		super();
	}

	/**
	 * Create instance of InvalidPropertyPathException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public InvalidPropertyPathException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of InvalidPropertyPathException.
	 *
	 * @param message a message
	 */
	public InvalidPropertyPathException(String message) {
		super(message);
	}

	/**
	 * Create instance of InvalidPropertyPathException.
	 *
	 * @param cause the cause
	 */
	public InvalidPropertyPathException(Throwable cause) {
		super(cause);
	}

	
}
