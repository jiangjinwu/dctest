package com.dc.function.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.dc.function.user.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String name);
}
