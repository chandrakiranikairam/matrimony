package com.matrimony.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matrimony.dao.AdminDao;
import com.matrimony.entity.Customer;
import com.matrimony.exception.UserNotFoundException;

@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private AdminDao aDao;

	@Override
	public List<Customer> findAllCustomers() {
		List<Customer> list=new ArrayList<>();
		aDao.findAll().forEach(list1->list.add(list1));
		return list;
	}



	@Override
	public Customer addCustomer(Customer cust) {
		aDao.save(cust);
		return cust;
	}


	@Override
	public boolean deleteCustomer(Integer customerId) {
		if(!aDao.existsById(customerId)) {
			throw new UserNotFoundException("the customer is not found for the entered address id : "+customerId);
			
		}
		aDao.deleteById(customerId);
		return true;
	}

	@Override	
	public boolean editCustomer(Customer custom) {
		    deleteCustomer(custom.getCustomerId());
			aDao.save(custom);
			return true;
	}



	}



