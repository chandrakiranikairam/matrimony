package com.matrimony.service;

import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matrimony.dao.UserDao;
import com.matrimony.entity.UserDetails;
import com.matrimony.exception.AuthenticationFailedException;
import com.matrimony.exception.InvalidUserRoleException;
import com.matrimony.exception.UserAlreadyExistException;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao uDao;
	
	@Override
	public UserDetails login(UserDetails userDetails) {
		System.out.println(uDao);
		String role = "";
		Optional<UserDetails> op = uDao.findById(userDetails.getUserId());
        if(!op.isPresent()){
            throw new AuthenticationFailedException("No User found for username="+userDetails.getUserId());
        }
		UserDetails uDetails = op.get();
		if(!userDetails.getPassword().equals(uDetails.getPassword())) {
            throw new AuthenticationFailedException("Authentication failed for username="+userDetails.getUserId());
		}
		role = uDetails.getUserRole();
		return uDetails ;
	}
	@Override
	public boolean add(UserDetails user) {
		if(uDao.existsById(user.getUserId())) {
			throw new UserAlreadyExistException("You have already registered to Great Outdoors. please log in");
		}
		if (user.getUserRole().equalsIgnoreCase("Admin") || user.getUserRole().equalsIgnoreCase("mediator")
				||user.getUserRole().equalsIgnoreCase("customer")|| user.getUserRole().equalsIgnoreCase("manager")) {
				uDao.save(user);
		}
		else {
			throw new InvalidUserRoleException("Invalid UserRole");
		}
		return true;
	}
}
