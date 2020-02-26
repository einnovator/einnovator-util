/**
 * 
 */
package org.einnovator.util.meta;

/**
 * A NoSuchMethodException.
 *
 * @author  {@code support@einnovator.org}
 */
public class NoSuchMethodException extends MetaException {
	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of NoSuchMethodException.
	 *
	 */
	public NoSuchMethodException() {
		super();
	}

	/**
	 * Create instance of NoSuchMethodException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public NoSuchMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of NoSuchMethodException.
	 *
	 * @param message a message
	 */
	public NoSuchMethodException(String message) {
		super(message);
	}

	/**
	 * Create instance of NoSuchMethodException.
	 *
	 * @param cause the cause
	 */
	public NoSuchMethodException(Throwable cause) {
		super(cause);
	}
	

}
