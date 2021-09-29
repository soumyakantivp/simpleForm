package com.registration.simple.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.registration.simple.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, String>{
	
}
