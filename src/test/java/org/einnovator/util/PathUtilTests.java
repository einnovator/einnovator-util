/**
 * 
 */
package org.einnovator.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author jsima
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
