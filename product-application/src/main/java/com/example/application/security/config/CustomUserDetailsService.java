package com.example.application.security.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.application.entity.UserEntity;
import com.example.application.repo.UsersRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		//Fetch user from database
		UserEntity user = userRepository.findByUserName(userName)
		.orElseThrow( () -> new UsernameNotFoundException("User not found") );
		
		return new User(user.getUserName(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("USER_ROLE")));
	}
	
	
}
