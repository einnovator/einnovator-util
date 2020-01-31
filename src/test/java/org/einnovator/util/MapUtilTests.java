/**
 * 
 */
package org.einnovator.util;

import org.junit.Test;

/**
 *
 */
public class MapUtilTests {

	@Test
	public void test() {
		System.out.println(MapUtil.format(new Object[] {1,2,3}));
		System.out.println(MapUtil.format(new Boolean[] {true,false,true}));
		System.out.println(MapUtil.format(new boolean[] {true,false,true}));

	}

}
