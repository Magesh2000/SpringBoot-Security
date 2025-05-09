package com.product.application.security.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.product.application.entity.UserEntity;
import com.product.application.repo.UsersRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserEntity user = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		return new User(user.getUserName(), user.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
	}

}
