/**
 * 
 */
package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.StringUtil;
import org.einnovator.util.security.Authority;

/**
 * A {@code AuthorityUtil}.
 *
 * @author support@einnovator.org
 *
 */
public class AuthorityUtil {
	public static String serialize(Authority authority) {
		return serialize(authority, new StringBuilder());
	}

	public static String serialize(Authority authority, StringBuilder sb) {
		if (StringUtil.hasText(authority.getUsername())) {
			sb.append(authority.getUsername());
		} else if (StringUtil.hasText(authority.getGroupId())) {
			sb.append("@");
			sb.append(authority.getGroupId());
		} else if (StringUtil.hasText(authority.getConnectionId())) {
			sb.append("%");
			sb.append(authority.getConnectionId());
		}
		if (sb.length()==0) {
			return null;
		}
		sb.append(":");
		sb.append(Boolean.TRUE.equals(authority.getRead()) ? "r" : "-");
		sb.append(Boolean.TRUE.equals(authority.getWrite()) ? "w" : "-");
		sb.append(Boolean.TRUE.equals(authority.getManage()) ? "x" : "-");
		sb.append(Boolean.TRUE.equals(false /*authority.getComment()*/) ? "c" : "-");
		return sb.toString();
	}
	
	public static String serialize(List<Authority> authorities) {
		if (authorities==null || authorities.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (Authority authority: authorities) {
			if (authority==null) {
				continue;
			}
			if (sb.length()>0) {
				sb.append(";");
			}
			serialize(authority, sb);
		}
		return sb.toString();
	}
	
	public static Authority parse(String s) {
		if (s==null) {
			return null;
		}
		s = s.trim();
		if (s.isEmpty()) {
			return null;
		}
		Authority authority = new Authority();
		int i = s.indexOf(":");
		if (i<=0 || i==s.length()-1) {
			return null;
		}
		String s0 = s.substring(0,i);
		if (s0.startsWith("@")) {
			authority.setGroupId(s0.substring(1));
		} else if (s0.startsWith("%")) {
			authority.setConnectionId(s0.substring(1));
		} else {
			authority.setUsername(s0);
		}
		s0.indexOf("@");
		String s1 = s.substring(i+1);
		if (s1.length()>=0 && s1.charAt(0)=='r') {
			authority.setRead(true);
		}
		if (s1.length()>=1 && s1.charAt(1)=='w') {
			authority.setWrite(true);
		}
		if (s1.length()>=2 && s1.charAt(2)=='x') {
			authority.setManage(true);
		}
		if (s1.length()>=3 && s1.charAt(3)=='c') {
			//authority.setComment(true);
		}
		return authority;
	}

	public static List<Authority> parseN(String s) {
		if (s==null || s.trim().isEmpty()) {
			return null;
		}
		List<Authority> authorities = new ArrayList<>();
		String[] aa = s.split(";");
		for (String a: aa) {
			Authority authority = parse(a);
			if (authority!=null) {
				authorities.add(authority);
			}
		}
		return authorities;
	}
}
