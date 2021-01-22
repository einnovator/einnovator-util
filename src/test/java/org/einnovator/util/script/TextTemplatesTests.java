package org.einnovator.util.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

import org.einnovator.util.MappingUtils;
import org.junit.jupiter.api.Test;


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
	
	
	@Test
	public void expandWithDefaultTest() {
		Map<String, Object> env = new LinkedHashMap<>();
		TextTemplates t = new TextTemplates();
		String s = t.expand("ab${x:123}", env);
		assertEquals("ab123", s);
		TextTemplates t2 = new TextTemplates();
		t2.setSeparator("::");
		String s2 = t2.expand("ab${x::123}", env);
		assertEquals("ab123", s2);
	}

	@Test
	public void scriptTest() {
		for (ScriptEngineFactory factory: new ScriptEngineManager().getEngineFactories()) {
			System.out.println(factory + " " + factory.getLanguageName() + " " + factory.getEngineName() + " " + factory.getMimeTypes());
		}

		String lang = "application/javascript";
		ScriptExpressionResolver resolver = new ScriptExpressionResolver(lang, false);

		assertNotNull(resolver.getEngine());

		Map<String, Object> env = new LinkedHashMap<>();
		env.put("a", 1);
		env.put("b", 2);
		env.put("c", "C");
		assertEquals(3.0, resolver.eval("a+b", env));
		assertEquals("3C", resolver.eval("a+b+c", env));


		ScriptExpressionResolver resolver2 = new ScriptExpressionResolver(lang, false, env);
		
		TextTemplates templates2 = new TextTemplates(resolver2);
		assertEquals("3.0", templates2.expand("${a+b}", env));
		assertEquals("xx3.0yy", templates2.expand("xx${a+b}yy", env));
		assertEquals("xx3Cyy", templates2.expand("xx${a+b+c}yy", env));
		
		ScriptExpressionResolver resolver1 = new ScriptExpressionResolver(lang, false);

		TextTemplates templates = new TextTemplates(resolver1);
		assertEquals("3.0", templates.expand("${a+b}", env));
		assertEquals("xx3.0yy", templates.expand("xx${a+b}yy", env));
		assertEquals("xx3Cyy", templates.expand("xx${a+b+c}yy", env));

		assertEquals("x", templates.expand("${a==0 ? 0 : 'x'}", env));
		
	}
	
	public String makeTestMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("Test, ${name}!\n\n");
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
