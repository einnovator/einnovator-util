/**
 * 
 */
package org.einnovator.util.security;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 */
public interface ClientTokenProvider {

	OAuth2AccessToken setupToken();
}
