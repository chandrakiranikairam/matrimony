package com.matrimony.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.matrimony.dao.AdminDao;
import com.matrimony.entity.Mediator;
import com.matrimony.exception.UserNotFoundException;

@Component
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao aDao;

	@Override
	public Mediator addMediator(Mediator mediator) {
		aDao.save(mediator);
		return mediator;
	}

	@Override
	public boolean editMediator(Mediator med) {
		 deleteMediator(med.getMediatorId());
			aDao.save(med);
			return true;
	}

	@Override
	public boolean deleteMediator(Integer medId) {
		if(!aDao.existsById(medId)) {
			throw new UserNotFoundException("the mediator is not found for the entered mediator id : "+medId);
			
		}
		aDao.deleteById(medId);
		return true;}}
	



