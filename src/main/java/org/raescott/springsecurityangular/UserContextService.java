package org.raescott.springsecurityangular;

import org.springframework.security.core.Authentication;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
public interface UserContextService {
	String getCurrentUserId();
	Authentication getCurrentAuthentication();
}
