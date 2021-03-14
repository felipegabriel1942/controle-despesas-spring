package com.felipegabriel.controledespesas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.felipegabriel.controledespesas.model.entity.User;
import com.felipegabriel.controledespesas.model.repository.UserRepository;

@Repository
public class UserDetailImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetail userDetail = new UserDetail();

		User user = repository.findByEmail(username).orElse(null);

		if (user == null) {
			return null;
		}

		userDetail.setId(user.getId());
		userDetail.setEmail(user.getEmail());
		userDetail.setUserPassword(user.getUserPassword());

		return userDetail;

	}

}
