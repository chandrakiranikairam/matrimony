package com.matrimony.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Customer;
import com.matrimony.entity.UserDetails;


@Repository
public interface UserDao extends JpaRepository<UserDetails,Integer>{

	Customer getByUserId(Integer customerId);
}

