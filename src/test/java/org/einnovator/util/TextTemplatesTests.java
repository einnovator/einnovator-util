package org.einnovator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.einnovator.util.MappingUtils;
import org.einnovator.util.script.TextTemplates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TextTemplatesTests {

	TextTemplates templates = new TextTemplates();

	public static class A {
		private String x;
		public A() {
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void expandTest() {
		String text = makeTestMessage();
		Map<String, Object> env = new LinkedHashMap<>();
		env.put("username", "tdd");
		env.put("email", "tdd@einnovator.org");
		env.put("firstName", "Tdd");
		env.put("lastName", "Test");
		env.put("name", "Tdd Test");

		env.put("token", "123456789");
		env.put("link-confirm", "http://example.com");
		A a = new A();
		a.x = "abc";
		env.put("a", a);
		Map<String, Object> b = new LinkedHashMap<>();
		env.put("b", b);
		b.put("y", "qwerty");
		Map<String, Object> c = new LinkedHashMap<>();
		c.put("y", "zxcv");
		b.put("c", c);
		String result = templates.expand(text, env);
		System.out.println(result);
		assertTrue(result.indexOf("Welcome, " + env.get("name") + "!")==0);
		assertTrue(result.indexOf(env.get("link-confirm")+"?username="+env.get("username")+"&token="+env.get("token"))>0);
		assertTrue(result.contains(a.x));
		assertTrue(result.contains(b.get("y").toString()));
		assertTrue(result.contains(((Map<String,Object>)b.get("c")).get("y").toString()));

	}
	
	@Test
	public void expandCustomMarkersTest() {
		TextTemplates t = new TextTemplates("{", "}");
		Map<String, Object> env = new LinkedHashMap<>();
		env.put("username", "tdd");
		String s = t.expand("/home/{username}", env);
		assertEquals("/home/"+env.get("username"), s);
	}

	
	public String makeTestMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome, ${name}!\n\n");
		sb.append("Follow the link below to activate you account:\n\n");
		String link = "${link-confirm}?username=${username}&token=${token}";
		sb.append("<a href=\"" + link+"\">"+link + "</a>\n\n");
		sb.append("${a.x}");
		sb.append("${b.y}");
		sb.append("${b.c.y}");

		return sb.toString();
	}
	
	
	
	@Test
	public void expandStructuredTest() {
		String text = makeTestMessage2();
		TestUser user = new TestUser("12", "tdd@einnovator.org");
		Map<String, Object> env = new LinkedHashMap<>();
		env.putAll(MappingUtils.toMap(user));
		String result = templates.expand(text, env);
		System.out.println(result);
		assertTrue(result.indexOf("Welcome, " + env.get("username") + "!")==0);
	}

	public String makeTestMessage2() {
		StringBuilder sb = new StringBuilder();
		sb.append("Welcome, ${username}!\n\n");
		return sb.toString();
	}
}
