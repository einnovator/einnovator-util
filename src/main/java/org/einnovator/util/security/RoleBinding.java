/**
 * 
 */
package org.einnovator.util.security;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleBinding extends ObjectBase {

	protected String username;

	protected String groupId;

	protected String roleId;

	protected String roleName;

	protected Object user;

	protected Object group;

	protected Object role;
	

	/**
	 * Create instance of {@code RoleBinding}.
	 *
	 */
	public RoleBinding() {
	}

	/**
	 * Create instance of {@code RoleBinding}.
	 *
	 * @param obj a prototype
	 */
	public RoleBinding(Object obj) {
		super(obj);
	}

	/**
	 * Get the value of property {@code user}.
	 *
	 * @return the user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the value of property {@code user}.
	 *
	 * @param user the user
	 */
	public void setUsername(String user) {
		this.username = user;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 */
	public void setGroupId(String group) {
		this.groupId = group;
	}

	/**
	 * Get the value of property {@code user}.
	 *
	 * @return the user
	 */
	public Object getUser() {
		return user;
	}

	/**
	 * Set the value of property {@code user}.
	 *
	 * @param user the user
	 */
	public void setUser(Object user) {
		this.user = user;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public Object getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 */
	public void setGroup(Object group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code roleId}.
	 *
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Set the value of property {@code roleId}.
	 *
	 * @param roleId the value of property roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get the value of property {@code roleName}.
	 *
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * Set the value of property {@code roleName}.
	 *
	 * @param roleName the value of property roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * Get the value of property {@code role}.
	 *
	 * @return the role
	 */
	public Object getRole() {
		return role;
	}

	/**
	 * Set the value of property {@code role}.
	 *
	 * @param role the value of property role
	 */
	public void setRole(Object role) {
		this.role = role;
	}

	// With
	
	
	/**
	 * Set the value of property {@code username}.
	 *
	 * @param username the username
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withUsername(String username) {
		this.username = username;
		return this;
	}
	
	/**
	 * Set the value of property {@code user}.
	 *
	 * @param user the user
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withUser(Object user) {
		this.user = user;
		return this;
	}
	/**
	 * Set the value of property {@code groupId}.
	 *
	 * @param groupId the group id
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withGroup(Object group) {
		this.group = group;
		return this;
	}

	/**
	 * Set the value of property {@code roleId}.
	 *
	 * @param roleId the value of property roleId
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withRoleId(String roleId) {
		this.roleId = roleId;
		return this;
	}

	/**
	 * Set the value of property {@code roleName}.
	 *
	 * @param roleName the value of property roleName
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withRoleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	/**
	 * Set the value of property {@code role}.
	 *
	 * @param role the value of property role
	 * @return this {@code RoleBinding}
	 */
	public RoleBinding withRole(Object role) {
		this.role = role;
		return this;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("username", username)
			.append("groupId", groupId)
			.append("roleId", roleId)
			.append("roleName", roleName)
			;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RoleBinding other = (RoleBinding) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}