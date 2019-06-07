/**
 * 
 */
package org.einnovator.util.web;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.web.context.request.SessionScope;

/**
 *
 */
public class XSessionScope implements Scope {
	
	SessionScope sessionScope;
	
	SimpleThreadScope threadScope;
	
	/**
	 * Create instance of {@code XSessionScope}.
	 *
	 */
	public XSessionScope() {
		sessionScope = new SessionScope();
		threadScope = new SimpleThreadScope();
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#get(java.lang.String, org.springframework.beans.factory.ObjectFactory)
	 */
	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		try {
			return sessionScope.get(name, objectFactory);			
		} catch (RuntimeException e) {
			Object obj = threadScope.get(name, objectFactory);
			return obj;
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#remove(java.lang.String)
	 */
	@Override
	public Object remove(String name) {
		try {
			return  sessionScope.remove(name);
		} catch (RuntimeException e) {
			return threadScope.remove(name);
		}
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#registerDestructionCallback(java.lang.String, java.lang.Runnable)
	 */
	@Override
	public void registerDestructionCallback(String name, Runnable callback) {
		try {
			sessionScope.registerDestructionCallback(name, callback);
		} catch (RuntimeException e) {
			threadScope.registerDestructionCallback(name, callback);			
		}
			
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#resolveContextualObject(java.lang.String)
	 */
	@Override
	public Object resolveContextualObject(String key) {
		try {
			return sessionScope.resolveContextualObject(key);
		} catch (RuntimeException e) {
			return threadScope.resolveContextualObject(key);
		}

	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#getConversationId()
	 */
	@Override
	public String getConversationId() {
		try {
			return sessionScope.getConversationId();			
		} catch (RuntimeException e) {
			return threadScope.getConversationId();			
		}
	}

}
