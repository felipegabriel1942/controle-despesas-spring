package com.felipegabriel.controledespesas.service;

import com.felipegabriel.controledespesas.model.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public void update(User user);
	
	public User getUserByEmail(User user);
}
