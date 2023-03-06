package com.matrimony.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matrimony.entity.Customer;

@Service
public interface CustomerService {


//	Customer addCustomer(Customer add);
//
//	Customer updateCustomer(Customer customer);
//
//	boolean deleteCustomer(Integer custId);


	List<Customer> findAllCustomers();
	
	Customer addCustomer(Customer add);



	boolean editCustomer(Customer address);

	boolean deleteCustomer(Integer customerId);



	

}
