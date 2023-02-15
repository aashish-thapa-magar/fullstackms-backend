package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authservice.model.UserEntity;
import com.authservice.service.UserEntityService;

@RestController
public class UserEntityController {
	
	private UserEntityService userEntityService;
	
	
	@Autowired
	public UserEntityController(UserEntityService userEntityService) {
		this.userEntityService = userEntityService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserEntity userEntity){
		try {
			userEntityService.saveUserEntity(userEntity);
			return new ResponseEntity<>(userEntity, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody UserEntity userEntity){
		try {
			if(userEntity.getUsername() == null || userEntity.getPassword() == null) {
				throw new Exception("Username or Password not found");
			}
			
			UserEntity userInfo = userEntityService.findUserByUsernameAndPassword
					(userEntity.getUsername(), userEntity.getPassword());
			if(userInfo == null) {
				throw new Exception("Username or Password is invalid");
			}
			
			return new ResponseEntity<>(userEntity,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
}
