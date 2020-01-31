/**
 * 
 */
package org.einnovator.util.security;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.einnovator.util.MappingUtils;
import org.junit.Test;

/**
 * @author support@einnovator.org
 *
 */
public class AuthorityTests {

	private static final String TEST_USER = "tdd@einnovator.org";
	private static final String TEST_GROUP = UUID.randomUUID().toString();

	@Test
	public void test() {
		List<Authority> authorities = new ArrayList<>();
		authorities.add((Authority.user(TEST_USER, true, true, true)));				
		authorities.add((Authority.group(TEST_GROUP, true, false, false)));						
		for (Authority authority: authorities) {
			System.out.println(authority);		
		}
		System.out.println(MappingUtils.toJson(authorities));		

	}

}
