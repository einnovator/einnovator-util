/**
 * 
 */
package org.einnovator.util.security;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.einnovator.util.security.AuthorityUtil.*;

/**
 * A {@code AuthorityUtilTests}.
 *
 * @author support@einnovator.org
 *
 */
public class AuthorityUtilTests {

	@Test
	public void test() {
		check("tdd:rwx-");
		check("@123123:rw--");
		check("%xx:rw--");
		checkN("tdd:rwx-;@123123:rw--;%xx:rw--");

	}

	private void check(String s) {
		assertEquals(s, serialize(parse(s)));
	}

	private void checkN(String s) {
		assertEquals(s, serialize(parseN(s)));
	}

}
