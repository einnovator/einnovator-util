package org.einnovator.util.meta;

import java.lang.reflect.Method;
import java.util.function.Predicate;

public class MethodPredicates {
	public static class SetterPredicate implements Predicate<Method> {
		public static SetterPredicate singleton = new SetterPredicate();
		
		@Override
		public boolean test(Method mt) {
			return MetaUtil.isSetter(mt);
		}

	}

	public static class GetterPredicate implements Predicate<Method> {
		public static GetterPredicate singleton = new GetterPredicate();
		
		@Override
		public boolean test(Method mt) {
			return MetaUtil.isGetter(mt);
		}

	}
}
