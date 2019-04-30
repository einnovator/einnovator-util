/**
 * 
 */
package org.einnovator.util.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code BeanFactoryPostProcessor} that register the {@code XSessionScope} in Spring {@code ApplicationContext}.
 *
 */
@Configuration
public class XSessionScopeConfig {

	@Bean
	public XSessionScopeRegistrar xSessionScopeRegistrar() {
		return new XSessionScopeRegistrar();
	}
}
