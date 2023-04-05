package org.raescott.springsecurityangular;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		return user;
	}
}
