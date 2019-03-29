/**
 * 
 */
package org.einnovator.util;

import static org.junit.Assert.*;

import static org.einnovator.util.EmailUtils.*;

import org.junit.Test;

/**
 * @author jsima
 *
 */
public class EmailUtilsTests {

	@Test
	public void test() {
		String email="tdd@einnovator.org";
		assertTrue(validEmail(email));
		assertEquals("tdd", emailToUsername(email));
		assertEquals("Tdd", emailToUserDisplayName(email));
		assertEquals("einnovator.org", emailToDomain(email));
		assertEquals("einnovator", emailToProperDomain(email));
		assertEquals("Einnovator", emailToDomainDisplayName(email));

	}

}
