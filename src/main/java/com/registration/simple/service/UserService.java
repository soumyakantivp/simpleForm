package com.registration.simple.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.simple.dao.UserRepo;
import com.registration.simple.exception.DuplicateUserException;
import com.registration.simple.exception.InvalidEmailException;
import com.registration.simple.model.User;

@Service
public class UserService {
	@Autowired
	UserRepo repo;

	public final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	public void addUser(User user) throws DuplicateUserException, InvalidEmailException {
		if(repo.findById(user.getEmail()).equals(Optional.empty())) {
			if(!validate(user.getEmail())) {
				throw new InvalidEmailException("email is invalid");
			}
			repo.save(user);
		}
		else
			throw new DuplicateUserException("email is already registered!");
	}
}
