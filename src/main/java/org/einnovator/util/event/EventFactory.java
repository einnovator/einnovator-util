/**
 * 
 */
package org.einnovator.util.event;

/**
 * @author support@einnovator.org
 *
 */
public interface EventFactory {

	Object makeEvent(String principal, Object source, Object param, String actionType, Object... targets);
}
