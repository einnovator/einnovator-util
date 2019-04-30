/**
 * 
 */
package org.einnovator.util.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * {@code BeanFactoryPostProcessor} that register the {@code XSessionScope} in Spring {@code ApplicationContext}.
 *
 */
public class XSessionScopeRegistrar implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		beanFactory.registerScope("xsession", new XSessionScope());
	}

}
