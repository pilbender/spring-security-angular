package org.raescott.springsecurityangular;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@EnableWebSecurity
public class SecurityConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Bean // comment this line to not have this configuration wired in
	@Order(1)
	public SecurityFilterChain basicFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/basic/**")
			.authorizeRequests(expressionInterceptUrlRegistry -> {
				expressionInterceptUrlRegistry.requestMatchers("/basic/resource").authenticated();
			})
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.httpBasic();
		return http.build();
	}

	//@Bean // comment this line to not have this configuration wired in
	// @Order(1) // No order defaults to last
	public SecurityFilterChain formFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher("/**")
			.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
				authorizationManagerRequestMatcherRegistry
					.requestMatchers("**").permitAll()
					.requestMatchers(
			   "/index.html",
						"/",
						"/home",
						//"/login",
						//"/logout",
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
			.formLogin(form -> form
				.loginPage("/login")
				.permitAll())
			.logout().logoutUrl("/logout").deleteCookies("JSESSIONID")
			.and()
			.csrf().disable();
		return http.build();
	}

	/*
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		return inMemoryUserDetailsManager;
	}
	 */
}
