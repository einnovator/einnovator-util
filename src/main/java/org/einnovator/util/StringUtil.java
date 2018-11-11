package org.einnovator.util;

import static org.einnovator.util.CharacterUtil.isUpperCase;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import java.lang.reflect.*;

/**
 * Miscellaneous utility methods related with {@code String}.
 *
 *
 */
public class StringUtil {
	public static int TAB = 2;
	
	public static void repeat(char c, int n, PrintStream s) {
		for (int i=0; i<n; i++) {
			s.print(c);
		}
	}

	public static void repeat(char c, int n, PrintWriter s) {
		for (int i=0; i<n; i++) {
			s.print(c);
		}
	}

	public static void repeat(char c, int n, StringBuilder sb) {
		for (int i=0; i<n; i++) {
			sb.append(c);
		}
	}

	public static void hspace(int n, PrintStream s) {
		repeat(' ', n, s);
	}
	
	public static void hspace(int n, PrintWriter s) {
		repeat(' ', n, s);
	}

	/**
	 * Return a {@code String} with the specified number of blanks (spaces).
	 * 
	 * @param n the number of blanks
	 * @return the {@code String} with blanks
	 */
	public static String hspace(int n) {
		StringBuilder sb = new StringBuilder(n);
		hspace(sb, n);
		return sb.toString();
	}

	/**
	 * Write the specified number of blanks (spaces) to a {@code StringBuilder}.
	 * 
	 * @param n the number of blanks
	 * @return the {@code String} with blanks
	 */
	public static void hspace(StringBuilder sb, int n) {
		repeat(' ', n, sb);
	}

	public static void tab(int n, PrintStream s) {
		repeat('\t', n, s);
	}
	
	public static void tab(int n, PrintWriter s) {
		repeat('\t', n, s);
	}

	public static String tab(int n) {
		StringBuilder sb = new StringBuilder(n);
		tab(sb, n);
		return sb.toString();
	}

	public static void tab(StringBuilder sb, int n) {
		repeat('\t', n, sb);
	}
	
	public static int countNonEmpty(String[] l) {
		return l.length - countEmpty(l);
	}
	
	public static int countEmpty(String[] l) {
		int n = 0;
		for (String s: l) {
			if (StringUtils.isEmpty(s))  {
				n++;
			}
		}
		return n;
	}

	public static String[] removeEmpty(String[] l) {
		int n = countNonEmpty(l);
		if (n==l.length) {
			return l;
		}
		String[] l_ = new String[n];
		int i = 0;
		for (String s: l) {
			if (!StringUtils.isEmpty(s)) {
				l_[i++] = s;
			}
		}
		return l_;
	}
	
