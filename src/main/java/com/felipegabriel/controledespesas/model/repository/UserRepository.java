package com.felipegabriel.controledespesas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.felipegabriel.controledespesas.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
