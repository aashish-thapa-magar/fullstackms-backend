package com.authservice.service;

import com.authservice.model.UserEntity;

public interface UserEntityService {
	
	public void saveUserEntity(UserEntity userEntity);
	
	public UserEntity findUserByUsernameAndPassword(String username, String password) throws Exception;
}
