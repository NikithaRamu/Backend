package com.nikitha.fsd.auth.service;

import com.nikitha.fsd.auth.model.User;
import com.nikitha.fsd.auth.util.exception.UserAlreadyExistsException;
import com.nikitha.fsd.auth.util.exception.UserNotFoundException;

public interface UserAuthService {
	
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
