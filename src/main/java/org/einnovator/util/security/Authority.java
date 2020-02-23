package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.OwnerType;
import org.einnovator.util.model.ToStringCreator;

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

	protected String connectionId;

	protected Boolean other;

	protected Object user;

	protected Object group;

	protected Object connection;
	
	//Roles

	protected Boolean read;

	protected Boolean write;

	protected Boolean manage;

	protected Boolean comment;


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
	 * @param manage the value of property manage
	 */
	public void setManage(Boolean manage) {
		this.manage = manage;
	}

	/**
	 * Get the value of property {@code connectionId}.
	 *
	 * @return the connectionId
	 */
	public String getConnectionId() {
		return connectionId;
	}

	/**
	 * Set the value of property {@code connectionId}.
	 *
	 * @param connectionId the connectionId to set
	 */
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
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
	 * @param user the user to set
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
	 * @param group the group to set
	 */
	public void setGroup(Object group) {
		this.group = group;
	}

	
	// With
	
	public Authority withUsername(String username) {
		this.username = username;
		return this;
	}
	
	public Authority withConnectionId(String connectionId) {
		this.connectionId = connectionId;
		return this;
	}


	public Authority withUser(Object user) {
		this.user = user;
		return this;
	}
	
	public Authority withGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	public Authority withOther(Boolean other) {
		this.other = other;
		return this;
	}

	public Authority withOther() {
		return withOther(true);
	}
	

	public Authority withRead(Boolean read) {
		this.read = read;
		return this;
	}


	public Authority withWrite(Boolean write) {
		this.write = write;
		return this;
	}

	public Authority withManage(Boolean manage) {
		this.manage = manage;
		return this;
	}

	public Authority withComment(Boolean comment) {
		this.comment = comment;
		return this;
	}

	public Authority withRead() {
		return withRead(true);
	}

	public Authority withWrite() {
		return withWrite(true);
	}

	public Authority withManage() {
		return withManage(true);
	}
	
	public Authority withComment() {
		return withComment(true);
	}


	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
			.append("username", username)
			.append("groupId", groupId)
			.append("connectionId", connectionId)
			.append("other", other)
			.append("read", read)
			.append("write", write)
			.append("manage", manage)
			.append("comment", comment)
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
	public boolean canConnection(String connection) {
		return this.connectionId!=null && this.connectionId.equals(connection);
	}

	@JsonIgnore
	public boolean isRead() {
		return Boolean.TRUE.equals(read);
	}

	@JsonIgnore
	public boolean isWrite() {
		return Boolean.TRUE.equals(write);
	}

	@JsonIgnore
	public boolean isManage() {
		return Boolean.TRUE.equals(manage);
	}

	@JsonIgnore
	public boolean isComment() {
		return Boolean.TRUE.equals(comment);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((connectionId == null) ? 0 : connectionId.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((read == null) ? 0 : read.hashCode());
		result = prime * result + ((write == null) ? 0 : write.hashCode());
		result = prime * result + ((manage == null) ? 0 : manage.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
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
		Authority other = (Authority) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (connectionId == null) {
			if (other.connectionId != null)
				return false;
		} else if (!connectionId.equals(other.connectionId))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (read == null) {
			if (other.read != null)
				return false;
		} else if (!read.equals(other.read))
			return false;
		if (manage == null) {
			if (other.manage != null)
				return false;
		} else if (!manage.equals(other.manage))
			return false;
		if (write == null) {
			if (other.write != null)
				return false;
		} else if (!write.equals(other.write))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		return true;
	}

	// static util builders
	
	public static Authority user(String user, Boolean read, Boolean write, Boolean manage, Boolean comment) {
		return new Authority().withUsername(user).withRead(read).withWrite(write).withManage(manage).withComment(comment);
	}

	public static Authority other(Boolean read, Boolean write, Boolean manage, Boolean comment) {
		return new Authority().withOther(true).withRead(read).withWrite(write).withManage(manage).withComment(comment);
	}

	public static Authority group(String group, Boolean read, Boolean write, Boolean manage, Boolean comment) {
		return new Authority().withGroupId(group).withRead(read).withWrite(write).withManage(manage).withComment(comment);
	}

	public static Authority connection(String connection, Boolean read, Boolean write, Boolean manage, Boolean comment) {
		return new Authority().withConnectionId(connection).withRead(read).withWrite(write).withManage(manage).withComment(comment);
	}

	public static Authority user(String user, Boolean read, Boolean write, Boolean manage) {
		return new Authority().withUsername(user).withRead(read).withWrite(write).withManage(manage);
	}

	public static Authority other(Boolean read, Boolean write, Boolean manage) {
		return new Authority().withOther(true).withRead(read).withWrite(write).withManage(manage);
	}

	public static Authority group(String group, Boolean read, Boolean write, Boolean manage) {
		return new Authority().withGroupId(group).withRead(read).withWrite(write).withManage(manage);
	}

	public static Authority connection(String connection, Boolean read, Boolean write, Boolean manage) {
		return new Authority().withConnectionId(connection).withRead(read).withWrite(write).withManage(manage);
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
	
	
	public boolean can(String user, List<String> groups) {
		if (user==null) {
			user = SecurityUtil.getPrincipalName();
		}
		if (this.username!=null && this.username.equals(user)) {
			return true;
		}
		if (groupId!=null) {
			if (groups!=null && groups.contains(groupId)) {
				return true;
			}
		}
		return false;		
	}

	public boolean canRead(String user, List<String> groups) {
		if (Boolean.TRUE.equals(other)) {
			return true;
		}
		if (!Boolean.TRUE.equals(read)) {
			return false;
		}
		return can(user, groups);
	}

	public boolean canWrite(String user, List<String> groups) {
		if (!Boolean.TRUE.equals(write)) {
			return false;
		}
		return can(user, groups);		
	}

	public boolean canManage(String user, List<String> groups) {
		if (!Boolean.TRUE.equals(manage)) {
			return false;
		}
		return can(user, groups);
	}

	
	public static boolean canRead(List<Authority> authorities0, String user, List<String> groups) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canRead(user, groups)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean canWrite(List<Authority> authorities0, String user, List<String> groups) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canWrite(user, groups)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean canManage(List<Authority> authorities0, String user, List<String> groups) {
		if (authorities0!=null) {
			for (Authority authority: authorities0) {
				if (authority.canManage(user, groups)) {
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


	public Object[] makeTargets() {
		List<Object> targets = new ArrayList<>();
		if (username!=null) {
			targets.add(username);
		}
		if (groupId!=null) {
			targets.add("@" + groupId);
		}
		return targets.toArray();
	}
}
