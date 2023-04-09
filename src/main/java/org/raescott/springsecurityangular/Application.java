package org.raescott.springsecurityangular;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@SpringBootApplication
@RestController
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("basic/resource")
	public Map<String, Object> home() {
		Map<String, Object> content = new HashMap<>();
		content.put("content", "Hello Big Bad World");
		return content;
	}

	/**
	 * Useful trick in a Spring Security application. If the "/user" resource is reachable, then it will return the
	 * currently authenticated user (an Authentication), and otherwise Spring Security will intercept the request and send
	 * 401 response through an AuthenticationEntryPoint.
	 * @param user
	 * @return
	 */
	@RequestMapping("user")
	public Principal user(Principal user) {
		if (user != null) {
			logger.info("user: {}", user.getName());
		} else {
			logger.info("user: {}", user);
		}
		return user;
	}
}
