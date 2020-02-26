/**
 * 
 */
package org.einnovator.util.script;

import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

/**
 *
 */
public class ScriptExpressionResolver implements ExpressionResolver {

	private ScriptEngine engine;
	
	private boolean silent;
	
	private ScriptContext context;
	
	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 * @param engine the {@code ScriptEngine}
	 * @param silent true if expression evaluation errors should return true
	 */
	public ScriptExpressionResolver(ScriptEngine engine, boolean silent) {
		this.engine = engine;
		this.silent = silent;
	}

	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 * @param engineFactory the {@code engineFactory}
	 * @param silent true if expression evaluation errors should return true
	 */
	public ScriptExpressionResolver(ScriptEngineFactory engineFactory, boolean silent) {
		this(engineFactory.getScriptEngine(), silent);
	}

	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 * @param lang a language
	 * @param manager a {@code ScriptEngineManager}
	 * @param silent true if expression evaluation errors should return true
	 */
	public ScriptExpressionResolver(String lang, ScriptEngineManager manager, boolean silent) {
		this(getScriptEngine(lang, manager), silent);
	}

	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 */
	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 * @param lang a language
	 * @param silent true if expression evaluation errors should return true
	 */
	public ScriptExpressionResolver(String lang, boolean silent) {
		this(getScriptEngine(lang, new ScriptEngineManager()), silent);
	}
	
	/**
	 * Create instance of {@code ScriptExpressionResolver}.
	 *
	 * @param lang a language
	 * @param silent true if expression evaluation errors should return true
	 * @param context optional context
	 */
	public ScriptExpressionResolver(String lang, boolean silent, Object context) {
		this(lang, silent);
		if (context!=null) {
			setContext(context);
		}
	}

	/**
	 * Get the value of property {@code engine}.
	 *
	 * @return the engine
	 */
	public ScriptEngine getEngine() {
		return engine;
	}

	/**
	 * Set the value of property {@code engine}.
	 *
	 * @param engine the engine to set
	 */
	public void setEngine(ScriptEngine engine) {
		this.engine = engine;
	}

	/**
	 * Get the value of property {@code silent}.
	 *
	 * @return the silent
	 */
	public boolean isSilent() {
		return silent;
	}

	/**
	 * Set the value of property {@code silent}.
	 *
	 * @param silent the silent to set
	 */
	public void setSilent(boolean silent) {
		this.silent = silent;
	}

	/**
	 * Get the value of property {@code context}.
	 *
	 * @return the context
	 */
	public ScriptContext getContext() {
		return context;
	}

	/**
	 * Set the value of property {@code context}.
	 *
	 * @param context the context to set
	 */
	public void setContext(ScriptContext context) {
		this.context = context;
		if (engine!=null) {
			engine.setContext(this.context);
		}
	}

	@SuppressWarnings("unchecked")
	public void setContext(Object context) {
		if (context instanceof ScriptContext) {
			this.context = (ScriptContext) context;
		} else if (context instanceof Map) {
			this.context = makeContext((Map<String, Object>)context, ScriptContext.ENGINE_SCOPE);				
		}		
		if (engine!=null) {
			engine.setContext(this.context);
		}
	}
	
	@Override
	public Object eval(String expression, Object context) {
		try {
			if (this.context==null && context!=null) {
				setContext(context);
			}
			return engine.eval(expression);
		} catch (ScriptException e) {
			if (silent) {
				return null;
			}
			throw new RuntimeException(e);
		}
	}

	protected ScriptContext makeContext(Map<String, Object> env, int scope) {
		SimpleScriptContext context = new SimpleScriptContext();
		if (env!=null) {
			for (Map.Entry<String, Object> e: env.entrySet()) {
				context.setAttribute(e.getKey(), e.getValue(), scope);
			}
		}
		return context;
	}
	public static ScriptEngine getScriptEngine(String name, ScriptEngineManager manager) {
		ScriptEngine engine = manager.getEngineByName(name);
		if (engine!=null) {
			return engine;
		}
		engine = manager.getEngineByExtension(name);
		if (engine!=null) {
			return engine;
		}
		engine = manager.getEngineByMimeType(name);
		if (engine!=null) {
			return engine;
		}
		return null;
	}
} 
