package com.dc.function.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.dc.function.user.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long>  {

	Privilege findByName(String name);
}
