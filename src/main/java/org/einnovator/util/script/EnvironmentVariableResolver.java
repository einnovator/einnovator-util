/**
 * 
 */
package org.einnovator.util.script;

import org.springframework.core.env.Environment;

/**
 *
 */
public class EnvironmentVariableResolver implements VariableResolver {

	private Environment env;
	
	/**
	 * Create instance of {@code EnvironmentVariableResolver}.
	 *
	 */
	public EnvironmentVariableResolver(Environment env) {
		this.env = env;
	}
	
	@Override
	public Object resolve(Object obj, String name) {
		return env.getProperty(name);
	}

}
