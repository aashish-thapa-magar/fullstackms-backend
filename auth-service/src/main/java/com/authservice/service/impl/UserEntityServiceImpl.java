package com.authservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.authservice.model.UserEntity;
import com.authservice.repository.UserEntityRepository;
import com.authservice.service.UserEntityService;

@Service
public class UserEntityServiceImpl implements UserEntityService{
	
	@Autowired
	UserEntityRepository userEntityRepo;
	
	@Override
	public void saveUserEntity(UserEntity userEntity) {
		userEntityRepo.save(userEntity);
	}

	@Override
	public UserEntity findUserByUsernameAndPassword(String username, String password) throws Exception {
		UserEntity userEntity = userEntityRepo.findByUsernameAndPassword(username, password);
		
		if(userEntity == null) {
			throw new Exception("Invalid Id and password");
		}
		
		SecurityContext context= SecurityContextHolder.createEmptyContext();
		Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
		context.setAuthentication(authentication);
		SecurityContextHolder.setContext(context);
		
		return userEntity;
	}

}
