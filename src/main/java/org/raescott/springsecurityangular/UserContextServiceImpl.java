package org.raescott.springsecurityangular;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@Service
public class UserContextServiceImpl implements UserContextService {
	@Override
	public String getCurrentUserId() {
		/*
		 * When a 404 page is generated, the authentication is null, so we need
		 * to protect against a null pointer exception in that case
		 */
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			return SecurityContextHolder.getContext().getAuthentication().getName();
		} else {
			return "anonymousUser";
		}
	}

	@Override
	public Authentication getCurrentAuthentication() {
		/*
		 * When a 404 page is generated, the authentication is null, so we need
		 * to protect against a null pointer exception in that case
		 */
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			return SecurityContextHolder.getContext().getAuthentication();
		} else {
			return null;
		}
	}
}
