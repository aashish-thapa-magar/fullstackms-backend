package com.authservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authservice.model.Role;
import com.authservice.repository.RoleRepository;
import com.authservice.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public String createRole(Role role) {
		roleRepo.save(role);
		return "Successfully created " + role.getRoleName() + " role";
	}

}
