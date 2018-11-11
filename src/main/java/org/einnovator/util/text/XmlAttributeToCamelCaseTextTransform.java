/**
 * 
 */
package org.einnovator.util.text;

/**
 * A WordsToCamelCaseTextTransform.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class XmlAttributeToCamelCaseTextTransform extends WordsToCamelCaseTextTransform {

	
	//
	// Constructors
	//
	
	/**
	 * Create instance of WordsToCamelCaseTextTransform.
	 *
	 */
	public XmlAttributeToCamelCaseTextTransform() {
		super("-");
	}
	
	//
	// TextTransform implementation
	//
	
	//
	// Static utility
	//

	private static XmlAttributeToCamelCaseTextTransform instance;
	

	public static XmlAttributeToCamelCaseTextTransform getInstance() {
		if (instance==null) {
			instance = new XmlAttributeToCamelCaseTextTransform();
		}
		return instance;
	}

}
