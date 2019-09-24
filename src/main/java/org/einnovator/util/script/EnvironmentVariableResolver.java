/**
 * 
 */
package org.einnovator.util.script;

import org.springframework.core.env.Environment;

/**
 *
 */
public class EnvironmentVariableResolver implements ExpressionResolver {

	private Environment env;
	
	/**
	 * Create instance of {@code EnvironmentVariableResolver}.
	 *
	 */
	public EnvironmentVariableResolver(Environment env) {
		this.env = env;
	}
	
	@Override
	public Object eval(String expression, Object context) {
		return env.getProperty(expression);
	}

}
