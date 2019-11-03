package com.furb.prog3.trab3.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.furb.prog3.trab3.domain.Authority;
import com.furb.prog3.trab3.domain.User;
import com.furb.prog3.trab3.repository.UserRepository;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {
		String lowercaseLogin = login.toLowerCase();
		User userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);

		if (userFromDatabase == null) {
			throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
		} else if (!userFromDatabase.isActivated()) {
			throw new UserNotActivatedException("User " + lowercaseLogin + " is not activated");
		}

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Authority authority : userFromDatabase.getAuthorities()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
			grantedAuthorities.add(grantedAuthority);
		}

		return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(),
				userFromDatabase.getPassword(), grantedAuthorities);
	}

}
