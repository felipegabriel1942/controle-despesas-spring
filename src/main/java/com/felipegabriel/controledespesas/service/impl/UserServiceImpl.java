package com.felipegabriel.controledespesas.service.impl;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

import com.felipegabriel.controledespesas.exceptions.BusinessException;
import com.felipegabriel.controledespesas.model.entity.User;
import com.felipegabriel.controledespesas.model.repository.UserRepository;
import com.felipegabriel.controledespesas.security.Md5;
import com.felipegabriel.controledespesas.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository repository;

	@Override
	public User save(User user) throws NoSuchAlgorithmException {
		validate(user);
		user.setUserPassword(Md5.md5Encripter(user.getUserPassword()));
		return repository.save(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(User user) {
		if (!emailIsValid(user)) {
			throw new BusinessException("Informe um email válido.");
		}
		
		if (!passwordIsValid(user)) {
			throw new BusinessException("Informe uma senha válida.");
		}
		
		if (emailAlreadyExists(user)) {
			throw new BusinessException("Já existe usuário cadastrado com esse e-mail.");
		}
	}

	@Override
	public boolean emailIsValid(User user) {
		return user.getEmail() != null && !user.getEmail().isEmpty();
	}

	@Override
	public boolean passwordIsValid(User user) {
		return user.getUserPassword() != null && !user.getUserPassword().isEmpty();
	}

	@Override
	public boolean emailAlreadyExists(User user) {
		return getUserByEmail(user) != null;
	}
	
	@Override
	public User getUserByEmail(User user) {
		return repository.findByEmail(user.getEmail()).orElse(null);
	}

}
