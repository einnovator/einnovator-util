/**
 * 
 */
package org.einnovator.util.script;

public interface ExpressionResolver {

	Object eval(String expression, Object context);
}
