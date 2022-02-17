package com.casestudy.employeessystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.casestudy.employeessystem.models.CustomUserDetails;
import com.casestudy.employeessystem.models.User;
import com.casestudy.employeessystem.repositories.IUserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		return new CustomUserDetails(user);
	}
	

}
