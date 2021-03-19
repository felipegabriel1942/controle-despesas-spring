package com.felipegabriel.controledespesas.resource;

import java.security.NoSuchAlgorithmException;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.felipegabriel.controledespesas.dto.UserDTO;
import com.felipegabriel.controledespesas.exceptions.BusinessException;
import com.felipegabriel.controledespesas.model.entity.User;
import com.felipegabriel.controledespesas.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserResource {

	private final UserService service;
	private final ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserDTO save(@RequestBody User user) {
		try {
			User newUser = service.save(user);
			return modelMapper.map(newUser, UserDTO.class);
		} catch (BusinessException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		} catch (NoSuchAlgorithmException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criptografar senha de novo usuário.");
		}
	}
}
