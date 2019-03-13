package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.einnovator.util.model.EntityBase;

public class AuthorityBuilder extends EntityBase {

	private String user;

	private String group;

	private String role;

	private String connection;

	private Boolean other;

	private Boolean read;

	private Boolean write;

	private Boolean manage;

	private List<String> permissions;

	public AuthorityBuilder user(String user) {
		this.user = user;
		return this;
	}
	
	public AuthorityBuilder group(String group) {
		this.group = group;
		return this;
	}

	public AuthorityBuilder role(String role) {
		this.role = role;
		return this;
	}

	public AuthorityBuilder connection(String connection) {
		this.connection = connection;
		return this;
	}

	public AuthorityBuilder permissions(String... permissions) {
		if (permissions!=null) {
			if (this.permissions==null) {
				this.permissions = new ArrayList<>();
			}
			this.permissions.addAll(Arrays.asList(permissions));
		}
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

	public Authority build() {
		Authority authority = new Authority();
		authority.setUser(user);
		authority.setGroup(group);
		authority.setRole(role);
		authority.setPermissions(permissions);		
		authority.setConnection(connection);
		authority.setOther(other);
		authority.setRead(read);
		authority.setWrite(write);
		authority.setManage(manage);
		return authority;
	}
}
