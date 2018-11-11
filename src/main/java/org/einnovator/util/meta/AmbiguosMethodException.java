/**
 * 
 */
package org.einnovator.util.meta;

/**
 * A AmbiguosMethod.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class AmbiguosMethodException extends MetaException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create instance of AmbiguosMethod.
	 *
	 */
	public AmbiguosMethodException() {
		super();
	}

	/**
	 * Create instance of AmbiguosMethod.
	 *
	 * @param message
	 * @param cause
	 */
	public AmbiguosMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Create instance of AmbiguosMethod.
	 *
	 * @param message
	 */
	public AmbiguosMethodException(String message) {
		super(message);
	}

	/**
	 * Create instance of AmbiguosMethod.
	 *
	 * @param cause
	 */
	public AmbiguosMethodException(Throwable cause) {
		super(cause);
	}

	
}
