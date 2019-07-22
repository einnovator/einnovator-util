package org.einnovator.util;

import static org.springframework.util.StringUtils.hasText;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Map;

import org.einnovator.util.script.TextTemplates;
import org.springframework.util.StringUtils;

public class UriUtils {
	
	public static final String DEFAULT_ENCODING = "UTF-8";
	public static final String[] SUBROOT_DOMAINS = {"com", "co", "gov", "edu", "net", "org"};
	

	public static URI makeURI(String uri) {
		try {
			return new URI(uri);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}		
	}

	public static URI appendQueryParameters(URI uri, Object... objs) {
		for (Object obj: objs) {
			uri = appendFormattedQueryParameters(uri, MappingUtils.toMap(obj));			
		}
		return uri;
	}

	public static URI appendQueryParameters(URI uri, Object obj) {
		return appendFormattedQueryParameters(uri, MappingUtils.toMap(obj));
	}

	public static URI appendQueryParameters(URI uri, Map<String, String> params) {
		if (params!=null) {
			for (Map.Entry<String, String> e: params.entrySet()) {
				uri = appendQueryParameter(uri, e.getKey(), e.getValue());
			}
		}
		return uri;
	}
	
	public static URI appendFormattedQueryParameters(URI uri, Map<String, Object> params) {
		if (params!=null) {
			for (Map.Entry<String, Object> e: params.entrySet()) {
				uri = appendQueryParameter(uri, e.getKey(), e.getValue().toString());
			}			
		}
		return uri;
	}

	public static URI appendQueryParameter(URI uri, String name, Object value) {
		return appendQueryParameter(uri, name, value, DEFAULT_ENCODING);
	}

	public static URI appendQueryParameter(URI uri, String name, Object value, String encoding) {
		try {

			String query = uri.getRawQuery();
			String queryFragment = name + "=" + URLEncoder.encode(value.toString(), encoding);
			if (query == null) {
				query = queryFragment;
			}
			else {
				query = query + "&" + queryFragment;
			}

			// first form the URI without query and fragment parts, so that it doesn't re-encode some query string chars // (SECOAUTH-90)
			URI update = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uri.getPath(), null,	null);
			// now add the encoded query string and the then fragment
			StringBuffer sb = new StringBuffer(update.toString());
			sb.append("?");
			sb.append(query);
			if (uri.getFragment() != null) {
				sb.append("#");
				sb.append(uri.getFragment());
			}

			return new URI(sb.toString());

		}
		catch (URISyntaxException e) {
			throw new IllegalArgumentException("Could not parse URI", e);
		}
		catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("Could not encode URI", e);
		}		
	}
	
	public static String encodePath(String path, String encoding) {
		if(StringUtils.hasText(path)) {
			try {
				return org.springframework.web.util.UriUtils.encodePath(path, encoding);				
			} catch (UnsupportedEncodingException e) {
			}
		}
		return path;
	}
	
	public static String encode(String path) {
		return encode(path, DEFAULT_ENCODING);
	}

	
	public static String encode(String path, String encoding) {
		if(StringUtils.hasText(path)) {
			try {
				return org.springframework.web.util.UriUtils.encode(path, encoding);				
			} catch (UnsupportedEncodingException e) {
			}
		}
		return path;
	}
	
	public static String decode(String path) {
		return decode(path, DEFAULT_ENCODING);
	}

	public static String decode(String path, String encoding) {
		if(StringUtils.hasText(path)) {
			try {
				return org.springframework.web.util.UriUtils.decode(path, encoding);				
			} catch (UnsupportedEncodingException e) {
			}
		}
		return path;
	}

	public static String extractId(URI uri) {
		return uri.toString().substring(uri.toString().lastIndexOf("/") + 1);
	}

	private static TextTemplates templates = new TextTemplates();

	public static  String parseUri(String uri, Map<String, String> hosts) {
		return parseUri(uri, hosts, null);
	}

	public static  String parseUri(String uri, Map<String, String> hosts, Map<String, Object> env) {
		if (env!=null) {
			uri = templates.expand(uri, env);			
		}
		if (StringUtils.hasText(uri)) {
			uri = uri.trim();
			if (!uri.contains("//")) {
				String key = uri;
				String suffix = "";
				int i = uri.indexOf("/");
				if (i==0 && uri.length()>1) {
					key = uri.substring(1);
					i = key.indexOf("/", 1);
				}
				if (i>0 && i<key.length()) {
					suffix = key.substring(i);
					key = key.substring(0, i);
				}
				if (hosts!=null) {
					String uri2 = hosts.get(key);
					if (StringUtils.hasText(uri2)) {
						uri = uri2 + suffix;
					}					
				}
			}				
		} else {
			uri = null;
		}
		return uri;
	}

	public static String qualify(String uri, String prefix) {
		if (hasText(uri)) {
			if (!(uri.startsWith("http:") || uri.startsWith("https:") || uri.startsWith("/"))) {
				return PathUtil.concat(prefix, uri);
			}
		}
		return uri;
	}

	public static String encodeId(String userId) {
		if (userId == null) {
			return null;
		}
		userId = userId.replace(".", "@@");
		userId = encode(userId);
		return userId;
	}

	public static String decodeId(String userId) {
		if (userId == null) {
			return null;
		}
		userId = decode(userId);
		userId = userId.replace("@@", ".");
		userId = userId.replace(" ", "+");
		return userId;
	}
	
	public static boolean isAbsolute(String uri) {
		if (StringUtils.hasText(uri)) {
			uri = uri.trim();
			return uri.contains("://") || uri.startsWith("/");
		}
		return false;
	}
	
	public static String getHost(String uri) {
		URI uri_ = makeURI(uri);
		if (uri_==null) {
			return null;
		}
		String host =  uri_.getHost();
		host = host.trim().toLowerCase();
		if (host.length()>1 && host.endsWith(".")) {
			host = host.substring(0, host.length()-1);
		}
		return host;
	}

	public static String getDomain(String uri) {
		String host = getHost(uri);
		if (host==null) {
			return null;
		}
		int n = StringUtils.countOccurrencesOf(host, ".");
		if (n<=1) {
			return host;
		}
		int i = host.indexOf(".");
		if (i>0 && i<host.length()-1) {
			return host.substring(i+1);
		}
		return host;
	}
	
	
	public static String getProperDomain(String uri) {
		String domain = getDomain(uri);
		if (domain==null) {
			return null;
		}
		int i = domain.lastIndexOf(".");
		if (i>0 && i<domain.length()-1) {
			domain = domain.substring(0, i);
		}
		i = domain.lastIndexOf(".");
		if (i>0 && i<domain.length()-1) {
			if (subrootDomain(domain.substring(i+1))) {
				domain = domain.substring(0, i);				
			}
		}
		domain = domain.replace('.', ' ').trim();
		return domain;
	}
	
	public static String getDomainName(String uri) {
		String domain = getProperDomain(uri);
		int i = domain.lastIndexOf(".");
		if (i>0 && i<domain.length()-1) {
			domain = domain.substring(i+1);
		}
		return domain;
	}

	public static boolean subrootDomain(String domain) {
		if (ArrayUtil.contains(SUBROOT_DOMAINS, domain)) {
			return true;
		}
		return false;
	}


}
