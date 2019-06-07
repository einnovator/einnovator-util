/**
 * 
 */
package org.einnovator.util.security;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 */
public interface UserTokenProvider {

	OAuth2AccessToken setupToken();
}
