/**
 * 
 */
package org.einnovator.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author support@einnovator.org
 *
 */
public class PathUtilTests {

	@Test
	public void test() {
		assertEquals("/a/b/c", PathUtil.concatAll("/a","b", "c"));
		assertEquals("a/b/c", PathUtil.concatAll("a","b", "c"));
		assertEquals("a/b/c", PathUtil.concatAll("a","/b", "c"));
		assertEquals("a/b/c", PathUtil.concatAll("a/","/b", "c"));
		assertEquals("a/b/c", PathUtil.concatAll("a/","b", "/c"));
		
	}

}
