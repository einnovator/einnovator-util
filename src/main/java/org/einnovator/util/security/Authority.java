package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.einnovator.util.CollectionUtil;
import org.einnovator.util.StringUtil;
import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Authority extends EntityBase {

	public static final Authority PUBLIC = new Authority(true);

	protected OwnerType type;
	
	protected String username;

	protected String groupId;

	protected String connection;

	protected Boolean other;

	//Roles (Builtin and Custom) and  Permissions

	protected Boolean read;

	protected Boolean write;

	protected Boolean manage;

	protected List<String> roles;

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
	 * Get the value of property {@code type}.
	 *
	 * @return the type
	 */
	public OwnerType getType() {
		return type;
	}

	/**
	 * Set the value of property {@code type}.
	 *
	 * @param type the type to set
	 */
	public void setType(OwnerType type) {
		this.type = type;
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
	 * @param user the user to set
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
	 * @param group the group to set
	 */
	public void setGroupId(String group) {
		this.groupId = group;
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
	 * Get the value of property {@code roles}.
	 *
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * Set the value of property {@code roles}.
	 *
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
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


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("username", username)
			.append("groupId", groupId)
			.append("other", other)
			.append("connection", connection)
			.append("read", read)
			.append("write", write)
			.append("manage", manage)
			.append("roles", roles)	
			.append("permissions", permissions)
			;
	}
	
	@JsonIgnore
	public boolean canOther() {
		return Boolean.TRUE.equals(other);
	}

	@JsonIgnore
	public boolean canUser(String user) {
		return this.username!=null && this.username.equals(user);
	}

	@JsonIgnore
	public boolean canGroup(String group) {
		return this.groupId!=null && this.groupId.equals(group);
	}

	@JsonIgnore
	public boolean canRole(String role) {
		return StringUtil.containsIgnoreCase(this.roles, role);
	}

	@JsonIgnore
	public boolean canGlobalRole(String role) {
		return groupId==null && canRole(role);
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
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((manage == null) ? 0 : manage.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((connection == null) ? 0 : connection.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
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
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (connection == null) {
			if (other.connection != null)
				return false;
		} else if (!connection.equals(other.connection))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (write == null) {
			if (other.write != null)
				return false;
		} else if (!write.equals(other.write))
			return false;
		return true;
	}

	public static Authority user(String user, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().username(user).read(read).write(write).manage(manage).build();
	}

	public static Authority other(Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().other().read(read).write(write).manage(manage).build();
	}

	public static Authority group(String group, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().group(group).read(read).write(write).manage(manage).build();
	}

	public static Authority group(String group, String role, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().group(group).roles(role).read(read).write(write).manage(manage).build();
	}
	
	public static Authority role(String role, Boolean read, Boolean write, Boolean manage) {
		return Authority.builder().roles(role).read(read).write(write).manage(manage).build();
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
	
	public boolean can(Collection<? extends GrantedAuthority> authorities) {
		if (!CollectionUtil.isEmpty(this.roles) || !CollectionUtil.isEmpty(this.permissions)) {
			if (authorities!=null) {
				for (GrantedAuthority authority: authorities) {
					if (this.roles!=null) {
						for (String role: this.roles) {
							if (role.equalsIgnoreCase(authority.toString())) {
								return true;
							}
						}
					}
					if (this.permissions!=null) {
						for (String role: this.permissions) {
							if (role.equalsIgnoreCase(authority.toString())) {
								return true;
							}
						}
					}
				}	
			}
			return false;
		}
		return true;
	}

	public boolean can(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (user==null) {
			user = SecurityUtil.getPrincipalName();
		}
		if (authorities==null && user==null) {
			authorities = SecurityUtil.getAuthorities();
		}
		if (this.username!=null && this.username.equals(user)) {
			return true;
		}
		if (groupId!=null) {
			if (groups!=null && groups.contains(groupId)) {
				return can(authorities);
			}
		} else {
			return can(authorities);			
		}
		return false;		
	}

	public boolean canRead(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (Boolean.TRUE.equals(other)) {
			return true;
		}
		if (!Boolean.TRUE.equals(read)) {
			return false;
		}
		return can(user, groups, authorities);
	}

	public boolean canWrite(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (!Boolean.TRUE.equals(write)) {
			return false;
		}
		return can(user, groups, authorities);		
	}

	public boolean canManage(String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (!Boolean.TRUE.equals(manage)) {
			return false;
		}
		return can(user, groups, authorities);
	}

	
	public static boolean canRead(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canRead(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean canWrite(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canWrite(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean canManage(List<Authority> authorities0, String user, List<String> groups, Collection<? extends GrantedAuthority> authorities) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canManage(user, groups, authorities)) {
					return true;
				}
			}
		}
		return false;
	}	

	
	public static boolean canByMembership(String group, List<String> groups, List<Authority> authorities) {
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
			if (group.equals(authority.groupId)) {
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
			if (group.equals(authority.groupId)) {
				return true;
			}
		}
		return false;
	}

}
