package org.einnovator.util;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.einnovator.util.script.TestUser;
import org.junit.jupiter.api.Test;


public class MappingUtilsTests {

	@Test
	public void toPropertiesTest() {
		TestUser user = new TestUser("123", "tdd@einnovator.org");
		Map<String, Object> env = MappingUtils.toMap(user);
		System.out.println(env);
	}
	
	public static class Obj {
		Boolean b;

		public Boolean getB() {
			return b;
		}

		public void setB(Boolean b) {
			this.b = b;
		}
		
		
	}
	
	@Test
	public void updateObjectFromTest() {
		Obj x = new Obj();
		x.b = false;
		Obj y = new Obj();
		y.b = true;
		MappingUtils.updateObjectFrom(x, y);
		assertTrue(x.b);
	}
	
}
