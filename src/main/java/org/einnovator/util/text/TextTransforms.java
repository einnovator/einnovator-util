/**
 * 
 */
package org.einnovator.util.text;

import org.einnovator.util.text.CamelCaseToUnderscoreTextTransform;
import org.einnovator.util.text.CamelCaseToWordsTextTransform;
import org.einnovator.util.text.CapsTextTransform;
import org.einnovator.util.text.WordsToCamelCaseTextTransform;
import org.einnovator.util.text.XmlAttributeToCamelCaseTextTransform;


/**
 * A CommonTextTransform.
 *
 * @author Jorge Simao, {@code jorge.simao@einnovator.org}
 */
public class TextTransforms {
	
	public enum Transform {
		IDENTITY,
		CAMEL_CASE_TO_WORD,
		CAMEL_CASE_TO_UNDERSCORE,
		CAPITALIZE,
		UNCAPITALIZE,
		WORDS_TO_CAMEL_CASE,
		XML_ATTRIBUTE_TO_CAMEL_CASE;		
	}
	
	/**
	 * Get a transform from a name
	 * 
	 * @param name the name of the transform
	 * @return the transform
	 */
	public static TextTransform getTransform(Transform name) {
		switch (name) {
			case IDENTITY: return IdentityTextTransform.getInstance();
			case CAMEL_CASE_TO_WORD: return CamelCaseToWordsTextTransform.getInstance();
			case CAMEL_CASE_TO_UNDERSCORE: return CamelCaseToUnderscoreTextTransform.getInstance();
			case CAPITALIZE: return CapsTextTransform.getCapitalizeInstance();
			case UNCAPITALIZE: return CapsTextTransform.getUncapitalizeInstance();
			case WORDS_TO_CAMEL_CASE: return WordsToCamelCaseTextTransform.getInstance();
			case XML_ATTRIBUTE_TO_CAMEL_CASE: return XmlAttributeToCamelCaseTextTransform.getInstance();
			default: return null;
		}
	}
}
