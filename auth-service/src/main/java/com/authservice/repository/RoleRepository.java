package com.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
