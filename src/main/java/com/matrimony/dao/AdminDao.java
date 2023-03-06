package com.matrimony.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matrimony.entity.Customer;
import com.matrimony.entity.Mediator;

@Repository
public interface AdminDao extends JpaRepository<Customer,Integer>{

	void save(Mediator mediator);

}
