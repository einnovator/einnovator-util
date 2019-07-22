package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.einnovator.util.SecurityUtil;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authority extends EntityBase {

	public static final Authority PUBLIC = new Authority(true);

	protected String user;

	protected String group;

	protected String role;

	protected String connection;

	protected Boolean other;

	protected Boolean read;

	protected Boolean write;

	protected Boolean manage;
	
	protected List<String> permissions;

	protected Object userData;

	protected Object groupData;

	protected Object roleData;

	protected Map<String, Object> permissionData;


	public Authority(Boolean other) {
		this.other = other;
	}

	public Authority() {
	}

	public Authority(Object obj) {
		super(obj);
	}

	/**
	 * Get the value of property {@code user}.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Set the value of property {@code user}.
	 *
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Get the value of property {@code group}.
	 *
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * Set the value of property {@code group}.
	 *
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * Get the value of property {@code other}.
	 *
	 * @return the other
	 */
	public Boolean getOther() {
		return other;
	}

	/**
	 * Set the value of property {@code other}.
	 *
	 * @param other the other to set
	 */
	public void setOther(Boolean other) {
		this.other = other;
	}

	/**
	 * Get the value of property {@code read}.
	 *
	 * @return the read
	 */
	public Boolean getRead() {
		return read;
	}

	/**
	 * Set the value of property {@code read}.
	 *
	 * @param read the read to set
	 */
	public void setRead(Boolean read) {
		this.read = read;
	}

	/**
	 * Get the value of property {@code write}.
	 *
	 * @return the write
	 */
	public Boolean getWrite() {
		return write;
	}

	/**
	 * Set the value of property {@code write}.
	 *
	 * @param write the write to set
	 */
	public void setWrite(Boolean write) {
		this.write = write;
	}

	/**
	 * Get the value of property {@code manage}.
	 *
	 * @return the manage
	 */
	public Boolean getManage() {
		return manage;
	}

	/**
	 * Set the value of property {@code manage}.
	 *
	 * @param manage the manage to set
	 */
	public void setManage(Boolean manage) {
		this.manage = manage;
	}

	/**
	 * Get the value of property {@code role}.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Set the value of property {@code role}.
	 *
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	

	/**
	 * Get the value of property {@code connection}.
	 *
	 * @return the connection
	 */
	public String getConnection() {
		return connection;
	}

	/**
	 * Set the value of property {@code connection}.
	 *
	 * @param connection the connection to set
	 */
	public void setConnection(String connection) {
		this.connection = connection;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("user", user)
			.append("group", group)
			.append("other", other)
			.append("role", role)			
			.append("connection", connection)
			.append("read", read)
			.append("write", write)
			.append("manage", manage)
			.append("permissions", permissions)
			;
	}

	/**
	 * Get the value of property {@code permissions}.
	 *
	 * @return the permissions
	 */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * Set the value of property {@code permissions}.
	 *
	 * @param permissions the permissions to set
	 */
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}

	/**
	 * Get the value of property {@code userData}.
	 *
	 * @return the userData
	 */
	public Object getUserData() {
		return userData;
	}

	/**
	 * Set the value of property {@code userData}.
	 *
	 * @param userData the userData to set
	 */
	public void setUserData(Object userData) {
		this.userData = userData;
	}

	/**
	 * Get the value of property {@code groupData}.
	 *
	 * @return the groupData
	 */
	public Object getStringData() {
		return groupData;
	}

	/**
	 * Set the value of property {@code groupData}.
	 *
	 * @param groupData the groupData to set
	 */
	public void setStringData(Object groupData) {
		this.groupData = groupData;
	}

	/**
	 * Get the value of property {@code roleData}.
	 *
	 * @return the roleData
	 */
	public Object getRoleData() {
		return roleData;
	}

	/**
	 * Set the value of property {@code roleData}.
	 *
	 * @param roleData the roleData to set
	 */
	public void setRoleData(Object roleData) {
		this.roleData = roleData;
	}

	/**
	 * Get the value of property {@code permissionData}.
	 *
	 * @return the permissionData
	 */
	public Map<String, Object> getPermissionData() {
		return permissionData;
	}

	/**
	 * Set the value of property {@code permissionData}.
	 *
	 * @param permissionData the permissionData to set
	 */
	public void setPermissionData(Map<String, Object> permissionData) {
		this.permissionData = permissionData;
	}
	
	

	/**
	 * Get the value of property {@code groupData}.
	 *
	 * @return the groupData
	 */
	public Object getGroupData() {
		return groupData;
	}

	/**
	 * Set the value of property {@code groupData}.
	 *
	 * @param groupData the groupData to set
	 */
	public void setGroupData(Object groupData) {
		this.groupData = groupData;
	}

	@JsonIgnore
	public boolean canOther() {
		return Boolean.TRUE.equals(other);
	}

	@JsonIgnore
	public boolean canUser(String user) {
		return this.user!=null && this.user.equals(user);
	}

	@JsonIgnore
	public boolean canGroup(String group) {
		return this.group!=null && this.group.equals(group);
	}

	@JsonIgnore
	public boolean canRole(String role) {
		return this.role!=null && this.role.equals(role);
	}

	@JsonIgnore
	public boolean canGlobalRole(String role) {
		return group==null && canRole(role);
	}

	@JsonIgnore
	public boolean canConnection(String connection) {
		return this.connection!=null && this.connection.equals(connection);
	}

	@JsonIgnore
	public boolean canRead() {
		return Boolean.TRUE.equals(read);
	}

	@JsonIgnore
	public boolean canWrite() {
		return Boolean.TRUE.equals(write);
	}

	@JsonIgnore
	public boolean canManage() {
		return Boolean.TRUE.equals(manage);
	}

	@JsonIgnore
	public boolean hasPermission(String permission) {
		return this.permissions!=null && this.permissions.contains(permission);
	}

	public boolean anyRWM() {
		return canRead() || canWrite() || canManage();
	}

	public boolean anyPermission() {
		return anyRWM() || (this.permissions!=null && !this.permissions.isEmpty());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((manage == null) ? 0 : manage.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((connection == null) ? 0 : connection.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((write == null) ? 0 : write.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Authority other = (Authority) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (manage == null) {
			if (other.manage != null)
				return false;
		} else if (!manage.equals(other.manage))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (connection == null) {
			if (other.connection != null)
				return false;
		} else if (!connection.equals(other.connection))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (write == null) {
			if (other.write != null)
				return false;
		} else if (!write.equals(other.write))
			return false;
		return true;
	}

	public static Authority user(String user, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().user(user).read(read).write(write).manage(manage).build();
	}

	public static Authority other(Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().other().read(read).write(write).manage(manage).build();
	}

	public static Authority group(String group, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().group(group).read(read).write(write).manage(manage).build();
	}

	public static Authority group(String group, String role, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().group(group).role(role).read(read).write(write).manage(manage).build();
	}
	
	public static Authority role(String role, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().role(role).read(read).write(write).manage(manage).build();
	}

	public static Authority connection(String connection, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().connection(connection).read(read).write(write).manage(manage).build();
	}

	public static AuthorityBuilder builder() {
		return new AuthorityBuilder();
	}


	public static boolean isPublic(List<Authority> permissions) {
		if (permissions!=null) {
			for (Authority permission : permissions) {
				if (Boolean.TRUE.equals(permission.getOther())) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isAllowed(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (user==null) {
			user = SecurityUtil.getPrincipalName();
		}
		if (authorities==null && user==null) {
			authorities = SecurityUtil.getAuthorities();
		}
		if (this.user!=null && this.user.equals(user)) {
			return true;
		}
		if (group!=null && groups!=null) {
			if (groups.contains(group)) {
				if (this.role!=null) {
					if (authorities!=null) {
						for (GrantedAuthority authority: authorities) {
							if (role.equals(authority.toString())) {
								return true;
							}
						}						
					}
				}
				return true;
			}
		} else {
			if (authorities!=null && role!=null) {
				for (GrantedAuthority authority: authorities) {
					if (role.equals(authority.toString())) {
						return true;
					}
				}
			}
		}
		return false;		
	}


	public boolean isAllowedRead(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (Boolean.TRUE.equals(other)) {
			return true;
		}
		if (!Boolean.TRUE.equals(read)) {
			return false;
		}
		return isAllowed(user, groups, authorities);
	}

	public boolean isAllowedWrite(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (!Boolean.TRUE.equals(write)) {
			return false;
		}
		return isAllowed(user, groups, authorities);		
	}

	public boolean isAllowedManage(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (!Boolean.TRUE.equals(manage)) {
			return false;
		}
		return isAllowed(user, groups, authorities);
	}

	
	public static boolean isAllowedRead(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.isAllowedRead(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isAllowedWrite(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.isAllowedWrite(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean isAllowedManage(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.isAllowedManage(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}	

	
	public static boolean isAllowedByMembership(String group, List<String> groups, List<Authority> authorities) {
		return group!=null && groups!=null && groups.contains(group) && !refersGroup(group, authorities);
	}



	/**
	 * @param group2
	 * @param authorities
	 * @return
	 */
	public static List<Authority> filterByString(String group, List<Authority> authorities) {
		if (authorities==null) {
			return null;
		}
		List<Authority> authorities2 = new ArrayList<>();
		for (Authority authority: authorities) {
			if (group.equals(authority.group)) {
				authorities2.add(authority);
			}
		}
		return authorities2;
	}

	public static boolean refersGroup(String group, List<Authority> authorities) {
		if (authorities==null) {
			return false;
		}
		for (Authority authority: authorities) {
			if (group.equals(authority.group)) {
				return true;
			}
		}
		return false;
	}

}
