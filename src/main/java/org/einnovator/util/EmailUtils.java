package org.einnovator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailUtils {

	public static final String[] SUBROOT_DOMAINS = {"com", "co", "gov", "edu", "net", "org"};
	
	public static boolean validEmail(String email) {
		if (email == null) {
			return false;			
		}
		if (!email.contains("@")) {
			return false;
		}
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(email).matches();
	}
	

	public static List<String> validEmails(List<String> emails, List<String> invalid) {
		if (emails == null) {
			return null;
		}
		List<String> emails2 = new ArrayList<String>();
		for (String email : emails) {
			if (validEmail(email)) {
				emails2.add(email);
			} else {
				invalid.add(email);
			}
		}
		return emails2;
	}

	public static String emailToDomain(String email) {
		int i = email.indexOf("@");
		if (i<0 || i==email.length()-1) {
			return null;
		}
		String domain = email.substring(i+1);
		domain = domain.toLowerCase();
		return domain;
	}
	
	public static String emailToProperDomain(String email) {
		String domain = emailToDomain(email);
		if (domain==null) {
			return null;
		}
		int i = domain.lastIndexOf(".");
		if (i>0 && i<domain.length()-1) {
			domain = domain.substring(0, i);
		}
		i = domain.lastIndexOf(".");
		if (i>0 && i<domain.length()-1) {
			if (subrootDomain(domain.substring(i+1))) {
				domain = domain.substring(0, i);				
			}
		}
		domain = domain.replace('.', ' ').trim();
		return domain;
	}
	
	public static boolean subrootDomain(String domain) {
		if (ArrayUtil.contains(SUBROOT_DOMAINS, domain)) {
			return true;
		}
		return false;
	}


	public static String emailToUsername(String email) {
		int i = email.indexOf("@");
		if (i<0 || i==email.length()-1) {
			return null;
		}
		String username = email.substring(0, i);
		return username.trim();
	}

	public static String emailToUserDisplayName(String email) {
		String username = emailToUsername(email);
		if (username==null) {
			return null;
		}
		String displayName = StringUtil.replaceSpecialChars(username, " ");
		displayName = StringUtil.capitalizeWords(displayName);
		return displayName;
	}

	public static String emailToDomainDisplayName(String email) {
		String domain = emailToProperDomain(email);
		if (domain==null) {
			return null;
		}
		String displayName = StringUtil.replaceSpecialChars(domain, " ");
		displayName = StringUtil.capitalizeWords(displayName);
		return displayName;
	}

}