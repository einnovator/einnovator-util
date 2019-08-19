/**
 * 
 */
package org.einnovator.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 */
public class StringUtilTests {

	@Test
	public void test() {
		assertEquals("some-test_identifier", StringUtil.normalizeIdentifier(" some test_identifier !!", '-', new char[] {'_'}));
		assertEquals("some-test-identifier", StringUtil.normalizeIdentifier(" some test_identifier !!", '-', null));

		assertEquals("someTest_identifier", StringUtil.normalizeJavaIdentifier(" some test_identifier !!"));

	}

}
