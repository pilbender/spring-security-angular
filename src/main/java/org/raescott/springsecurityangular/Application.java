package org.raescott.springsecurityangular;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@SpringBootApplication
@RestController
public class Application {
	@RequestMapping("resource")
	public Map<String, Object> home() {
		Map<String, Object> content = new HashMap<>();
		content.put("content", "Hello Big Bad World");
		return content;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
