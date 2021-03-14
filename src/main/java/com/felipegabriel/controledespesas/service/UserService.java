package com.felipegabriel.controledespesas.service;

import java.security.NoSuchAlgorithmException;

import com.felipegabriel.controledespesas.model.entity.User;

public interface UserService {
	
	public User save(User user) throws NoSuchAlgorithmException;
	
	public void update(User user);
	
	public User getUserByEmail(User user);
	
	public void validate(User user);
	
	public boolean emailIsValid(User user);
	
	public boolean passwordIsValid(User user);
}
