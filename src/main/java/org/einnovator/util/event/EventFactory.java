/**
 * 
 */
package org.einnovator.util.event;

/**
 * @author jsima
 *
 */
public interface EventFactory {

	Object makeEvent(String principal, Object source, String actionType, Object... targets);
}
