/**
 * 
 */
package org.einnovator.util;

import static org.junit.Assert.*;
import static org.einnovator.util.StringUtil.*;

import org.junit.Test;

/**
 *
 */
public class StringUtilTests {

	@Test
	public void test() {
		assertEquals("some-test_identifier", normalizeIdentifier(" some test_identifier !!", '-', new char[] {'_'}));
		assertEquals("some-test-identifier", normalizeIdentifier(" some test_identifier !!", '-', null));

		assertEquals("someTest_identifier", normalizeJavaIdentifier(" some test_identifier !!"));

	}
	@Test
	public void tailTest() {
		String s1 = "111\n";
		String s2 = "222\n";
		String s3 = "333\n";
		String s4 = "444\n";
		String s5 = "555\n";

		String s = s1+s2+s3+s4+s5;
		assertEquals(s4+s5, tail(s, 2));
		assertEquals(s5, tail(s, 1));
		assertEquals(s, tail(s, 5));
		assertEquals(s, tail(s, 6));

	}
}
