/**
 * 
 */
package org.einnovator.util;

/**
 * A FileNotFoundException.
 *
 * @author  {@code support@einnovator.org}
 */
public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of FileNotFoundException.
	 *
	 */
	public FileNotFoundException() {
		super();
	}

	/**
	 * Create instance of FileNotFoundException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public FileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of FileNotFoundException.
	 *
	 * @param message a message
	 */
	public FileNotFoundException(String message) {
		super(message);
	}

	/**
	 * Create instance of FileNotFoundException.
	 *
	 * @param cause the cause
	 */
	public FileNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
