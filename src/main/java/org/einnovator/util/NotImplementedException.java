/**
 * 
 */
package org.einnovator.util;

/**
 * A {@code NotImplementedException}.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code NotImplementedException}.
	 *
	 */
	public NotImplementedException() {
		super();
	}


	/**
	 * Create instance of {@code NotImplementedException}.
	 *
	 * @param message
	 * @param cause
	 */
	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * Create instance of {@code NotImplementedException}.
	 *
	 * @param message
	 */
	public NotImplementedException(String message) {
		super(message);
	}


	/**
	 * Create instance of {@code NotImplementedException}.
	 *
	 * @param cause
	 */
	public NotImplementedException(Throwable cause) {
		super(cause);
	}

	
}
