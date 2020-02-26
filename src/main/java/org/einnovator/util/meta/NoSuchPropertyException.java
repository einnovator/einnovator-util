/**
 * 
 */
package org.einnovator.util.meta;


/**
 * A NoSuchPropertyException.
 *
 * @author  {@code support@einnovator.org}
 */
public class NoSuchPropertyException extends MetaException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of NoSuchPropertyException.
	 *
	 */
	public NoSuchPropertyException() {
		super();
	}

	/**
	 * Create instance of NoSuchPropertyException.
	 *
	 * @param message a message
	 * @param cause the cause
	 */
	public NoSuchPropertyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of NoSuchPropertyException.
	 *
	 * @param message a message
	 */
	public NoSuchPropertyException(String message) {
		super(message);
	}

	/**
	 * Create instance of NoSuchPropertyException.
	 *
	 * @param cause the cause
	 */
	public NoSuchPropertyException(Throwable cause) {
		super(cause);
	}

	
}
