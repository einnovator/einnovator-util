/**
 * 
 */
package org.einnovator.util.security;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 */
public interface ClientTokenProvider {

	OAuth2AccessToken setupToken();
	
	OAuth2RestTemplate makeOAuth2RestTemplate();
}
