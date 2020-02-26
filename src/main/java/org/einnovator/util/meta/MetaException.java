/**
 * 
 */
package org.einnovator.util.meta;

/**
 * A MetaException.
 *
 * @author  {@code support@einnovator.org}
 */
public class MetaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of MetaException.
	 *
	 */
	public MetaException() {
		super();
	}

	/**
	 * Create instance of MetaException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public MetaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of MetaException.
	 *
	 * @param message a message
	 */
	public MetaException(String message) {
		super(message);
	}

	/**
	 * Create instance of MetaException.
	 *
	 * @param cause the cause
	 */
	public MetaException(Throwable cause) {
		super(cause);
	}

	
}
