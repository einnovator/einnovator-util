package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.einnovator.util.model.EntityBase;

public class AuthorityBuilder extends EntityBase {

	private String username;

	private String groupId;

	private String connection;

	private Boolean other;

	private Boolean read;

	private Boolean write;

	private Boolean manage;

	private List<String> roles;

	private List<String> permissions;
	
	protected Object userData;

	protected Object groupData;

	protected Object roleData;

	public AuthorityBuilder username(String username) {
		this.username = username;
		return this;
	}
	
	public AuthorityBuilder group(String group) {
		this.groupId = group;
		return this;
	}

	public AuthorityBuilder roles(String... roles) {
		return roles(Arrays.asList(roles));
	}
	
	public AuthorityBuilder roles(List<String> roles) {
		if (this.roles==null) {
			this.roles = new ArrayList<>();
		}
		this.roles.addAll(roles);
		return this;
	}

	public AuthorityBuilder permissions(String... permissions) {
		return permissions(Arrays.asList(permissions));
	}

	public AuthorityBuilder permissions(List<String> permissions) {
		if (this.permissions==null) {
			this.permissions = new ArrayList<>();
		}
		this.permissions.addAll(permissions);
		return this;
	}

	public AuthorityBuilder connection(String connection) {
		this.connection = connection;
		return this;
	}


	public AuthorityBuilder other(Boolean other) {
		this.other = other;
		return this;
	}

	public AuthorityBuilder read(Boolean read) {
		this.read = read;
		return this;
	}


	public AuthorityBuilder write(Boolean write) {
		this.write = write;
		return this;
	}

	public AuthorityBuilder manage(Boolean manage) {
		this.manage = manage;
		return this;
	}

	public AuthorityBuilder other() {
		return other(true);
	}

	public AuthorityBuilder read() {
		return read(true);
	}

	public AuthorityBuilder write() {
		return write(true);
	}

	public AuthorityBuilder manage() {
		return manage(true);
	}
	
	public AuthorityBuilder userData(Object userData) {
		this.userData = userData;
		return this;
	}

	public AuthorityBuilder groupData(Object groupData) {
		this.groupData = groupData;
		return this;
	}

	public AuthorityBuilder roleData(Object roleData) {
		this.roleData = roleData;
		return this;
	}

	public Authority build() {
		Authority authority = new Authority();
		authority.setUsername(username);
		authority.setGroupId(groupId);
		authority.setRoles(roles);
		authority.setPermissions(permissions);		
		authority.setConnection(connection);
		authority.setOther(other);
		authority.setRead(read);
		authority.setWrite(write);
		authority.setManage(manage);
		authority.setUserData(userData);
		authority.setGroupData(groupData);
		authority.setRoleData(roleData);

		return authority;
	}
}
