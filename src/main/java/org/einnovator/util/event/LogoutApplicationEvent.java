package org.einnovator.util.event;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class LogoutApplicationEvent extends ApplicationEvent  {

	private final String username;

	/**
	 * Create a new LogoutApplicationEvent.
	 * 
	 * @param source the object on which the event initially occurred (never {@code null})
	 * @param username the username object (never {@code null})
	 */
	public LogoutApplicationEvent(Object source, String username) {
		super(source);
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

}