	public static boolean isBlank(String s) {
		for (int i=0; i<s.length(); i++) {
			if (!isBlank(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBlank(char c) {
		return c==' ' || c=='\t' || c=='\n';
	}
	
	public static String substringBefore(String s, String sep) {
		int i = s.indexOf(sep);
		if (i<0) {
			return null;
		}
		return s.substring(0, i);
	}

	public static String substringAfter(String s, String sep) {
		int i = s.indexOf(sep);
		if (i<0) {
			return null;
		}
		return s.substring(i+sep.length());
	}

	public static String substringBeforeLast(String s, String sep) {
		int i = s.lastIndexOf(sep);
		if (i<0) {
			return null;
		}
		return s.substring(0, i);
	}

	public static String substringAfterLast(String s, String sep) {
		int i = s.lastIndexOf(sep);
		if (i<0) {
			return null;
		}
		return s.substring(i+1);
	}
	
	public static String substringBeforeNonNull(String s, String sep) {
		String prefix = substringBefore(s, sep);
		return prefix==null ? s : prefix;
	}

	public static String substringAfterNonNull(String s, String sep) {
		String suffix = substringAfter(s, sep);
		return suffix==null ? s : suffix;
	}

	public static String substringBeforeLastNonNull(String s, String sep) {
		String prefix = substringBeforeLast(s, sep);
		return prefix==null ? s : prefix;
	}

	public static String substringAfterLastNonNull(String s, String sep) {
		String suffix = substringAfterLast(s, sep);
		return suffix==null ? s : suffix;
	}
	
	public static void print(String s, List<?> l, boolean inline) {
		if (inline) {
			System.out.print(s);
		} else {
			System.out.println(s);		
		}
		print(l, inline, System.out);
	}
	
	public static void print(List<?> l, boolean inline) {
		print(l, inline, System.out);
	}

	
	public static void print(List<?> l, boolean inline, PrintStream out) {
		print(l.toArray(), inline, out);
	}

	public static void print(Object[] l) {		
		print(l, true, System.out);
	}

	public static void print(Object[] l, boolean inline) {		
		print(l, inline, System.out);
	}
	public static void print(Object[] l, boolean inline, PrintStream out) {		
		out.printf("[");
		int n = 0;
		for (Object obj: l) {
			out.printf("%s", obj);
			if (n<l.length-1) out.print(", ");		
			if (!inline) out.println();
			n++;
		}
		out.printf("]%n");		
	}

	public static void print(Map<?,?> map, boolean inline) {
		print(map, inline, System.out);
	}
	
	public static void print(Map<?,?> map, boolean inline, PrintStream out) {
		@SuppressWarnings("unchecked")
		Set<Map.Entry<Object,Object>> le = ((Map<Object,Object>)map).entrySet();
		out.printf("[");
		int n = 0;
		for (Map.Entry<Object, Object> e: le) {		
			out.printf("%s = %s", e.getKey(), e.getValue());
			if (n<le.size()-1) out.print(", ");		
			if (!inline) out.println();
			n++;
		}
		out.printf("]%n");
	}

	public static String lastSeg(String s, String sep) {		
		int i = s.lastIndexOf(sep);
		if (i>0) s = s.substring(i+1);
		return s;
	}
	
	public static String argsToString(Object[] args) {
		if (args==null || args.length==0) {
			return "()";
		}
		StringBuilder sb = new StringBuilder("(");
		int i = 0;
		for (Object obj: args) {
			sb.append(obj);
			i++;
			if (i<args.length) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public static String argsToString(Class<?>[] parameterTypes) {
		if (parameterTypes==null || parameterTypes.length==0) {
			return "()";
		}
		StringBuilder sb = new StringBuilder("(");
		int i = 0;
		for (Class<?> parameterType: parameterTypes) {
			sb.append(parameterType.getName());
			i++;
			if (i<parameterTypes.length) {
				sb.append(",");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	public static boolean hasPrefix(String s, String[] prefixes) {
		for (String prefix: prefixes) {
			if (s.startsWith(prefix)) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasSuffix(String s, String[] suffixes) {
		for (String suffix: suffixes) {
			if (s.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}

	public static String[] append(String[] array, String suffix) {
		for (int i=0; i<array.length; i++) {
			array[i] = append(array[i], suffix);
		}
		return array;
	}

	public static String[] prepend(String[] array, String prefix) {
		for (int i=0; i<array.length; i++) {
			array[i] = append(prefix, array[i]);
		}
		return array;
	}

	public static String append(String s1, String s2) {
		if (s1==null) {
			return s2;
		}
		if (s2==null) {
			return s1;
		}
		return s1+s2;
	}
	
	public static void append(StringBuilder sb, List<?> items, String sep) {
		int n = items.size();
		for (int i=0; i<n; i++) {
			sb.append(items.get(i).toString());
			if (i<n-1) {
				sb.append(sep);				
			}
		}
	}


	public static String toStringTuple(Object l) {
		StringBuilder sb = new StringBuilder("(");
		toString(sb, l, ",");
		sb.append(")");		
		return sb.toString();
	}

	public static String toString(Object l) {
		StringBuilder sb = new StringBuilder("[");
		toString(sb, l, ",");
		sb.append("]");
		return sb.toString();
	}

	
	
	public static void toString(StringBuilder sb, Object obj, String sep) {
		if (obj==null) {
			sb.append("null");
			return;
		}
		if (obj.getClass().isArray()) {
			int n = Array.getLength(obj);
			for (int i=0; i<n; i++) {
				sb.append(Array.get(obj, i));
				if (i<n-1) sb.append(sep);
			}
		} else {
			sb.append(obj);
		}
	}

	static String toStringTuple(Object[] l) {
		StringBuilder sb = new StringBuilder("(");
		toString(sb, l, ",");
		sb.append(")");		
		return sb.toString();
	}

	public static String toString(Object[] l) {
		return toString(l, ",");
	}

	public static String toString(Object[] l, String sep) {
		StringBuilder sb = new StringBuilder();
		toString(sb, l, sep);
		return sb.toString();
	}
	
	public static void toString(StringBuilder sb, Object[] l, String sep) {
		if (l==null) {
			return;
		}
		for (int i=0; i<l.length; i++) {
			sb.append(l[i]!=null ? l[i].toString() : "null");
			if (i<l.length-1) {
				sb.append(sep);
			}
		}
	}

	public static String toString(double[] array) {
		StringBuilder sb = new StringBuilder("[");
		for (int i=0; i<array.length; i++) {
			sb.append(Double.toString(array[i]));
			if (i<array.length-1) sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

	
	public static boolean contains(String[] array, String s) {
		for (String s2: array) {
			if (s==s2) {
				return true;
			}
			if (s!=null && s.equals(s2)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsIgnoreCase(String[] l, String s) {
		for (String s2: l) {
			if (s==s2) {
				return true;
			}
			if (s!=null && s.equalsIgnoreCase(s2)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEmpty(String[] a) {
		return a==null || a.length==0;
	}

	public static boolean equals(String s0, String s1) {
		return (s0==null && s1==null) || (s0!=null && s0.equals(s1));
	}

	public static boolean equalsIgnoreCase(String s0, String s1) {
		return (s0==null && s1==null) || (s0!=null && s0.equalsIgnoreCase(s1));
	}

	public static String sconcat(String s0, String s1, String separator)  {	
		if (s0==null) {
			return s1;
		}
		if (s1==null) {
			return s0;
		}
		s0 = s0.trim();
		s1 = s1.trim();
		if (s0.isEmpty()) {
			return s1;
		}
		if (s1.isEmpty()) {
			return s0;
		}
		boolean b0 = s0.endsWith(separator);
		boolean b1 = s1.startsWith(separator);
		if (b0 && b1) {
			return s0 + s1.substring(separator.length());
		}
		if (b0 || b1) {
			return s0 + s1;
		}
		return s0 + separator + s1;
	}

	public static String join(String[] strs, String separator)  {	
		StringBuilder sb = new StringBuilder();
		join(sb, strs, separator);
		return sb.toString();				
	}
	
	public static void join(StringBuilder sb, String[] strs, String separator)  {	
		for (int i=0; i<strs.length; i++) {
			sb.append(strs[i]);
			if (i<strs.length-1) {
				sb.append(separator);
			}
		}
	}
	
	public static String concat(String... arr)  {	
		StringBuilder sb = new StringBuilder();
		concat(sb, arr);
		return sb.toString();
	}

	public static void concat(StringBuilder sb, String... arr)  {	
		for (String s: arr) {
			if (!StringUtils.isEmpty(s)) {
				sb.append(s);				
			}
		}
	}

	
	/**
	 * Split {@code String}, if not <code>null</code> or empty.
	 * 
	 * @param s the string to split
	 * @param separator the separator RegEx
	 * @return an array with parts; or <code>null</code>, if input string is <code>null</code> or empty. 
	 */
	public static String[] split(String s, String separator) {
		return !StringUtils.isEmpty(s) ? s.split(separator) : null;
	}
	
	/**
	 * Check if a string starts with any prefix string from an array.
	 * 
	 * @param s the {@code String} to check
	 * @param a the {@code String} array with prefixes
	 * @return the input array
	 */
	public static boolean startsWith(String s, String[] a) {
		for (int i=0; i<a.length; i++) {
			if (s.startsWith(a[i])) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Trim all elements in a {@code String} array.
	 * 
	 * @param a the {@code String} array
	 * @return the input array
	 */
	public static String[] trim(String[] a) {
		for (int i=0; i<a.length; i++) {
			a[i] = a[i]!=null ? a[i].trim() : null;
		}
		return a;
	}

	/**
	 * Trim {@code String}, if not <code>null</code>.
	 * 
	 * @param s the {@code String} to trim
	 * @return the {@code String} trimmed, or <code>null</code> if input string is <code>null</code> 
	 */
	public static String trim(String s) {
		return s!=null ? s.trim() : null;
	}
	
	public static String[] selectNonEmpty(String[] a) {
		if (a==null) {
			return null;
		}
		List<String> l = new ArrayList<String>(a.length);
		for (int i=0; i<a.length; i++) {
			if (!StringUtils.isEmpty(a[i])) {
				l.add(a[i]);
			}
		}
		return l.toArray(new String[l.size()]);
	}
	
	public static String[] splitWords(String text) {
		text = text.trim();
		List<String> list = new ArrayList<String>();
		boolean prevUpper = true;
		int i0 = 0;
		for (int i=0; i<text.length(); i++) {
			boolean upper = isUpperCase(text.charAt(i));
			if (i!=0 && upper && !prevUpper) {
				list.add(text.substring(i0, i));
				i0 = i;
			}
			prevUpper = upper;
		}
		if (i0!=text.length()-1) {
			list.add(text.substring(i0, text.length()));
		}
		return list.toArray(new String[list.size()]);
	}

	public static String removeFirstWord(String text) {
		text = text.trim();
		for (int i=0; i<text.length(); i++) {
			boolean upper = isUpperCase(text.charAt(i));
			if (upper && i!=0) {
				return text.substring(i);
			}
		}
		return text;
	}

	/**
	 * Truncate a {@code String} to have a length not greater than the specified maximum length value.
	 * @param s the input string
	 * @param length the maximum length of the returned string
	 * @return the truncated string, or the input {@code String} if the length is smaller or equal to the specified lenght value.
	 */
	public static String truncate(String s, int length) {
		if (s==null) {
			return null;
		}
		return s.length()<=length ? s : s.substring(0, length);
	}
	
	/**
	 * Count the number of disjoint occurrences of a sub-string in a string.
	 * 
	 * @param s the input string
	 * @param substr the sub-string to search for occurrences
	 * @return the count of occurences
	 */
	public static int count(String s, String substr) {
		int n = 0, i=0, k = substr.length();
		while (i<s.length()) {
			i = s.indexOf(substr, i);
			if (i>=0) {
				n++;
				i = i + k;
			} else {
				break;
			}
		}
		return n;
	}
	
	/**
	 * Check if string is valid email address.
	 * 
	 * @param s the input string
	 * @return <code>true</code>, if string is a valid email address; <code>false</code>, otherwise.
	 */
	public static boolean isValidEmail(String s) {
		 String[] a = s.split("@");
		 if (a.length != 2 || StringUtils.isEmpty(a[0]) || StringUtils.isEmpty(a[1])) {
			 return false;
		 }
		 String[] d = a[1].split("\\.");
		 if (d.length<2) {
			 return false;
		 }
		 return true;
	}

	public static String[] expand(String[] array, String sep) {
		List<String> array2 = new ArrayList<String>();
		for (String s: array) {
			String[] a = s.split(sep);
			for (String s2: a) {
				array2.add(s2);
			}
		}
		return array2.toArray(new String[array2.size()]);
	}
	
	public static int wordCount(String s) {
		return count(s.trim(), " ") + 1;
	}
	
	private static Pattern pattern;
	
	/**
	 * Replaces sequences of blanks by a single space.
	 * 
	 * @param s the input string
	 * @return the transformed string
	 */
	public static String normalizeSpace(String s) {
		if (pattern==null) {
			pattern = Pattern.compile("\\s+");
		}
		return pattern.matcher(s).replaceAll(" ");	
	}
}
