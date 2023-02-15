package com.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.model.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByUsernameAndPassword(String username, String password);
}
