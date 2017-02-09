package com.dc.function.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.dc.function.user.model.UserInfo;

public interface UserRepository  extends CrudRepository<UserInfo, Long> {

}
