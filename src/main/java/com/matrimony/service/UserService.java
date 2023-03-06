package com.matrimony.service;

import org.springframework.stereotype.Service;

import com.matrimony.entity.UserDetails;


@Service
public interface UserService {
	
	UserDetails login(UserDetails userDetails);

	boolean add(UserDetails user);
}
