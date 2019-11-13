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

import com.furb.prog3.trab3.domain.entity.AuthorityEntity;
import com.furb.prog3.trab3.domain.entity.UserEntity;
import com.furb.prog3.trab3.repository.UserRepository;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	public UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String login) {
		String lowercaseLogin = login.toLowerCase();
		UserEntity userFromDatabase = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);

		if (userFromDatabase == null) {
			throw new UsernameNotFoundException("Usuário " + lowercaseLogin + " não encontrado");
		} else if (!userFromDatabase.isActivated()) {
			throw new UserNotActivatedException("Usuário " + lowercaseLogin + " não está ativo");
		}

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (AuthorityEntity authority : userFromDatabase.getAuthorities()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getName());
			grantedAuthorities.add(grantedAuthority);
		}

		return new org.springframework.security.core.userdetails.User(userFromDatabase.getUsername(),
				userFromDatabase.getPassword(), grantedAuthorities);
	}

}
