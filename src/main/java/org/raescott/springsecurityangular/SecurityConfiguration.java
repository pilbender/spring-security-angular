package org.raescott.springsecurityangular;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@Configuration
public class SecurityConfiguration {

	@Bean
	@Order(1)
	public SecurityFilterChain basicFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/basic/**")
			.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
				authorizationManagerRequestMatcherRegistry
					.requestMatchers("/basic/resource").authenticated();
			})
			.httpBasic(withDefaults());
		return http.build();
	}

	@Bean
	@Order(2)
	public SecurityFilterChain formFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**")
			.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
				authorizationManagerRequestMatcherRegistry
					.requestMatchers("**").permitAll()
					.requestMatchers(
			   "/index.html",
						"/",
						"/home",
						"/login",
						"/static/**",
						"/**/*.js",
						"/**/*.css",
						"/**/*.png",
						"/**/*.jpg",
						"/**/*.ico",
						"/**/*.woff",
						"/**/*.woff2",
						"/**/*.ttf"
					).permitAll()
					.requestMatchers("/**").authenticated();
			})
			.formLogin(withDefaults());
		return http.build();
	}
}
