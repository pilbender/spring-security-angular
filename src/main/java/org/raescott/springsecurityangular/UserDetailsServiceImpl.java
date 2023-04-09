package org.raescott.springsecurityangular;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//UserDetails userDetails = User.builder().username("user").password("password").authorities("USER").build();

		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		inMemoryUserDetailsManager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
		return inMemoryUserDetailsManager.loadUserByUsername(username);
	}
}
